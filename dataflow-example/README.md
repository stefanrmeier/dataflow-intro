# Dataflow example

## Setup

```
# Install homebrew (see: http://brew.sh/)
$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# Install brew cask (see: https://caskroom.github.io/)
$ brew tap caskroom/cask

# Install JDK 8
$ brew tap caskroom/versions
$ brew cask install java8

# Install JEnv
$ brew install jenv
$ brew cask install java8
$ echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.bash_profile
$ echo 'eval "$(jenv init -)"' >> ~/.bash_profile
# Add JDK 8 to jenv
$ jenv add /System/Library/Java/JavaVirtualMachines/1.8.0.jdk/Contents/Home
# Set JDK 8 as global JDK
$ jenv global oracle64-1.8.0.39  

# Install sbt (see: https://www.scala-sbt.org/release/docs/Installing-sbt-on-Mac.html)
$ brew install sbt@1

# Install Cloud SDK (see: https://cloud.google.com/sdk/install)
# Connect to gcloud
$  gcloud auth application-default login
# Initialize the SDK
$ gcloud init

```

## Deployment

```
# Enter sbt
$ sbt

# Run dataflow
$ runMain com.example.DailyCtrFlow \
--project=XXX \
--runner=DataflowRunner \
--zone=us-central1-f \
--projectId=XXX \
--numWorkers=1 \
--autoscalingAlgorithm=NONE \
--workerMachineType=n1-standard-1 \
--targetDate=20180706
```