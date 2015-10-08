(ns project-euler.problem-010)

;; sum of primes under 2,000,000


;; infinite sequence of primes
;; example from 'Programming Clojure
;; https://crossclj.info/fun/clojure.contrib.lazy-seqs/primes.html
(def primes
  (concat 
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
	  (fn primes-from [n [f & r]]
	    (if (some #(zero? (rem n %))
		      (take-while #(<= (* % %) n) primes))
	      (recur (+ n f) r)
	      (lazy-seq (cons n (primes-from (+ n f) r)))))
	  wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
			6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
			2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

;; take from primes while the number is < 2,000,000
;; sum the resulting list by reducing over + 


(defn problem-010
  []
  (reduce + (take-while #(< % 2000000) primes)))

;; (problem-010) ;; =>  => 142913828922


