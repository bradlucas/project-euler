(ns project-euler.problem-055)

;; https://projecteuler.net/problem=55
;;
;; 10677 is the first number to be shown to require over fifty iterations before producing a palindrome
;; So, for each number we need only try 50 times to reverse and add to get to a palindrone
;; take 50 iterate reverse-add n
;;
;; If none of the iterations are palindrones then we have a lychrel number
;;

(defn palindromic
  "A palindromic number is same if you reverse it. 12321 == 12321"
  [n]
  (let [s (str n)]
    (= (clojure.string/reverse s) s)))

(defn reverse-add 
  "Reverse the number n and add it to itself. 349 + 943 => 1292"
  [n]
  (+ n (BigInteger. (apply str (reverse (str n))))))

(defn is-lychrel? [n]
  ;; Assume n is less than 10000
  ;; Alos, we now numbers less then 10000 take less than 50 iterations
  (= (count 
      (filter palindromic (take 50 (rest (iterate reverse-add n)))))
     0))

(defn problem-055 
  "Count the number pf Luchrel numbers under 10000"
  []
  (count (filter is-lychrel? (range 1 10000))))

;; (problem-055) => ;; 249






