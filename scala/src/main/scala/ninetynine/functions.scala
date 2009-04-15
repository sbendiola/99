package ninetynine

object functions {
  def last(list: List[Any]) : Any = 
    list match {
      case x :: Nil => x
      case x :: xs => last(xs)
      case _ => error("items required")
    }

  def penultimate(list: List[Any]) : Any = {
    list match {
      case List(f, s, t) => s
      case h :: t => penultimate(t)
      case _ => error("elements required")
    }
  }
  
  def nth(index: Int, list: List[Any]) : Any = (index, list) match {
    case (0, h :: t) => h
    case (n, h :: t) => nth(n-1, t)
    case (_, Nil) => error("no elements")
  }
  
  def reverse[T](list:List[T]) : List[T] = {
    def reverse(acc:List[T], iter:List[T]) : List[T] = iter match {
      case Nil => acc
      case h :: t => reverse(h :: acc, t)
    }   
    reverse(Nil, list)
  }
  
  def isPalindrome(list: List[Any]) : Boolean = {
    list.zip(list.reverse).exists(both => both._1 != both._2) == false
  }

}