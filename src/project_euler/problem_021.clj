(ns project-euler.problem-021)

;; Let d(n) be defined as the sum of proper divisors of n (numbers less
;; than n which divide evenly into n).  If d(a) = b and d(b) = a, where a
;; != b, then a and b are an amicable pair and each of a and b are called
;; amicable numbers.

;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
;; 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284
;; are 1, 2, 4, 71 and 142; so d(284) = 220.

;; Evaluate the sum of all the amicable numbers under 10000.


;; divisors of 220 are [1 2 4 5 10 11 20 22 44 55 110]
;; sum of these is (reduce + [1 2 4 5 10 11 20 22 44 55 110])
;; d(220) => 284
;; d(284) == 220

;; http://stackoverflow.com/a/20248391
(defn divisors 
  [n]
  (filter (comp zero? (partial rem n)) (range 1 n)))

(defn d
  [n]
  (reduce + (divisors n)))

(defn amicable?
  "if d(a) == d(b) and a != b then a and b are amicable numbers"
  [a]
  (let [b (d a)]
    (if (not (= a b))
      (= a (d b))
      false)))


(defn problem-021
  ([] (problem-021 10000))
  ([n] (reduce + (filter amicable? (range 10001)))))

;; (problem-021) ;; => 31626
