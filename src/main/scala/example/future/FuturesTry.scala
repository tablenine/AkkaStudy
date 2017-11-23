package example.future

import scala.util._

object FuturesTry extends App {
  val threadName: Try[String] = Try(Thread.currentThread().getName)
  val someText: Try[String] = Try("Try objects are created synchronously")
  val message: Try[String] = for {
    tn <- threadName
    st <- someText
  } yield s"$st, t = $tn"
  
  message match {
    case Success(msg) => println(s"aa $msg bb")
    case Failure(error) => println(s"There should bo no $error here")
  }
  
  Thread.sleep(1000*10)
}