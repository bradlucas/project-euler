(ns project-euler.problem-025)

;; The Fibonacci sequence is defined by the recurrence relation:
;;     Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.

;; Hence the first 12 terms will be:
;;     F1 = 1
;;     F2 = 1
;;     F3 = 2
;;     F4 = 3
;;     F5 = 5
;;     F6 = 8
;;     F7 = 13
;;     F8 = 21
;;     F9 = 34
;;     F10 = 55
;;     F11 = 89
;;     F12 = 144
;;
;; The 12th term, F12, is the first term to contain three digits.
;; What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

;; Lazy infinite sequence of fibonacci numbers
;; overflows unless you use +'
(def fib-seq (lazy-cat [1 1] (map +' (rest fib-seq) fib-seq)))


(defn num-length [n] (count (str n)))

;; the 12th element
;; (nth (take 12 fib-seq) (dec 12)) => 144
;; find the first fib number that contains 3 digits
;; (first (drop-while #(< (num-length %) 3) fib-seq))

;; count the fibonacci numbers
;; (map-indexed (fn [i n] [i n]) [1 2 3 4 5])

;; count the fibonacci numbers and calculate the number's length
;; note that map-indexed is zero based and this problem is 1-based
;; so we'll inc i
;; (map-indexed (fn [i n] [(inc i) (num-length n)])

;; find the first number with 1000 digits
;; (< (second %) 1000

(defn problem-025
  ([] (problem-025 1000))
  ([num-digits] 
   (first (first 
           (drop-while #(< (second %) num-digits) 
                       (map-indexed (fn [i n] [(inc i) (num-length n)]) fib-seq))))))

;; (problem-025) ;; => 4782




;; ----------------------------------------------------------------------------------------------------
;; Reference
;; http://mishadoff.com/blog/clojure-euler-problem-025/





