;; What is the first term in the Fib sequence to contain 1000 digits?

;;note, probably need to do base conversion,
;;and probably chunk some of the digits of the fib sequence
;; into a collection,
;; then spit them out through concatonation
;; (use 'clojure.contrib.math)

(defn exp [x n]
  (reduce * (repeat n x)))

(exp 2 3)

(defn nth_fibonacci_cform
  [n]
  (let [phi (/ (+ 1 (Math/sqrt 5)) 2)
        psi (/ (- 1 (Math/sqrt 5)) 2)]
    (/ (- (/ (exp phi n) 100000) (exp psi n)) (Math/sqrt 5) 1000)))


(nth_fibonacci_cform 2000)
