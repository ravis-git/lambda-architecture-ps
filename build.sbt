import Dependencies._

val sparkVersion = "1.6.0"
val chillVersion = "0.7.2"
val algebirdVersion = "0.11.0"
val kafkaClientsVersion = "0.8.2.1"
val avroVersion = "1.7.7"
val sparkCassandraConnectorVersion = "1.6.1"
val cassandraDriverCoreVersion = "3.0.1"
val nscalaTimeVersion = "2.6.0"
val slf4jVersion = "1.7.7"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "lambda-architecture-ps",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.typesafe" % "config" % "1.3.0"
    ),
    // logging
    libraryDependencies ++= Seq("org.slf4j" % "slf4j-api" % "1.7.5",
      "org.slf4j" % "slf4j-simple" % "1.7.5"),

    libraryDependencies ++= Seq(
      "com.datastax.spark" % "spark-cassandra-connector_2.11" % sparkCassandraConnectorVersion,
      "com.datastax.cassandra" % "cassandra-driver-core" % cassandraDriverCoreVersion,
      "com.github.nscala-time" % "nscala-time_2.11" % nscalaTimeVersion,
      "org.apache.kafka" % "kafka-clients" % kafkaClientsVersion,
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      "com.twitter" % "chill_2.11" % chillVersion,
      "com.twitter" % "chill-avro_2.11" % chillVersion,
      "com.twitter" % "algebird-core_2.11" % algebirdVersion,
      "org.apache.spark" % "spark-core_2.11" % sparkVersion % "compile",
      "org.apache.kafka" % "kafka_2.11" % kafkaClientsVersion,
      "org.apache.spark" % "spark-streaming_2.11" % sparkVersion % "compile",
      "org.apache.spark" % "spark-sql_2.11" % sparkVersion % "compile",
      "org.apache.spark" % "spark-streaming-kafka_2.11" % sparkVersion,
      "org.apache.spark" % "spark-streaming-kafka-assembly_2.11" % sparkVersion,
      "org.apache.spark" % "spark-mllib_2.11" % sparkVersion % "compile",
      "org.apache.spark" % "spark-hive_2.11" % sparkVersion % "compile",
      "joda-time" % "joda-time" % "2.8.1",
      "org.joda" % "joda-convert" % "1.7"
    )
    
  )
