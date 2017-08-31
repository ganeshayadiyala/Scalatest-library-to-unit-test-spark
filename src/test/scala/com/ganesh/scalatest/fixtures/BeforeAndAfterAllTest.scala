package com.ganesh.scalatest.fixtures

import java.io.{File, FileWriter}

import org.scalatest.{BeforeAndAfterAll, WordSpec}

class BeforeAndAfterAllTest extends WordSpec with BeforeAndAfterAll{
  override def beforeAll() {
    println("printing before all the test case")
  }

  override def afterAll() {
    println("printing after all the test case")
  }

  "should run first test case" in {
    println("1st test case")
    succeed
  }

  "should run second test case" in {
    println("2nd test case")
    succeed
  }
}
