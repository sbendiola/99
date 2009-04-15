package ninetynine
import org.specs._
import functions._
import org.specs.runner.{ConsoleRunner, JUnit4}

class MySpecTest extends JUnit4(MySpec)
//class MySpecSuite extends ScalaTestSuite(MySpec)
object MySpecRunner extends ConsoleRunner(MySpec)

object MySpec extends Specification {
  val list = List(1, 2, 3, 4, 5)
    
  "last should return the very last element" in {
    last(list) mustEq 5
  }

  "penultimate should return 2nd to last element" in {
    penultimate(list) mustEq 4
  }

  "nth element in the list" should {
    "start at index 0" in {
      nth(0, list) mustEq 1
    }
    "should return the correct element" in {
      nth(3, list) mustEq 4
    }
  }
  
  "reverse" should {
    "return all the elements" in {
      reverse(list).size mustEq 5
    }

    "be in correct orders" in {
      reverse(list) must haveSameElementsAs(List(5, 4, 3, 2, 1))
    }
  }

  "palindrome is the same reversed" in {
    isPalindrome(List(1, 2, 3, 2, 1)) mustEq true
  }
}
