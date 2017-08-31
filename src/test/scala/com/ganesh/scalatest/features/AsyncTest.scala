package com.ganesh.scalatest.features

import org.scalatest.AsyncWordSpec
import scala.concurrent.Future

class AsyncTest extends AsyncWordSpec{
  def addSoon(addends: Int*): Future[Int] = Future { addends.sum }

  "should eventually compute a sum of ints" in {
    val futureSum: Future[Int] = addSoon(1, 2)
    futureSum map { sum => assert(sum == 3) }
  }
}
