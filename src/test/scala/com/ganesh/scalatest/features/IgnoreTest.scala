package com.ganesh.scalatest.features

import org.scalatest.{Ignore, WordSpec}


//@Ignore
class IgnoreTest extends WordSpec{

  "should ignore the test case" ignore {
    assert(1===2)
  }

  "should be ignored only when classLevel Ignore is specified" in {
    assert(1!=2)
  }
}
