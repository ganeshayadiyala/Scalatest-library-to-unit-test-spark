package com.ganesh.scalatest.fixtures

import org.scalatest.{BeforeAndAfterEach, WordSpec}

import scala.collection.mutable.ListBuffer

class BeforeAndAfterTest extends WordSpec with BeforeAndAfterEach{
  val builder = new StringBuilder
  val buffer = new ListBuffer[String]

  override def beforeEach() {
    builder.append("ScalaTest is ")
  }

  override def afterEach() {
    builder.clear()
    buffer.clear()
  }

  "testing the builder value" in {
    builder.append("easy!")
    assert(builder.toString === "ScalaTest is easy!")
    assert(buffer.isEmpty)
    buffer += "sweet"
  }

  "testing the builder and buffer value again" in {
    builder.append("fun!")
    assert(builder.toString === "ScalaTest is fun!")
    assert(buffer.isEmpty)
    buffer += "clear"
  }
}
