#light
namespace examples99
open System

module Functions =
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

  let rec nth i xs =
      match (i, xs) with
      | (0, h :: t) -> h
      | (n, h :: t) -> nth (n - 1) t
      | _ -> failwith "didn't converge"

  let rec length xs =
      let rec countLength s xs = 
          match xs with
          | [] -> s
          | h :: t -> countLength (s + 1) t
      countLength 0 xs           
        
