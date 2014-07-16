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
  (if (< n 0)
    (println "Primes cannot be positive by definition.")
    (if (= n 2)
      true
      (if (= 0 (mod n 2))
        false
        (do
          (def checkUntil (int (Math/round (Math/sqrt n))))
          (apply #(mod n %) (range 3 checkUntil 2)))))))


  (defn countUntilNthPrime [n]
    (def accumulator [])
    ;; I wish I knew how to use for loops in Clojure,
    ;; this would be so easy.
    )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; MISC NOTES ;;;;;;;;;;;;;;;;;;;;;;;;;

;;   (let [checkUntil checkUntil]
;;     (for [x (range 3 checkUntil 2)]
;;       (not-any? (= 0 #(mod n %) x)))))

;; Here's a much simpler check from the clojuredocs.com on the for macro:
;; (defn prime? [n]
;;          (not-any? zero? (map #(rem n %) (range 2 n))))

(prime? 91)

(def checkUntil (int (Math/round (Math/sqrt n))))