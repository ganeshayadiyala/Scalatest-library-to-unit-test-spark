package com.ganesh.scalatest.sparkstreaming

import com.ganesh.scalatest.examples.WordCountForStream
import org.apache.spark.rdd.RDD
import org.scalatest.concurrent.Eventually

import scala.collection.mutable
import scala.concurrent.duration._

class SparkStreamingTest extends EnvironmentInitializerSSC{
  "should do wordCount for stream of data" in {
    val lines = mutable.Queue[RDD[String]]()
    val dStream = ssc.queueStream(lines)

    val streamWordCount = WordCountForStream.count(dStream)

    val collector = mutable.MutableList[(String,Int)]()
    val input = Seq("to be or not to be", "that is the question")

    streamWordCount.foreachRDD(rdd => collector ++= rdd.collect())

    ssc.start()
    lines += sc.makeRDD(input)
    clock.advance(10000)

    Eventually.eventually(Eventually.timeout(1 minutes)){
      collector should contain allOf (("be", 2), ("is", 1), ("not", 1), ("or", 1), ("question", 1), ("that", 1), ("to", 2), ("the",1))
    }

  }
}
