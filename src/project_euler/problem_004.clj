(ns project-euler.problem-004)

;; get all the 3-digit numbers
;; find all the products of these numbers
;; find the largest of these which is a palindrome


(defn  palindrome? [num] 
  (let [s (seq (partition 1 (str num)))]
    (= s (reverse s))))


(defn problem-004
  []
  (apply max (filter #( palindrome? %)
                     (for [x (range 100 1000)
                           y (range 100 1000)]
                       (* x y)
                       ))))

;; (problem-004) => 906609

