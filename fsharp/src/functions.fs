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
        
let main =
    assertAreEqual("last", 3, last [1; 2; 3])
    assertAreEqual("penultimate", 2, penultimate [1; 2; 3])
    
    