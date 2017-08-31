package com.ganesh.scalatest.sparkstreaming

import java.io.File
import java.nio.file.Files

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Milliseconds, Seconds, StreamingContext}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

class EnvironmentInitializerSSC extends WordSpec with Matchers with BeforeAndAfterAll{
  private val master = "local[2]"
  private val appName = "example-spark"

  var sc: SparkContext = _
  var ssc: StreamingContext = _
  var clock: ClockWrapper = _

  private val checkpointDir = Files.createTempDirectory(appName).toString

  override def beforeAll() {
    val conf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)
      .set("spark.streaming.clock", "org.apache.spark.util.ManualClock")

    sc = SparkSession.builder().config(conf).getOrCreate().sparkContext
    ssc = new StreamingContext(sc,Seconds(10))
    clock = new ClockWrapper(ssc)
  }

  override def afterAll() {
    if (sc != null) {
      sc.stop()
      new File(checkpointDir).delete()
    }
  }
}
