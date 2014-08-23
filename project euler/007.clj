;; Ooh, we have to find the 10,001st prime.
;; so let's build a prime counter funtion!

;;I already built a PrimeFinder class in java, if I was
;; really cool, I could do java interop and use pre-built stuff

;; first build an isPrime function,
;; then build another function that stores the number
;; in a collection if the number is indeed prime

(defn prime?
  "Single argument, checks if n is prime"
  [n]
  (cond
   (< n 2) false ;; no primes less than 2 exist
   (= n 2) true
   (= 0 (mod n 2)) false
   :else (let [check_until (+ (int (Math/round (Math/sqrt n))) 1)]
           (every? #(not= 0 %) (map #(mod n %) (range 3 check_until 2))))))

;; apparently apply is bad? It takes in a collection as a huge set of arguments.
;;           (apply #(mod n %) (range 3 checkUntil 2)))))))


(defn find_nth_prime [n]
  (cond (<= n 0) "Not a valid value"
        (= n 1) 2
        :else (loop [current_num 3
                     number_of_primes 1]
                (if (not= number_of_primes n)
                  (if (prime? current_num)
                    (recur (+ current_num 2)
                           (+ number_of_primes 1))
                    (recur (+ current_num 2)
                           number_of_primes))
                  (- current_num 2)))))



    ;; use (prime? on every odd number until )
    ;; I wish I knew how to use for loops in Clojure,
    ;; this would be so easy.


(find_nth_prime 10001)
(prime? 9)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; MISC NOTES ;;;;;;;;;;;;;;;;;;;;;;;;;

;;   (let [checkUntil checkUntil]
;;     (for [x (range 3 checkUntil 2)]
;;       (not-any? (= 0 #(mod n %) x)))))

;; Here's a much simpler check from the clojuredocs.com on the for macro:
;; (defn prime? [n]
;;          (not-any? zero? (map #(rem n %) (range 2 n))))

(prime? 101)
