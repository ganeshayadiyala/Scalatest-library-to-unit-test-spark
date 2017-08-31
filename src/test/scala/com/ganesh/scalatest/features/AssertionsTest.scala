package com.ganesh.scalatest.features

import org.scalatest.Assertions._
import org.scalatest.WordSpec

class AssertionsTest extends WordSpec {
  "should run few simple assertions" in {
    val i = 1
    val j = 2
    assert(i != j)
   // assert(i == j || i > j)
  }

  "should assert some unrecognized expressions" in {
    val xs = List(1,2,3)
    //assert(None.isDefined)
    //assert(xs.exists(i => i > 10))
  }

  "should provide our own message if in case assert fails" in {
    val i = 1
   // assert(i == 2, "value of i should be 1")
  }

  "should use assertResult to assert complex expressions" in {
    val a = 1
    val b = 2
    val c = 3
    assertResult(4) {
      ((a + c - b) * 10) / 5
    }
  }

  "should force fail using assertion" in {
  //  fail("this test is failed because of fail api")
  }

  "should expect the exception when passing invalid index to charAt function" in {
    val string = "hi"
    assertThrows[IndexOutOfBoundsException] {
      string.charAt(-1)
    }
  }

  "should expect the exception and catch that exception using intercept" in {
    val string = "hi"
    val exception =
      intercept[IndexOutOfBoundsException] {
        string.charAt(-1)
      }
    assert(exception.getMessage.indexOf("-1") != -1)
  }

  "should cancel the testcase" in {
    cancel("cancelled testcase because the time taken exceeds the limit")
  }




}
