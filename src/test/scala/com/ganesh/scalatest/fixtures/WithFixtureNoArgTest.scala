package com.ganesh.scalatest.fixtures

import org.scalatest.{WordSpec, Failed}

class WithFixtureNoArgTest extends WordSpec {
  override def withFixture(test: NoArgTest) = {
    super.withFixture(test) match {
      case failed: Failed =>
        info("uff!! testcase failed")
        failed
      case other => other
    }
  }

  "this test should succeed" in {
    assert(1 + 1 === 2)
  }

  "this testcase should fail" in {
    assert(1 + 1 === 3)
  }
}
