(ns project-euler.problem-017)

;; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
;; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

(def under-twenty [ "zero"
                    "one"
                    "two"
                    "three"
                    "four"
                    "five"
                    "six"
                    "seven"
                    "eight"
                    "nine"
                    "ten"
                    "eleven"
                    "twelve"
                    "thirteen"
                    "fourteen"
                    "fifteen"
                    "sixteen"
                    "seventeen"
                    "eighteen"
                    "nineteen"] )

(def tens [ "twenty"
            "thirty"
            "forty"
            "fifty"
            "sixty"
            "seventy"
            "eighty"
            "ninety" ] )

(defn say-under-twenty [n]
  (if (not (zero? n)) (nth under-twenty n)))

(defn say-tens [n]
  (if (< n 20) (say-under-twenty n)
      (let [idx (quot (rem n 100) 10)]
        (apply str (concat (nth tens (dec (dec idx))) " " (say-under-twenty (rem n 10)))))))

(defn say-hundreds [n]
  (let [idx (quot n 100)]
    (if (zero? (mod n 100))
      (apply str (concat (nth under-twenty idx) " hundred"))
      (apply str (concat (nth under-twenty idx) " hundred and " (say-tens (rem n 100)))))
    ))

(defn say-number 
  [n]
  (cond
    (= 1000 n) "one thousand"
    (< n 20) (say-under-twenty n)
    (< n 100) (say-tens n)
    (< n 1000) (say-hundreds n)
    :else "NUMBER IS LARGER THAN 1000"))

(defn remove-spaces 
  [s]
  (apply str (remove #(#{\space} %) s)))

(defn problem-017
  ([] (problem-017 1000))
  ([n] (count (remove-spaces (apply concat (map say-number (range 1 (inc n))))))))

;; (problem-017) ;; => 21124
