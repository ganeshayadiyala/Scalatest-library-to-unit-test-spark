package com.ganesh.scalatest.fixtures

import org.scalatest.WordSpec

import scala.collection.mutable.ListBuffer

class GetFixtureTest extends WordSpec{
  def fixture =
    new {
      val builder = new StringBuilder("ScalaTest is ")
      val buffer = new ListBuffer[String]
    }

  "should use the fixture defined above" in {
    val f = fixture
    f.builder.append("easy!")
    assert(f.builder.toString === "ScalaTest is easy!")
    assert(f.buffer.isEmpty)
    f.buffer += "sweet"
  }

  "should reuse the fixtures defined above which gives new instance" in {
    val f = fixture
    f.builder.append("fun!")
    assert(f.builder.toString === "ScalaTest is fun!")
    assert(f.buffer.isEmpty)
  }
}
