(ns project-euler.core
  (:gen-class :main true))

(defn run-problem
  [i]
    (let [number (format "%03d" i)
          function (symbol (str "problem-" number))]
      (use (vec (list (symbol (str "project-euler.problem-" number)))))
      (println (eval (list function)))))

(def completed-problem-numbers (concat (range 1 26) '(41 67)))

(defn -main
  [& args]
  (if (and args (= 1 (count args)))
    (let [i (Integer/parseInt (first args))
          valid (some #(= i %) completed-problem-numbers)]
      (if valid
        (run-problem i)
        (println "Completed problem numbers are " (clojure.string/join " " completed-problem-numbers))
        )
      )
    (println "Enter number: 1-25, 41 or 67")))
