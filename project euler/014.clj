;; Find the number with the longest Collatz sequence
;; for numbers under a million

(defn num_terms_of_collatz [n]
  (loop [current_num n
         terms 1]       ;; count the initial term as 1
;;     (println current_num)
    (if (not= current_num 1)
      (if (even? current_num)
        (recur (/ current_num 2)
               (inc terms))
        (recur (inc (* current_num 3))
               (inc terms)))
      terms)))

(num_terms_of_collatz 27)
;; have a function that handles doing the collatz sequence, and returns
;; the number of steps it took
;; then have a function that loops and keeps track of the max amt of terms

;; but we shouldn't check a number if the number belongs to
;; another number's collatz sequence.

;; I realize I can't use this function since I want to keep track of which terms
;; appeared in the collatz sequence and my helper function doesn't give that info
;; I'll just do it the crude way for now
(defn do_it []
  (loop [current_num 999999
         max_record [1 1]]
    (if (not= current_num 1)
      (let [num_terms (num_terms_of_collatz current_num)]
        (if (> num_terms (first max_record))
            (recur (dec current_num)
                   [num_terms current_num])
            (recur (dec current_num)
                   max_record)))
      max_record)))


(do_it)

;; (count '( 27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214, 107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137, 412, 206, 103, 310, 155, 466, 233, 700, 350, 175, 526, 263, 790, 395, 1186, 593, 1780, 890, 445, 1336, 668, 334, 167, 502, 251, 754, 377, 1132, 566, 283, 850, 425, 1276, 638, 319, 958, 479, 1438, 719, 2158, 1079, 3238, 1619, 4858, 2429, 7288, 3644, 1822, 911, 2734, 1367, 4102, 2051, 6154, 3077, 9232, 4616, 2308, 1154, 577, 1732, 866, 433, 1300, 650, 325, 976, 488, 244, 122, 61, 184, 92, 46, 23, 70, 35, 106, 53, 160, 80, 40, 20, 10, 5, 16, 8, 4, 2, 1 ))

(> 3 2)
(first [3 2])
