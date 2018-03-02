package main

import batch.BatchJob
import clickstream.LogProducer

object RunBatch extends App{

  LogProducer.loadFile
  BatchJob.printRDD
}
