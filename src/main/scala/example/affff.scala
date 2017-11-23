package example

class MyTest1(val tell: String)
class MyTest2(val tell: String)

object affff extends App{
  implicit val test = new MyTest1("삐약")
  implicit val test2 = new MyTest2("개굴")
  
  def greet(name: String)(implicit test: MyTest1, test2: MyTest2) {
    println(name)
    println(test.tell)
    println(test2.tell)
  }
  greet("asdfasdf")
}