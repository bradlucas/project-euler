(ns project-euler.problem-020)

;; factorial
;; n! = n * n-1 * n-2 * ... 2 * 1
;; then sum the digits of the result

;; digits
(defn digits [num]
  (map #(Character/digit % 10) (str num)))

;; sum-digits
(defn sum-digits
  [digits]
  (reduce + digits))

;; overflows for n = 100
;; (defn factorial
;;   [n]
;;   (cond 
;;     (= 1 n) 1
;;     :else (* n (factorial (dec n)))))

;; use loop/recur
;; will integer overflow unless you promote to Bigint (use *')
(defn factorial
  [n]
  (loop [num n
         res 1]
    (if (= 1 num)
      res
      (recur (dec num) (*' res num)))))


(defn problem-020
  ([] (problem-020 100))
  ([n](sum-digits (digits (factorial n)))))

;; (problem-020 100) ;;  => 648




;; ----------------------------------------------------------------------------------------------------
;; References
;;; http://www.arunmascarenhas.com/tag:clojure/
