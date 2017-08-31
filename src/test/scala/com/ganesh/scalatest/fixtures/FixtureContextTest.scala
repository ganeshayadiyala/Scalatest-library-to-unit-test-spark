package com.ganesh.scalatest.fixtures

import org.scalatest.WordSpec

import scala.collection.mutable.ListBuffer


class FixtureContextTest extends WordSpec{
    trait Builder {
      val builder = new StringBuilder("ScalaTest is ")
    }

    trait Buffer {
      val buffer = ListBuffer("ScalaTest", "is")
    }

    // This test needs the StringBuilder fixture
    "testing with the string builder from fixture context" in new Builder {
      builder.append("productive!")
      assert(builder.toString === "ScalaTest is productive!")
    }

    // This test needs the ListBuffer[String] fixture
    "testing with the list buffer from fixture context" in new Buffer {
      buffer += ("readable!")
      assert(buffer === List("ScalaTest", "is", "readable!"))
    }

    // This test needs both the StringBuilder and ListBuffer
    "testing with both string builder and list buffer" in new Builder with Buffer {
      builder.append("clear!")
      buffer += ("concise!")
      assert(builder.toString === "ScalaTest is clear!")
      assert(buffer === List("ScalaTest", "is", "concise!"))
    }
}
