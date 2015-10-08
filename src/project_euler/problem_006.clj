(ns project-euler.problem-006)

;; The sum of the squares of the first ten natural numbers is, 12 + 22 + ... + 102 = 385
;; The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)2 = 552 = 3025
;; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.


(defn sum-of-squares
  [n]
  (loop [n n
         acc 0]
    (if (zero? n)
      acc
      (recur (dec n) (+ acc (* n n))))))

(defn square-of-the-sum
  "Sum the seequence of xs and sqaure it"
  [xs]
  (let [sum (apply + xs)]
    (* sum sum)))


(defn problem-006
  ([] (problem-006 100))
  ([n] (- (square-of-the-sum (range 1 (inc n))) (sum-of-squares n))))

;; (problem-006) ;; => 25164150
