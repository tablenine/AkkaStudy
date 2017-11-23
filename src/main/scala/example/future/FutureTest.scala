package example.future

import scala.concurrent._
import ExecutionContext.Implicits.global

object FutureTest extends App {
  Future {
    println("the future is here")
  }
  
  println("the future is coming")
}