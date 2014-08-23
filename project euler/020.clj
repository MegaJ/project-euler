;; wow, I was really thinking of how to represent large integers,
;; but clojure supports bigints huh? I was thinking of manually doing bit shiftings....

(str (reduce *' (range 1 101)))
(count "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")

(- (int (second (seq "02938493285792375"))) 48)

(defn digit_adder [str]
  (let [str_sq (seq str)] ;; turn string into sequence first
;;     (println str_sq)
    (loop [str_sq str_sq
           accumulator 0]
      (if (not= (count str_sq) 0)
        (recur (rest str_sq)
               (+ accumulator (- (int (first str_sq)) 48)))
        accumulator))))

;; (defn digit_adder [str]
;;   (let [str_sq (seq str)] ;; turn string into sequence first
;;     (loop [str_sq str_sq
;;            accumulator 0]
;;       (println "this is the length of the str_sq: " (count str_sq))
;;       (if (not= (count str_sq) 0)
;;         (do
;;           (println (first str_sq))
;;           (recur (rest str_sq)
;;                (+ accumulator (first str_sq))))
;;
;;         accumulator))))


(digit_adder "1231")
(digit_adder (str (reduce *' (range 1 101))))

;;;;;; MISC
(count "122")
(rest '(\1 \2 \3 \4))

(seq "33")
(- (int (first (seq "935945"))) 48)

(println (seq "1231"))
