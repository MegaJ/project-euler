(defn prime?
  "Single argument, checks if n is prime"
  [n]
  (cond
   (< n 2) false ;; no primes less than 2 exist
   (= n 2) true
   (= 0 (mod n 2)) false
   :else (let [check_until (+ (int (Math/round (Math/sqrt n))) 1)]
           (every? #(not= 0 %) (map #(mod n %) (range 3 check_until 2))))))

;; collects all primes up to n into an array
(defn primes_up_to [n]
  (if (even? n)
     "breaakkk")
  (cond
   (< n 2) "no primes exist" ;; no primes less than 2 exist
   (= n 2) [2]
   (= n 3) [2 3]
   :else (loop [current_value 3
                primes [2]]
          (if (not= (- current_value 2) n)
            (if (prime? current_value)
              (recur (+ current_value 2)
                     (conj primes current_value))
              (recur (+ current_value 2)
                     primes))
            primes))))

(map str (primes_up_to 101))


(loop [prime_list (map str (primes_up_to 101))
       truncables []]
  (if (not= (count truncables) 11)
    (loop )))
