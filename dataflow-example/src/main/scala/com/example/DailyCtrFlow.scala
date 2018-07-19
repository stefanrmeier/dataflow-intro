package com.example

import com.spotify.scio.bigquery._
import com.spotify.scio.bigquery.types.BigQueryType
import com.spotify.scio.{ ContextAndArgs, ScioContext }

/**
  * This examples shows how to calculate the daily CTR for all articles
  *
  * run example
  * -----------
  * GCP_PROJECT=(your GCP project id)
  *
  * sbt "runMain com.example.DailyCtrFlow
  * --project=$GCP_PROJECT
  * --runner=DataflowRunner
  * --zone=us-central1-f
  * --projectId=$GCP_PROJECT
  * --targetDate=20180718"
  * -----------
  */
object DailyCtrFlow {

  private[this] case class Impression(
    createDateTime: String,
    articleId: Long)

  private[this] case class Click(
    createDateTime: String,
    articleId: Long)

  @BigQueryType.toTable
  private[this] case class Ctr(
    createDate: String,
    articleId: Long,
    ctr: Double)

  def main(cmdlineArgs: Array[String]): Unit = {
    val (sc: ScioContext, args) = ContextAndArgs(cmdlineArgs)

    val targetDate = args("targetDate")
    val projectId = args("projectId")

    val impressionTable = s"$projectId:dataflow_example.impression_$targetDate"
    val clickTable = s"$projectId:dataflow_example.click_$targetDate"
    val ctrTable = s"$projectId:dataflow_example.ctr"

    val impressions = sc.bigQueryTable(impressionTable)
      .map(BigQueryType.fromTableRow[Impression])
      .map(_.articleId)
      .countByValue

    val clicks = sc.bigQueryTable(clickTable)
      .map(BigQueryType.fromTableRow[Click])
      .map(_.articleId)
      .countByValue

    impressions.join(clicks)
      .map { case (articleId, (impressionCount, clickCount)) =>
          Ctr(
            createDate = targetDate,
            articleId = articleId,
            ctr = clickCount.toDouble / impressionCount)
      }.saveAsTypedBigQuery(tableSpec = ctrTable, writeDisposition = WRITE_TRUNCATE, createDisposition = CREATE_IF_NEEDED)

    sc.close()
  }
}
