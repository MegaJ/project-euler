;; Problem: By considering the terms in the Fibonacci sequence whose values
;; do not exceed four million,
;; find the sum of the even-valued terms.

;; set up Fibonnacci function
(defn fibonacci

  "n1 is the first initial value
  n2 is the second initial value
  limit is how big a fibonacci is allowed to get
  returns a vector with all fibonaccis up to the limit"

  [n1 n2 limit]

  (loop [n1 n1
         n2 n2
         nextFibonnaci 0
         resultCollection [n1 n2]]
    (if-not (> (+ n1 n2) limit)
      (recur n2
             (+ n1 n2)
             (+ n1 n2 n2)
             (conj resultCollection (+ n1 n2)))

      ;; I find it weird that the last line of the conditional
      ;; is what is returned when the loop terminates
      ;; oh wait! It's because once we have a false value,
      ;; we return the value of the else clause,
      ;; which is also when the loop ceases. Nice.
      resultCollection)))

;; test
(fibonacci 1 2 100);
; => [1 2 3 5 8 13 21 34 55 89]

(def fibsLessThan4Mil (fibonacci 1 2 4000000))


;; finally, filter and add up the even terms
(apply + (filter even? fibsLessThan4Mil))
; => 4613732






