;; get all the numbers that are multiples of 3 or 5 below 1000
;; range is numbers 1 to 999
(def numbers
  (filter #(or (= 0 (mod % 5)) (= 0 (mod % 3))) (range 1 1000)))
;; add the collection

(apply + numbers)