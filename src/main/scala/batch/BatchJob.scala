package batch

import domain.Activity
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
    // input.foreach(println)
    val inputRDD = input.flatMap{ line =>
      val record = line.split("\\t")
      val MS_IN_HOUR = 1000 * 60 * 60
      if(record.length == 7)
        Some(Activity(record(0).toLong / MS_IN_HOUR * MS_IN_HOUR, record(1), record(2), record(3), record(4), record(5), record(6)))
      else
        None
    }
    val keyByProduct = inputRDD.keyBy(a => (a.product, a.timestamp_hour)).cache()
    val visitoryByProduct = keyByProduct
      .mapValues(a => a.visitor)
      .distinct()
      .countByKey()

    val activityByProduct = keyByProduct
      .mapValues{ a =>
        a.action match {
          case "purchase" => (1,0,0)
          case "add_to_cart" => (0,1,0)
          case "page_view" => (0,0,1)
        }
      }
      .reduceByKey((a,b) => (a._1 + b._1, a._2 + b._2, a._3 + b._3))

    visitoryByProduct.foreach(println)
    activityByProduct.foreach(println)
  }
}
