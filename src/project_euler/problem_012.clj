(ns project-euler.problem-012)

;; triangle numbers
;; [1] [1 2] [1 2 3] [1 2 3 4] [1 2 3 4 5] [1 2 3 4 5 6] [1 2 3 4 5 6 7]
;;  1    3      6       10          15
;; 
;; After 1 and 3, the next value is the previous last it's position 
;; which starts at 3
;; 3 + 3 => 6
;; 6 + 4 => 10
;; 10 + 5 => 15

(def triangles
  (lazy-cat [1 3]
            (map + (rest triangles) (iterate inc 3))))

(defn sqrt 
  [n]
  (Math/sqrt n))

(defn factors-count [n] 
  (* 2 (count (filter #(zero? (mod n %))
               (range 1 (sqrt n))))))


;; filter over the triangles seq using a test that factors-count is > 500
;; return the first one found
(defn problem-012
  ([] (problem-012 500))
  ([n](first (filter #(> (factors-count %) n) triangles))))

;; (problem-012) ;; => 76576500



;; ---------------------------------------------------------------------------------------------------- 
;; Reference
;; http://mishadoff.com/blog/clojure-euler-problem-012/
