;; Goal: Find the last ten digits of the series
;; 1^1 + 2^2 + 3^3 + 4^4 + ... + 1000^1000

;; Well we can just do mod 1 000 000 000

(defn exp [x n]
  (reduce *' (repeat n x)))

(defn exp_mod [x n modulus]
  (mod (reduce *' (repeat n x)) modulus))

(def ten_bill (exp 10 10))
ten_bill

(reduce #(mod (+ %1 %2) ten_bill)
        (map #(exp_mod % % ten_bill)
             (range 1 1001)))

;=> 9110846700N
