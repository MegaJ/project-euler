(defn exp [x n]
  (reduce *' (repeat n x)))

;; (exp 2 1000)

(defn digit_adder [str]
  (let [str_sq (seq str)] ;; turn string into sequence first
;;     (println str_sq)
    (loop [str_sq str_sq
           accumulator 0]
      (if (not= (count str_sq) 0)
        (recur (rest str_sq)
               (+ accumulator (- (int (first str_sq)) 48)))
        accumulator))))

(digit_adder (str (exp 2 1000)))
