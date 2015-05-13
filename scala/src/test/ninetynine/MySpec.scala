package ninetynine

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{PropSpec, ShouldMatchers}


object MySpec extends PropSpec with ShouldMatchers with GeneratorDrivenPropertyChecks {
  val list = List(1, 2, 3, 4, 5)

  property("last element") {
    forAll {
      (xs: List[Int]) =>
        whenever(xs.nonEmpty) {
          xs.reverse.take(1) should be (functions.last(xs))
        }
    }
  }

//  "last" should "return the very last element" in {
//    last(list) mustEq 5
//  }
//
//  "penultimate should return 2nd to last element" in {
//    penultimate(list) mustEq 4
//  }
//
//  "nth element in the list" should {
//    "start at index 0" in {
//      nth(0, list) mustEq 1
//    }
//    "should return the correct element" in {
//      nth(3, list) mustEq 4
//    }
//  }
//
//  "reverse" should {
//    "return all the elements" in {
//      reverse(list).size mustEq 5
//    }
//
//    "be in correct orders" in {
//      reverse(list) must containInOrder(List(5, 4, 3, 2, 1))
//    }
//  }
//
//  "palindrome is the same reversed" in {
//    isPalindrome(List(1, 2, 3, 2, 1)) mustEq true
//  }
//
//  "flatten should return a list of the simple elements" in  {
//    flatten(List(List(1, 2, 3), 4, List(5, 6, 7))) must
//      containInOrder(List[Any](1, 2, 3, 4, 5, 6, 7))
//  }
//
//  "compress removes consecuitive elements" in {
//    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must
//      containInOrder(List('a, 'b, 'c, 'a, 'd, 'e,))
//  }
//
//  "pack should place consecutive elements in sublists" {
//	//val result = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//    val result = List(1, 2, 3)
//    reverse(list).size mustEq 5
//	pack(result).size mustEq 6
//  }
////     pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  //     containInOrder( List(
//	/*						List('a, 'a, 'a, 'a),
//								List('b),
//								List('c, 'c),
//								List('a, 'a),
//								List('d),
//								List('e, 'e, 'e, 'e)
//								)
//								)*/
   
}


