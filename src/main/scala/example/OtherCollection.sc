package example

import scala.annotation.tailrec

object OtherCollection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap( c => List('.', c))                   //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res6: Int = 50
  xs.max                                          //> res7: Int = 44
  
  val n = 7                                       //> n  : Int = 7
  ((1 until n) map (i =>
  	( 1 until i ) map (j => (i, j)))).flatten //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))
                                                  
  def myFunc(x: Int)(y: Int) = x + y              //> myFunc: (x: Int)(y: Int)Int
  def myCurriedFunc = (x: Int) => (y: Int) => x + y
                                                  //> myCurriedFunc: => Int => (Int => Int)
  
  myFunc(1)(2)                                    //> res9: Int = 3
  myCurriedFunc(1)(2)                             //> res10: Int = 3
  
  val myAFunc = myFunc(1) _                       //> myAFunc  : Int => Int = <function1>
  val myACurriedFunc = myCurriedFunc(1)           //> myACurriedFunc  : Int => Int = <function1>
  
  Function.uncurried(myCurriedFunc)               //> res11: (Int, Int) => Int = <function2>
  
}