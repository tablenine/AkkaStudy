package example

import scala.collection.mutable.ArrayBuffer

object TestFuture extends App {
  def randomInt(from: Int, to: Int): Int = {
    Thread.sleep(1000)
    (from + (to - from + 1) * Math.random()).toInt
  }
  
  val list = List.fill(10) {randomInt(100, 200)}
  
  val buf = ArrayBuffer.empty[Int]
  val threads = ArrayBuffer.empty[Thread]
  
  for (i <- 1 to 10) {
    val thread = new Thread(new Runnable() {
    override def run() {
      val n = randomInt(100, 200)
      buf.synchronized { buf += n }
    }
  })
    thread.start()
    threads += thread
  }
  
  for (thread <- threads)
    thread.join()
  println(buf.toList)
}