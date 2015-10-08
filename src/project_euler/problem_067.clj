(ns project-euler.problem-067
  (require [clojure.java.io :as io]
           [project-euler.problem-018 :refer [problem-018]]))

;; problem 67
;; read 'p067_triangle.txt into vector list

(def fname "data/problem-067.txt")


(defn load_triangle_file
  [fname]
  (with-open [rdr (io/reader fname)]
    (let [lines (line-seq rdr)]
      (mapv (fn [x] (mapv #(Integer/parseInt %) (clojure.string/split x #" "))) lines)
      )))

;; Note: load functions in problem-018.clj
(defn problem-067
  []
  (problem-018 (load_triangle_file fname)))

;; (problem-067) ;; => 7273
