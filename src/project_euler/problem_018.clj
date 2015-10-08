(ns project-euler.problem-018)

(def t 
  [
   [75]
   [95 64]
   [17 47 82]
   [18 35 87 10]
   [20 04 82 47 65]
   [19 01 23 75 03 34]
   [88 02 77 73 07 63 67]
   [99 65 04 28 06 16 70 92]
   [41 41 26 56 83 40 80 70 33]
   [41 48 72 33 47 32 37 16 94 29]
   [53 71 44 65 25 43 91 52 97 51 14]
   [70 11 33 28 77 73 17 78 39 68 17 57]
   [91 71 52 38 17 14 91 43 58 50 27 29 48]
   [63 66 04 68 89 53 67 30 73 16 69 87 40 31]
   [4 62 98 27 23 9 70 98 73 93 38 53 60 4 23]
   ]
  )


;; reverse the tree and work up
;; pair the row and pick the maximum value from each
;; add these values to the previous row
;; repeat through the rest of the lists

(defn pair-row
  [row]
  (partition 2 1 row))

(defn max-pair-row
  [paired-row]
  (map #(reduce max %) paired-row))

(defn reduce-rows
  [a b]
  (map + (max-pair-row (pair-row a)) b))

(defn problem-018
  ([] (problem-018 t))
  ([t] (first (reduce reduce-rows (reverse t)))))

;; (problem-018) => 1074




;; ----------------------------------------------------------------------------------------------------
;; References
;; http://mishadoff.com/blog/clojure-euler-problem-018/
;; https://github.com/stevenproctor/project-euler-clojure/blob/master/src/project_euler/core.clj
;; http://stackoverflow.com/questions/8002252/euler-project-18-approach
;; https://gist.github.com/dbyrne/430074
