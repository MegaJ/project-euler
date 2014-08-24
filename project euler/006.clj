

(defn exp [x n]
  (reduce *' (repeat n x)))

;; sum of squares of first 100 natural nums:
(reduce + (map #(exp % 2) (range 1 101)))
; => 338350

;; square of the sum of first 100 natural nums:
(exp (reduce + (range 1 101)) 2)
; => 25502500

(- 25502500 338350)

