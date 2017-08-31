package com.ganesh.scalatest.features

import com.ganesh.scalatest.examples.Calculator
import org.scalatest.PrivateMethodTester.PrivateMethod
import org.scalatest.{Matchers, PrivateMethodTester, WordSpec}

class PrivateMethodTest extends WordSpec with Matchers with PrivateMethodTester{

  "should test private method in ClassWithPrivateMethod" in {
    val privateMethod = PrivateMethod[Int]('testPrivateAdd)
    val result = Calculator invokePrivate privateMethod(1,2)
    result shouldBe 3
  }

}
