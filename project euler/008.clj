;; Goal: find the largest horizontal product made by 13 horizontally adjacent integers

(def bignum "73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450")

;; 50r, 20c

(use 'clojure.string)

(get (split bignum #"\n") 20)
(= nil 1)


(defn digit_multiplier [str]
  (let [str_sq (seq str)] ;; turn string into sequence first
;;     (println str_sq)
    (loop [str_sq str_sq
           accumulator 1]
      (if (not= (count str_sq) 0)
        (recur (rest str_sq)
               (* accumulator (- (int (first str_sq)) 48)))
        accumulator))))


(digit_multiplier "23475")

;; I can't be doing Clojure right...this is just really hard to read....

;; triple nested loops....god I'm terrible
(defn horizontal_product [n multicand_size]
  (let [rows (split n #"\n")
        row_size (count (get rows 0))]
    (loop [current_row_num 0
           max_product 0]
      (let [current_row (get rows current_row_num)]
        (if (not= current_row nil)
          (do
            (println "This is the current row: "current_row)
            (loop [start 0
                   end (+ start multicand_size)
                   max_product 0]
              (if-not (> end row_size)
                (if (> (digit_multiplier (subs current_row start end)) max_product)
                  (do
                    (println "This is the current subsequence: " (subs current_row start end))
                    (recur (inc start)
                           (inc end)
                           (digit_multiplier (subs current_row start end))))

                  (do
                    (println "This is the current subsequence: " (subs current_row start end))
                    (recur (inc start)
                           (inc end)
                           max_product)))
                max_product))
            (recur (inc current_row_num)
                   max_product))
          max_product)))))


(horizontal_product bignum 13)

;; yay substring methods, (subs ) returns [a, b)
(subs "73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843" 50 100)
(Integer. "293844")
(count "7316717653133")
(subs "73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843" 13)
