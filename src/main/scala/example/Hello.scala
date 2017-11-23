package example

import scala.annotation.tailrec

object Hello extends Greeting with App {

@tailrec
def last(l: List[Int]): Int = l match {
  case x::y::Nil => y
  case x::tail => last(l.tail)
  case _ => throw new NoSuchElementException
}

def nth[A](i: Int, l: List[A]): A = {
  @tailrec
  def sub(c: Int, li: List[A]): A = li match {
    case Nil => throw new NoSuchElementException
    case _ => if (i == c) li.head
              else sub(c+1, li.tail)
  }
  sub(0, l)
}

def lenth[A](l: List[A]): Int = {
  @tailrec
  def sub(c: Int, li: List[A]): Int = li match {
    case Nil => c
    case x::tail => sub(c+1, tail)
  }
  sub(0, l)
}

  println(greeting)
  val list = List(1,2,3,4,5,6,7,8,192)
  println(last(list))
  println(nth(3, list))
  println(lenth(list))
  
  lazy val test: () => Int = {
    val r = util.Random.nextInt()
    () => r
  }
  println(test())
  println(test())
  
  def test2: () => Int = {
    val r = util.Random.nextInt()
    () => r
  }
  println(test2())
  println(test2())

  @tailrec
  def sum(r: Int)(x: Int, y: Int)(f: Int => Int): Int = {
    if (x > y) r
    else sum(r + f(x))(x + 1, y)(f)
  }

  val list22 = List(2, 3, 4, 5, 6)
  val s = List.tabulate(10)(x => x)
  s.foreach(println)
  println(1 +: list22)
  println(1 :: list22)
  println(list22 :+ 7)
  println(list22 ::: List(7))

  println(sum(0)(1, 100000000)(x => x))
  
}

trait Greeting {
  lazy val greeting: String = "hello!!"
}
