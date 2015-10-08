(ns project-euler.problem-007)

;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;; 
;; What is the 10 001st prime number?


;; infinite sequence of primes
;;
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


(defn problem-007
  []
  (second (first (drop-while #(< (first %) 10001)  
                             (map-indexed (fn [i n] [(inc i) n]) primes)))))

;; (problem-007) => 104743


