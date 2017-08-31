package com.ganesh.scalatest.specs

import org.scalatest.FlatSpec

class FlatSpecTest extends FlatSpec{
  behavior of "An empty Set"

  it should "have size 0" in {
    assert(Set.empty.size === 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  "Single valued set" should "have size 0" in {
    assert(Set(1).size === 1)
  }

  it should "produce NoSuchElementException when an element is dropped and head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set(1).drop(1).head
    }
  }

}
