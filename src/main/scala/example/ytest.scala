package example


object ytest extends App{
  def f(n: Int, arr: List[Int]): List[Int] = (for (i <- 0 until arr.length; j <- 1 to n) yield arr(i)).toList
  
  println(f(4, List(2,3,3,4,5,6)));
  
  val x: Either[String, Long] = Right(8)
  
  x.right.map { println }
  x.left.map { println }
} 

 