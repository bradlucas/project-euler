(ns project-euler.problem-023)

;; smallest abundant numberr is 12
;; smallest number that can be written as the sum of two abundant numbers is 23
;; all integers greater than 28123 can be written as the sum of two abundant numbers
;;
;; Find the sum of all positive integers which cannot be written as the sum of two abundant numbers

(defn divisors 
  [n]
  (filter (comp zero? (partial rem n)) (range 1 n)))

(defn sum-divisors
  [n]
  (reduce + (divisors n)))

;; perfect number is when the sum of it's divisors is the number (ie, 28)
(defn perfect? [n]
  (= (sum-divisors n) n))

;; deficient if it's divisors sum to less then the number
(defn deficient? [n]
  (< (sum-divisors n) n))

;; abundant if it's divisors sum to more than n
(defn abundant? [n]
  (> (sum-divisors n) n))

(defn abundant-sum? 
  [num abundant]
  (some #(abundant (- num %)) abundant))


(defn problem-023
  []
  (let [abundant-numbers (into (sorted-set) (filter abundant? (range 12 28124)))]
    (reduce + (remove #(abundant-sum? % abundant-numbers) (range 1 28184)))))

;; (problem-023) ;; => 4179871

