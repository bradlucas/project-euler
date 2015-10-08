(ns project-euler.problem-016)

;; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
;; 
;; What is the sum of the digits of the number 21000?

;; digits
(defn digits [num]
  (map #(Character/digit % 10) (str num)))

;; sum-digits
(defn sum-digits
  [digits]
  (reduce + digits))


;; x ^ n
(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (*' x acc) (dec n) ))))


(defn problem-016 
  ([] (problem-016 2 1000))
  ([x n](sum-digits (digits (exp x n)))))


;; (problem-016 2 1000) ;; => 1366
