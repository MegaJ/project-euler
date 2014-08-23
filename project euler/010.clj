;; Goal: Find the sum of all the primes below two million.
;; This took almost about a minute for my computer to run...
;; I figured 2 million 1 wasn't a prime, and my function breaks when handed even values
;; I know it could be better

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

(apply + (primes_up_to 2000001))
;; 142913828922
