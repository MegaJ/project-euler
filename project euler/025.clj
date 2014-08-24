;; What is the first term in the Fib sequence to contain 1000 digits?

;;note, probably need to do base conversion,
;;and probably chunk some of the digits of the fib sequence
;; into a collection,
;; then spit them out through concatonation
;; (require 'clojure.contrib.math)

(defn exp [x n]
  (reduce * (repeat (bigdec n) x)))

(exp 2 3)
(exp (/ (+ 1 (Math/sqrt 5)) 2) 1500)

(- Infinity Infinity)

(defn nth_fibonacci_cform
  [n]
  (let [phi (/ (+ 1 (Math/sqrt 5)) 2)
        psi (/ (- 1 (Math/sqrt 5)) 2)]
    (/ (- (exp phi n) (exp psi n)) (Math/sqrt 5))))


(nth_fibonacci_cform 1400)

(repeat 5 3)
