#light
open System

let rec last xs = 
	match xs with 
    | [] -> failwith "items required"
    | [h] -> printfn "[%A]" h; h
    | h :: t  -> printfn "%A :: %A" h t; last t

let rec penultimate xs = 
    match xs with 
    | [] -> failwith "items required"
    | h :: t :: [] -> h 
    | h :: t -> penultimate t


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
    assertAreEqual("last", 4, (last [1; 2; 3; 4;]))
    assertAreEqual("penultimate", 2, penultimate [1; 2; 3])
    assertAreEqual("nth", 3, (nth 0 [3; 2; 1]))
    assertAreEqual("nth", 2, (nth 1 [3; 2; 1]))
    assertAreEqual("nth", 1, (nth 2 [3; 2; 1]))
    assertAreEqual("length", 3, (length [3; 2; 1]))    
    
