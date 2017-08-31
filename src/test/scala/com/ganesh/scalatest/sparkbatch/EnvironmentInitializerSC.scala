package com.ganesh.scalatest.sparkbatch

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

trait EnvironmentInitializerSC extends WordSpec with Matchers with BeforeAndAfterAll{
  private val master = "local[2]"
  private val appName = "example-spark"

  var sc: SparkContext = _

  override def beforeAll() {
    val conf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)

    sc = SparkSession.builder().config(conf).getOrCreate().sparkContext
  }

  override def afterAll() {
    if (sc != null) {
      sc.stop()
    }
  }
}
