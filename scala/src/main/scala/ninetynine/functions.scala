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
  
  def flatten[T](items: List[T]) : List[T] = {
    def flatMapOuter[T](acc:List[T], all: List[T]) : List[T] = {
      def flatMap[T](x: Any) : List[T] = {
        x match {
          case xs: List[T] => xs
          case _ => List(x.asInstanceOf[T])
        }
      }
      all match {
        case h :: t => flatMapOuter(flatMap(h) ::: acc, t)
        case _ => acc
      }
    }
    flatMapOuter(Nil, items)
  }

  def compress[T](items: List[T]) : List[T] = {
    def compress2(acc: List[T], xs: List[T]) : List[T] = (acc, xs) match {
      case (h :: t, h2 :: t2) if (h == h2) => compress2(acc, t2)
      case (_, Nil) => acc.reverse
      case (_, h2 :: t2) => compress2(h2 :: acc, t2)
    }
    compress2(Nil, items)
  }

  def pack[T](items: List[T]) : List[List[T]] = {
    def packrec(acc: List[List[T]], xs: List[T]) : List[List[T]] = xs match {
      case h :: t => {
        val (packed: List[T],rest) = xs.span(_ == h)
        rest match {
          case Nil => List(packed)
          case _ => packrec(packed :: acc, rest) 
        }
      }     
      case Nil => List(List())  
    }
    packrec(Nil, items)
  }
}