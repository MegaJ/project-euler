;; Goal: What is the smallest positive number
;; that is evenly divisible by all of the numbers from 1 to 20?

; Don't even need to write a program for this actually

(* (exp 2 4) (exp 3 2) 5 7 11 13 17 19)

(defn exp [x n]
  (reduce * (repeat (bigint n) x)))
