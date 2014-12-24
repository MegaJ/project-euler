(use '[clojure.string :as clstr :only [reverse]])

;; what the hell was I doing before?
(defn num-palindrome?
  "Input must be a positive integer"
  [n]
  (let [as-str (str n)]
    (= as-str (clstr/reverse as-str))))

;; (num-palindrome? 44144) ;; true
;; (num-palindrome? 920) ;; false
;; (num-palindrome? 1) ;; true


;; strategy is just to multiply numbers together,
;; instead of factoring

;; if inner loop returns true, then outer loop returns true
(defn problem-4 []
  (loop [outer 999
         inner 999
         palindromes '()]
    (if (= outer 100)
      palindromes
      (recur (dec outer)
             (dec outer)
             (conj palindromes
               (loop [inner inner]
                 (cond (num-palindrome? (* outer inner))
                         (* outer inner)
                       (< inner 100)
                         false
                       :else
                         (recur (dec inner)))))))))

;; (problem-4)
(reduce max (filter (complement false?) (problem-4)))

;; test if the inner loop works
;; (defn funct [outer]
;;   (loop [inner 999]
;;     (cond (num-palindrome? (* outer inner))
;;             [outer inner]
;;           (< inner 100)
;;             false
;;           :else
;;             (recur (dec inner)))))

;; (funct 993)

;; (apply * [993 913])
