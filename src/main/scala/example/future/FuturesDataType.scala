package example.future

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.Source

object FuturesDataType extends App {
  
  val myFuture: Future[String] = Future {
    val f = Source.fromFile("build.sbt")
    try f.getLines().mkString("\n") finally f.close()
  }
  
  println("started reading build file asynchronously")
  println(s"status: ${myFuture.isCompleted}" )
  Thread.sleep(250)
  println(s"status: ${myFuture.isCompleted}")
  println(s"status: ${myFuture.value}" )
}