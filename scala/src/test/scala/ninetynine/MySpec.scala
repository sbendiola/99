package ninetynine

import org.scalacheck.Gen
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{PropSpec, ShouldMatchers}

class MySpec extends PropSpec with ShouldMatchers with GeneratorDrivenPropertyChecks  {


  property("last element") {
    forAll {
      (xs: List[Int]) =>
        whenever(xs.nonEmpty) {
          val expected = xs.reverse.head
          functions.last(xs) should be (expected)
        }
    }
  }

  property("penultimate") {
    forAll {
      (xs: List[Int]) =>
        whenever(xs.size > 1) {
          val expected = xs.reverse.drop(1).head
          functions.penultimate(xs) should be (expected)
        }
    }
  }
  val withElementIndex: Gen[(List[Int], Int)] = for {
    list <- Gen.listOfN(10, Gen.chooseNum(0, 100))
    index <- Gen.choose(0, list.size - 1)
  } yield (list, index)
  property("nth element in the list") {
    forAll {
      (values: (List[Int], Int)) =>
        val (list, n) = values

        whenever(n >= 0 && list.length > n) {
          functions.nth(n, list) should be (list(n))
        }
    }
  }

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


