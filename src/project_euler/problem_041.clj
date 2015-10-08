(ns project-euler.problem-041)

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

(defn digits [num]
  (map #(Character/digit % 10) (str num)))

;; A pandigital number uses all the digits 1 to n exactly once and is also prime
;; What is the largest n-digit pandigital prime
;; note: this means it can't be more than 9 digits in length (1 .. 9)
(defn pandigital
  [num]
  (let [digs (sort (digits num))
        len (count digs)]
    (= (range 1 (inc len))
       digs)))

;; doesn't return
(defn find-maximum-pandigital-prime
  []
  (max (take-while (fn [x] (< (count (digits x)) 10)) primes)))


;; ----------------------------------------------------------------------------------------------------
;; ----------------------------------------------------------------------------------------------------

;; we know the number has to have all the digits from 1 to n without duplicates
;; This means n==9 is the largest possible 
;; Try all permutations of 1-9 for prime
;; If none then try 8 digit combinations, etc

(defn permutations
  "Accept a list of numbers and return all the permutations of those numbers"
  [s]
  (if (seq (rest s))
    (apply concat (for [x s] (map #(cons x %) (permutations (remove #{x} s)))))
    [s]))

(defn is-prime?
  "Test if prime by finding if the set of numbers which divide into n is empty.
  This can be sped up by exiting when a number if found that divides in (non-prime)"
  [n]
  (empty? (filter #(= 0 (mod n %)) (range 2 n))))

(defn str-to-int
  "Convert a number as string into a int"
  [x]
  (Integer/parseInt x))

(defn apply-str
  "Convert integer to a string"
  [v]
  (apply str v))


(defn problem-041
  []
  (loop [n 9]         ;; start with 9 digit numbers
    (if (zero? n)
      0
      (let [lst (filter is-prime? (map str-to-int (map apply-str (permutations (range 1 (inc n))))))]
        (if (seq lst)
          (reduce max lst)
          (recur (dec n)))))))

;; (problem-041) ;; => 7652413

