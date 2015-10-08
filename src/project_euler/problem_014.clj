(ns project-euler.problem-014)

;; Longest Collatz sequence
;; Problem 14
;;
;; The following iterative sequence is defined for the set of positive integers:
;;
;; n -> n/2 (n is even)
;; n -> 3n + 1 (n is odd)
;;
;; Using the rule above and starting with 13, we generate the following sequence:
;; 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
;;
;; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
;;
;; Which starting number, under one million, produces the longest chain?

(defn collatz-sequence
  [n]
  ;; n -> n/2 (n is even)
  ;; n -> 3n + 1 (n is odd)
  (loop [n n
         acc [n]]
    (if (<= n 1)
      acc
      (let [v (if (even? n) (/ n 2) (+ 1 (* 3 n)))]
        (recur v (conj acc v))))))

(defn collatz-sequence-results
  "Return a pair [n cnt] where cnt is the length of the collatz sequence"
  [n]
  [n (count (collatz-sequence n))])

(defn max-pair
  "Return the pair with the maximum y value given [x1 y1] [x2 y2]"
  [[x1 y1] [x2 y2]]
  (if (> y1 y2) [x1 y1] [x2 y2]))

(defn problem-014
  ([] (problem-014 1000000))
  ([num] (first 
          (let [end (inc num)]
            (loop [n 1 acc [0 0]]
              (if (= n end)
                acc
                (recur (inc n) (max-pair acc (collatz-sequence-results n)))))))))

;; (problem-014 1000000) => [837799 525]


;; These don't work for large numbers
;; (defn all-collatz-sequences
;;   "Return all the sequences for each number"
;;   [n]
;;   (map #(collatz-sequence %) (range 1 (inc n)))
;;   )


;; (defn problem-014
;;   "Find the number under a million that produces the longest collatz-sequence"
;;   [n]
;;   (sort-by count (all-collatz-sequences n))
;;   )

