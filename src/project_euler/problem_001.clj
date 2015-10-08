(ns project-euler.problem-001)

;; Problem 1
;;
;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;;
;; Find the sum of all the multiples of 3 or 5 below 1000.
;;
;; http://projecteuler.net/index.php?section=problems&id=1


(defn mod3or5? [x]
  "Return true if x is divideable by 3 or 5"
  (or 
   (== (mod x 3) 0) 
   (== (mod x 5) 0)))


(defn problem-001
  []
  (reduce + (filter mod3or5? (range 1000))))

;; (problem-001) ;;  => 233168




