(ns project-euler.problem-022)

;; Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, 
;; begin by sorting it into alphabetical order. 
;; Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
;; 
;;
;; For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
;; So, COLIN would obtain a score of 938 × 53 = 49714.
;;
;; What is the total of all the name scores in the file?

;; After sorting, "COLIN" will be the 938th item
;; Score = (position-in-file/line-number * alphabetic-value-of-word)

(def fname "data/problem-022.txt")

;; 1. Load the names file data and sort
(require '[clojure.java.io :as io])
(defn load-names-from-file
  "Return the sequence of names contained in the names file"
  [fname]
  (with-open [rdr (io/reader fname)]
    (sort (clojure.string/split (first (line-seq rdr)) #","))
))

;; 2. Strip the quotes which surround the words
;; https://crossclj.info/fun/clojure.tools.string-utils/strip-quotes.html
(defn
^{ :doc "Strips the quotes from around the given string if they exist." }
  strip-quotes [string]
  (if string
    (let [last-char-index (dec (.length string))]
      (if (and (= (.substring string 0 1) "\"") (= (.substring string last-char-index) "\""))
        (.substring string 1 last-char-index)
        string))))

;; 3. Function to calculate the alphabetic code for a word
(defn alphabetic-code
  [w]
  (let [s (seq (clojure.string/lower-case w))]
    (reduce + (map #(- (int %) 96) s))))


;; 4. For each multiple the index/line number and the alphabetic code, sum the results

(defn problem-022
  []
  (let [sorted-words (map strip-quotes (load-names-from-file fname))
        indexed (map-indexed (fn [i n] [(inc i) n]) sorted-words)]
    (reduce + (map (fn [[i w]] (* (alphabetic-code w) i)) indexed))))

;; (problem-022) ;; => 871198282
