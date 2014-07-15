;; Goal: Find the largest prime factor of 600851475143
;; Note, this is not pretty. I will use brute force rather than
;; fancy decomposition algorithms

;; refer to 600851475143 as largeNum
(def largeNum 600851475143)

;; Math fact: The largest (NOT NECESSARILY PRIME) factor of a number
;; cannot be larger than the sqrt of 600851475143

(Math/sqrt largeNum)
; => 775146.0992245268
(def sqrtOflargeNum (int (Math/floor (Math/sqrt largeNum))))

;; thus we can simply decrement from sqrtOflargeNum and see when
;; we can evenly divide largeNum. We can save these in a collection and
;; then test if they are prime

;; note that our largeNum is odd, so it won't have any even factors,
;; so this function subtracts two in each iteration

(defn factorsOf [numberToFactor]
  (let [sqrtOfNumber (int (Math/floor (Math/sqrt largeNum)))]
    (if (even? sqrtOfNumber)
      (def sqrtOfNumber (dec sqrtOfNumber)))

    (loop [testValue sqrtOfNumber
           resultCollection []]
      (if-not (< testValue 2)

        (recur
         (- testValue 1)
         (if (= 0 (mod numberToFactor testValue))
           (conj resultCollection testValue)
           resultCollection))

        ;; when testValue goes to 1, return the list of factors
        resultCollection))))

(factorsOf largeNum)
; => [486847 104441 59569 6857 1471 839 71]
;; Since this was such a small list, I decided to manually plug in the answers
;; to project Euler. 6857 was the bingo number

;; I admit, this solution is ugly. There are even some edge cases
;; and we don't actually find all the factors of the number, if
;; largeNum is small.
;; also couldn't recur with (- testvalue 2), which would've saved time,
;; not sure why it would fail in those cases




;;;;;;;;;;;;; MISC stuff that I did in the REPL, NOT IMPORTANT ;;;;;;;;;;;;;;;;;;;;;
(factorsOf 15)
(Math/sqrt 90)
(int 1.0)
(int (Math/floor (Math/sqrt largeNum)))
(if (even? sqrtOflargeNum)
      (def sqrtOflargeNum (dec sqrtOflargeNum)))
sqrtOflargeNum

(- 1 2)