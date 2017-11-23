package example

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Failure
import scala.util.Success

object Test extends App{

/*  println("Start")
  val f = Future {
    println("1")
    Thread.sleep(10000) // 실제 코드가 들어갈 장소
    println("2")
   } 

  println("End")

  Await.result(f, Duration.Inf)
  */
  
/*  val f2 = Future{ println("f2hello"); "world"}
  println("f2value : " + f2.value)
  println("f2isComplred : " + f2.isCompleted)

  println("=============")
  
  val f1 = Future{ println("f1hello"); 10 + 20 }
  println("f1value : " + f1.value)
  println("f1isComplred : " + f1.isCompleted)*/
  
  
  val f = Future{ println("hello"); "world"}
  println(f.value)
  println(f.isCompleted)

  println
  f.onComplete {
    case Success(value) => println(value)
    case Failure(e) => e.printStackTrace
  }
  println(f.value)
  println(f.isCompleted)


}