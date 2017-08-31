package com.ganesh.scalatest.examples

import org.apache.spark.streaming.dstream.DStream

object WordCountForStream {
  def count(stream : DStream[String]):DStream[(String,Int)] = {
    val words = stream.flatMap(_.split(" "))
    val pairs = words.map(word => (word,1))
    val wordCount = pairs.reduceByKey(_ + _)
    wordCount.print()
    wordCount
  }
}
