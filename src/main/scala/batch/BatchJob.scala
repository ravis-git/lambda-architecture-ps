package batch

import org.apache.spark.{SparkConf, SparkContext}

object BatchJob {

  def printRDD {

    // get the spark configuration
    val conf = new SparkConf()
        .setAppName("Lambda with Spark")
          .setMaster("local[*]")

    val sc = new SparkContext(conf)

    val sourceFile = "/Users/ravipalakodeti/tech/projects/fast-data/spark-kafka-cassandra-applying-lambda-architecture/vagrant/*.tsv"
    val input = sc.textFile(sourceFile)

    // spark action results in job execution
    input.foreach(println)
  }

}
