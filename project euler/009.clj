;; Goal: There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; a < b < c
;; Find the product abc.

;; i love you list comprehension, but this is soooo slow

(for [a (range 1 334)
      b (range 1 1000)
      c (range 1 1000)
      :when (and (< a b c)
                 (= 1000 (+ a b c))
                 (= (* c c) (+ (* a a) (* b b))))]
  [a b c])

;; => ([200 375 425])

(* 200 375 425)

;; so much better

(for [a (range 3 334)
      b (range 1 1000)
      :let [c (- 1000 a b)]
      :when (and (< a b c)
                 (= 1000 (+ a b c))
                 (= (* c c) (+ (* a a) (* b b))))]
  [a b c])

;; even better is to get a partial algebraic solution as suggested on forums
