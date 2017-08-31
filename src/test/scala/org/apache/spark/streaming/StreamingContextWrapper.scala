package org.apache.spark.streaming

import org.apache.spark.util.ManualClock

/**
  *
  * Used for accessing manualclock of spark which is not directly accessible
  *
  * manualClock can be used when testing the streaming use cases.
  */
class StreamingContextWrapper(ssc:StreamingContext) {
  val manualClock : ManualClock = ssc.scheduler.clock.asInstanceOf[ManualClock]
}
