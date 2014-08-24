(defn num_palindrome? [n]
  (cond (even? n)
          (let [first_half (reverse (take (/ (count (str n)) 2) (seq (str n))))
                second_half (take-last (/ (count (str n)) 2) (seq (str n)))]
            (if (= first_half second_half)
              true
              false))
        :else
          (let [middle (+ (int (Math/floor (/ n 2))) 1)
                first_half (reverse (take middle (seq (str n))))
                second_half (take-last middle (seq (str n)))]
            (if (= first_half second_half)
              true
              false))))

(defn palindromes_up_to [n]
  (loop [current_num n
        palindromes #{} ]
    (if (not= current_num 0)
      (if (num_palindrome? current_num)
        (recur (dec current_num)
               (conj palindromes current_num))
        (recur (dec current_num)
               palindromes))
      palindromes)))



(num_palindrome? 9999999)
(def pali_array (sort > (palindromes_up_to 998001)))

;; Okay, I have a list of all the palindromes up to 998001,
;; I just need to determine if a palindrome has a factor which is a 3 digit number



(defn factor? [num1 num2]
  (= 0 (rem num1 num2)))

(factor? 999 3)

(str 91)

(count "91")
(take 2 '(1 2 4))


(reverse (take (/ (count (str 11223344332211)) 2) (seq (str 11223344332211))))
(take-last (/ (count (str 11223344332211)) 2) (seq (str 11223344332211)))

(= '(\4 \3) '(\3 \4))

(int (Math/floor 2.5))
