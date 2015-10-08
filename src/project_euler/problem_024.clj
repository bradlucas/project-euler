(ns project-euler.problem-024)

;; for each x in s
;; cons x with permutations of x with x removed
;; apply concat merges the cons
;; when called with no rest return s

(defn permutations
  [s]
  (if (seq (rest s))
    (apply concat (for [x s] (map #(cons x %) (permutations (remove #{x} s)))))
    [s]))

;; make sure to use 0, ... 9


(defn problem-024
  ([] (problem-024 1000000))
  ([n] (apply str (nth (permutations (range 0 10)) (dec n)))))

;; (problem-024 1000000) ;; => (2 7 8 3 9 1 5 4 6 0) => 2783915460




;; ----------------------------------------------------------------------------------------------------
;; Reference
;; http://stackoverflow.com/a/26076145
