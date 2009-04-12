#light
open System

let rec last xs = 
    match xs with 
    | h :: [] -> h
    | h :: t -> last t
    | _ -> failwith "items required"

let rec penultimate xs = 
    match xs with 
    | h :: t :: [] -> h 
    | h :: t -> penultimate t
    | _ -> failwith "items required"

let assertAreEqual(text, a, b) : unit = 
    if not (a = b) then
        failwith(String.Format("{0}: expected {1} got {2}", text, a, b))
    else
        ()

let rec nth i xs =
	match (i, xs) with
	| (0, h :: t) -> h
	| (n, h :: t) -> nth (n - 1) t
	| _ -> failwith("didn't converge")

let rec length xs =
  	let rec countLength s xs = 
		match xs with
		| [] -> s
		| h :: t -> countLength (s + 1) t
	countLength 0 xs		   
        
let main =
    assertAreEqual("last", 3, last [1; 2; 3])
    assertAreEqual("penultimate", 2, penultimate [1; 2; 3])
    assertAreEqual("nth", 3, (nth 0 [3; 2; 1]))
    assertAreEqual("nth", 2, (nth 1 [3; 2; 1]))
    assertAreEqual("nth", 1, (nth 2 [3; 2; 1]))
    assertAreEqual("length", 3, (length [3; 2; 1]))    
    