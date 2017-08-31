package com.ganesh.scalatest.specs

import org.scalatest.FunSuite

class FunSuitTest extends FunSuite{
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
