(def file (slurp "http://projecteuler.net/project/resources/p022_names.txt"))

file

;; (split file #",")

(defn letter_adder [str]
  (let [str_sq (seq str)] ;; turn string into sequence first
    (loop [str_sq str_sq
           accumulator 0]
      (if (not= (count str_sq) 0)
        (recur (rest str_sq)
               (+ accumulator (- (int (first str_sq)) 64)))
        accumulator))))

;;So ugly, I know, I know...

(def alphatical_names
  (sort
    (->> (split file #",")
       (map #(drop 1 %))
       (map #(drop-last %))
       (map #(apply str %)))))
alphatical_names



(reduce + (map #(* (letter_adder %) (inc (.indexOf alphatical_names %))) alphatical_names))
;=> 871198282


;;;;;; MISC
(.indexOf alphatical_names "COLIN")
(drop 1 "\"MARY\"")
(drop-last 1 "\"MARY\"")
(letter_adder "COLIN")
