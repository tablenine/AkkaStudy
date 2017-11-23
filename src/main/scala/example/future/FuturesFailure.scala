package example.future

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.Source

object FuturesFailure extends App {
  val urlSpec: Future[String] = Future {
    Source.fromURL("http://www.w3.org/non-existent-url-spec.txt").mkString
  }
  
  urlSpec.failed.foreach { 
    case t => println(s"exception occurered- $t")
  }
  
  Thread.sleep(1000*10)
}