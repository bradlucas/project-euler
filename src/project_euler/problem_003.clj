(ns project-euler.problem-003)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143 ?


;; primes
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

(defn sqrt 
  [n]
  (Math/sqrt n))

(defn factors [n] 
  (filter #(zero? (mod n %))
          (take-while #(< % (sqrt n)) primes)))


(defn problem-003
  []
  (apply max (factors 600851475143)))

;; (problem-003) => 6857
