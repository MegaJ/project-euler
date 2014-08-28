(def file (slurp "http://projecteuler.net/project/resources/p099_base_exp.txt"))

(use 'clojure.string)


;; take the log of the each number
;; so we multiply the exponenent with the log of the base
(def logged
  (map #(*
       (Math/log (Integer. (% 0)))
       (Integer. (% 1)))
     (map #(split % #",")
     (split file #"\n"))))


(sort > logged)

(.indexOf logged (first (sort > logged)))
;=> 708 incorrect
;=> remember that indexing starts from 0 so the correct answer is 709
