(ns project-euler.problem-009)

;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a^2 + b^2 = c^2

;; For example, 32 + 42 = 9 + 16 = 25 = 52.

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.


(defn sqr [n] (* n n))

(defn pythagorean-triplet
  [a b c]
  (and (< a b c)
       (= (sqr c) (+ (sqr a) (sqr b)))))


;; a + b + c == 1000
(defn problem-009
  ([] (problem-009 1000))
  ([sum] (first (for [a (range 1 sum)
                      b (range (inc a) sum)
                      c (range (inc b) sum)
                      :when (and (= sum (+ a b c))
                                 (pythagorean-triplet a b c))
                      ]
                  ;; (println a b c)
                  (* a b c)))))

;; (problem-009 1000) ;; => 31875000




