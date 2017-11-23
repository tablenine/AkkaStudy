package example.future

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.io.Source
import scala.util.{Try, Success, Failure}
object FutureExceptions extends App {
  val file = Future {Source.fromFile(".project").getLines().mkString("\n")}
  
  file.foreach(text => println(text))
  
  file.failed.foreach { 
    case fnfe: java.io.FileNotFoundException => println(s"Cannot find file - $fnfe")
    case t => println(s"Failed due to $t")
  }
  
  println("\n------------------------------------------------------\n")
  
  file.onComplete { 
    case Success(text) => println("aa" + text + "bb")
    case Failure(t) => println(s"Failed due to $t")
  }
  
  Thread.sleep(1000*10)
}