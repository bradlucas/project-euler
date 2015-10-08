(ns project-euler.problem-015)

;; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
;; How many such routes are there through a 20×20 grid?


;; http://folk.uio.no/larstvei/Project-Euler/#sec-16
;; (/ (apply * (range 3 5)) (apply * (range 1 3)))
;;
(defn problem-015
  [n]
  (/ (apply *' (range (inc n) (inc (* 2 n))))
     (apply *' (range 1 (inc n)))))

;; (problem-015) => 137846528820N



;; http://copingwithcomputers.com/2013/07/06/lattice-paths/
;; 
;; The middle value in Pascal's triangle at the 2*N row is the answer

;; Great, we now have a method for finding the value in any position in
;; Pascal's triangle. If we look carefully at the diagram of lattice
;; paths and compare it to Pascal's triangle, we can find a pattern. 6 is
;; the number of paths through a 2 x 2 grid. If we look in Pascal's
;; triangle, we find it at the center of the 4th row. There are 20 paths
;; through a 3 x 3 grid, and it happens to be in the 6th row. This is a
;; pattern: the solution for the number of paths through an n x n grid
;; will be found in the 2nth row.

;; Source: http://rosettacode.org/wiki/Pascal's_triangle#Clojure
(def pascal 
  (iterate #(concat [1] 
                    (map + % (rest %)) 
                    [1]) 
           [1]))

(defn middle
  [s]
  (nth s (/ (count s) 2)))


(defn problem-015 
  ([] (problem-015 20))
  ([n] (middle (nth pascal (* 2 n)))))

;; (problem-015) => 137846528820



 
 
