#light
namespace examples99
open System
open examples99.Functions

module Tests =

  let assertAreEqual(text, a, b) : unit = 
      if not (a = b) then
        failwith(String.Format("{0}: expected {1} got {2}", text, a, b))
      else
        ()

  let main() =
    assertAreEqual("last", 4, last [1; 2; 3; 4;])
    assertAreEqual("penultimate", 2, penultimate [1; 2; 3])
    assertAreEqual("nth", 3, (nth 0 [3; 2; 1]))
    assertAreEqual("nth", 2, (nth 1 [3; 2; 1]))
    assertAreEqual("nth", 1, (nth 2 [3; 2; 1]))
    assertAreEqual("length", 3, (length [3; 2; 1]))    
    assertAreEqual("reverse", [1; 2; 3; 4;], (reverse [4; 3; 2; 1;))
    assertAreEqual("palindrome", true, (palindrome [1; 2; 3; 4; 3; 2; 1]))
    assertAreEqual("palindrome2", false, (palindrome [1; 2; 3; 4; 3; 2))
    ()

  main();;
