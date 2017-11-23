package example.curry

object CurryTest extends App {
  def filter(xs: List[Int], p: Int => Boolean): List[Int] = 
    if (xs.isEmpty) xs
    else if(p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
    
  def modN(n: Int)(x :Int) = ((x % n) == 0)
  
  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  
  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))
  
  def price(product: String) : Double = 
    product match {
      case "apples" => 140
      case "oranges" => 223
    }
  
  def withTax(cost: Double, state: String): Double =
    state match {
      case "NY" => cost * 2
      case "FL" => cost * 3
    }
  
  val locallyTaxed = withTax(_: Double, "NY")
  val costOfApples = locallyTaxed(price("apples"))
  
  println(costOfApples)
}