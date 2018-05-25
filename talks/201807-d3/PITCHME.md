### Why did we move from AWS to GCP?
#### (Big data with Google Dataflow)

---
#### About me

<div class="left">
    <ul>
        <li class="text-highlight">Kotaro Nishiyama</li>
        <li>Yokoyama, Japan</li>
        <li>Engineer at Stanby, BizReach, Inc.</li>
        <li>Scala, Java, Play, Apache Beam/Dataflow, Statistics</li>
        <li>Japanese</li>     
    </ul>
</div>
<div class="right">
    <ul>
        <li class="text-highlight">Stefan Meier</li>
        <li>Switzerland</li>
        <li>Lead Engineer at Stanby, BizReach, Inc.</li>
        <li>Scala, Java, Play, Apache Beam/Dataflow, TypeScript/React</li>
        <li>Swiss Engineering Award 2012</li>
        <li>Swiss-German, German, French, English, Japanese</li>
    </ul>
</div>

---
#### Before we start
How many of you are:
- Infrastructure/application engineers?
- Big data specialists?
- Consultants?

---
#### Table of contents

- What is Stanby?
- What is the challenge with big data?
- How did Stanby manage big data with AWS?
- What does GCP offer for big data?
- GCP at Stanby
- Questions
- Demo
- Summary
- Questions/discussion

---
### What is Stanby?

---
#### Stanby = Job search engine

![PIC](assets/img/stanby_page.png)

---
### What is big data, what are the challenges?

---
#### Big data

"Big data is data sets that are so <span class="text-highlight">voluminous</span> and <span class="text-highlight">complex</span> that <span class="text-highlight">traditional data-processing</span> application software [is] <span class="text-highlight">inadequate</span> to deal with them.”

<span class="smallText">Source: [Wikipedia](https://en.wikipedia.org/wiki/Big_data), fetched on 2018/07/11</span>

---
#### Examples of big data

<div class="left">
    <ul>
        <li class="text-highlight">Data</li>
        <li>Server/application logs</li>
        <li>Tracking data</li>
        <li>Customer data</li>   
        <li>Patient data</li>     
    </ul>
</div>
<div class="right">
    <ul>
        <li class="text-highlight">Usage</li>
        <li>Bio-medical research</li>
        <li>Financial analysis</li>
        <li>Marketing</li>
        <li>Business analytics/reports</li>
        <li>Road traffic</li>
        <li>Education</li>
        <li>Fraud detection</li>
    </ul>
</div>

---
#### Streaming vs. batch processing

<div class="left">
    <ul>
        <li class="text-highlight">Batch</li>
        <li>Time-differed processing</li>
        <li>e.g. business analytics, reports, decision making</li>
    </ul>
</div>
<div class="right">
    <ul>
        <li class="text-highlight">Streaming</li>
        <li>‎Near real-time processing</li>
        <li>Unordered data & delays</li>
        <li>e.g. fraud detection, real-time monitoring</li>
    </ul>
</div>

<p class="smallText" style="clear: both; padding-top: 50px;">fraud detection = 詐欺検出</p>

---
#### Streaming data

![PIC](assets/img/streaming_data.png)

<span class="smallText">Source: Medium, [Give meaning to 100 billion analytics](https://medium.com/teads-engineering/give-meaning-to-100-billion-analytics-events-a-day-d6ba09aa8f44), fetched on 2018/07/03</span>

---
#### Other challenges

- Removing noise
- Breaking down the problem (i.e. divide and conquer)

<span class="smallText">
分割統治法は、そのままでは解決できない大きな問題を小さな問題に分割し、その全てを解決することで、最終的に最初の問題全体を解決する、という問題解決の手法である
</span>

---
### How did Stanby manage big data with AWS?

---

#### AWS overview

![PIC](assets/img/stanby_aws.png)

Note:
- AWS S3 for data storing
- AWS EMR for combining/cleaning data in Hadoop clusters
- Apache Airflow for scheduling tasks and data pipelines
- AWS Athena for preparing data for visualization

---
#### AWS challanges

- Applications engineers are dependant on infrastructure engineers
- Laborious process of updating existing workflow/processing logic
- Log data becomes too large to manage in Elastichsearch
- Impossible to connect with data stored in Google

=> Explore alternatives

---
### What does GCP offer for big data?

---
#### Service overview

- Cloud storage
- BigQuery
- Pub/Sub
- Dataproc
- Dataflow
- Stackdriver
- Cloud functions

---
#### Cloud storage

- High scalable object storage
- Type: Multi regional, Regional, Nearline, Coldline
- Fully-managed
- Similar to AWS S3
- Google Transfer Protocol (transfer from S3)

---
#### BigQuery

- Enteprise data warehouse
- Standard SQL
- Fully-managed
- Billing for data storage, streaming inserts, querying data
- Similar to AWS Redshift

---
#### Pub/Sub

- Event-driven stream ingestion/delivery service
- Fully-managed
- Used to connect different GCP services
- Similar to AWS SNS

---
#### Google Dataproc

- Managed Spark & Hadoop
- Similar to AWS EMR

---
#### Google Dataflow

- Stream/Batch data processing
- Fully-managed
- Auto-scaling
- Unified programming model (Apache Beam SDK)
- Billing per second based on used workers
- No similar service on AWS

---
#### Cloud functions

- Run/deploy code without infrastructure (serverless)
- Fully-managed
- Similar to AWS Lambda

---
#### Stackdriver

- Monitoring, logging, and diagnostics for applications 
- Fully-managed
- Similar to AWS CloudWatch

---
#### AWS vs. GCP

<div class="left">
    <ul>
        <li class="text-highlight">AWS</li>
        <li>Many services</li>
        <li>Complex management</li>
    </ul>
</div>
<div class="right">
    <ul>
        <li class="text-highlight">GCP</li>
        <li>Specific services</li>
        <li>Mostly fully-managed</li>
    </ul>
</div>

---
### How did we move from AWS to GCP?
#### How do we use GCP?

---
### Data collection

![PIC](assets/img/aws_gcp_acquisition.png)

---
#### GCP at Stanby

![PIC](assets/img/stanby_gcp.png)

---
#### Apache Beam
- Unified programming model for batch & streaming
- Open-sourced by Google
- Runner independent
- Java, Scala, Python, Go

---
#### Spotify Scio
- Scala API for Apache Beam and Google Dataflow
- Integration with big data-related GCP products
- Type safe BigQuery

---
#### Key results

- Application Engineers can focus on enhancing big data analytics workflows without relying on infrastructure engineers
- Decrease infrastructure complexity
- Decrease the amount of code by moving code from Spark to Apache Beam (=> unified programming model for batch and streaming)
- Benefits of the Google ecosystem
- Connection with Google Analytics and other Google services related to SEO and search

---
### Demo

---
### Demo app

<div class="left">
<span class="text-highlight">Application</span>

![PIC](assets/img/demo_app.png)
</div>
<div class="right">
<span class="text-highlight">GCP Schema</span>

![PIC](assets/img/demo_schema.png)
</div>


---
#### Summary

- AWS offers complex services, which need infrastructure engineers
- GCP offers managed services, which makes software engineers more independent
- By combining AWS and GCP, teams can solve problems in better ways

---
### Further readings

- [The world beyond batch: Streaming 101 - English](https://www.oreilly.com/ideas/the-world-beyond-batch-streaming-101)
- [The world beyond batch: Streaming 102 - English](https://www.oreilly.com/ideas/the-world-beyond-batch-streaming-102)
- [Apache Beam and Spark: New coopetition for squashing the Lambda Architecture? - English](https://www.zdnet.com/article/apache-beam-and-spark-new-coopetition-for-squashing-the-lambda-architecture/)
- [The world beyond batch: Streaming 101 - 日本語](https://qiita.com/kimutansk/items/447df5795768a483caa8)
- [The world beyond batch: Streaming 102 - 日本語](https://qiita.com/kimutansk/items/c6b7cccd976ff00cb1fd)

---
### Survey
https://goo.gl/forms/4uGeukZEPbBN3GBQ2

![PIC](assets/img/survey.png)

---
### Disclaimer

<span class="smallText">
The views and opinions expressed in this article are those of the author and do not necessarily reflect the official policy of BizReach, Inc.
<span>