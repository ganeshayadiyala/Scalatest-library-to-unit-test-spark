package com.ganesh.scalatest.features

import java.io.File

import org.scalactic.StringNormalizations._
import org.scalatest.{Matchers, WordSpec}

class MatchersTest extends WordSpec with Matchers{
  "should use different ways of asserting using matchers" in {
      val result = 3
      result should be (3)
      result should === (3)
      result shouldEqual 3
      result shouldBe 3
      result shouldEqual 3 +- 1
  }

  "should test array equality" in {
    Array(1, 2) should equal (Array(1, 2))
  }

  "should check if the strings are equal without considering case" in {
    "HI" should equal ("Hi") (after being lowerCased)
  }

  "should check the length of the list" in {
    val list = List(1,2,3)
    list should have length 3
    list should have size 3
  }

  "should do some of the special matchers" in {
    val tmp = File.createTempFile("hello", "world") // create the fixture
    tmp should be a 'file
  }

  "should check the class of an object" in {
    case class Employee(name:String)
    val employee = Employee("Jane")
    employee shouldBe a [Employee]
  }

  "checking the values of a custom object" in {
    case class Book(title:String,author:String)
    val book = Book("SomeBook","Jane")
    book should have (
    'title ("SomeBook"),
    'author ("Jane")
    )
  }

}
