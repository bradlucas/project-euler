(ns project-euler.problem-005)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; 
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?


(defn divisible-by-all
  "Return true if number is divisible by all of the number from 1 to n"
  [num max-divisor]
  (let [divisors (range 1 (inc max-divisor))]
    ;; all false return true
    ;; this is slow
    ;; (every? zero? (map #(mod num %) divisors))
    
    ;; faster. the and returns more quickly
    (reduce #(and %1 (zero? (rem num %2))) true divisors)
    ))


(defn problem-005
  []
  ;; this doesn't return. takes too long
  ;; (first (filter #(divisible-by-all % 20) (iterate inc 1)))
  ;;
  ;; (first (drop-while #(not (divisible-by-all % 20)) (iterate inc 1)))

  ;; realizing that the number has to be divisible by 20 means you can range by 20s to speed things up
  (first (drop-while #(not (divisible-by-all % 20)) (range 20 Integer/MAX_VALUE 20)))
  )

;; (problem-005) ;; => 232792560



;; ----------------------------------------------------------------------------------------------------
;; Reference
;; http://blog.beloglazov.info/2010/11/solutions-to-5-project-euler-problems.html
