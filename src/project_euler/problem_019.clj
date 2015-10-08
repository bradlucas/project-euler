(ns project-euler.problem-019)

;; 1 Jan 1900 was a Monday.
;;
;; Thirty days has September, April, June and November.
;; All the rest have thirty-one,
;; Saving February alone, Which has twenty-eight, rain or shine.
;; And on leap years, twenty-nine.
;; A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

;; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

;; Build the next Sundays and count when Sunday is the first of the month

;; -- The following are not used --
(defn days-feb 
  [year]
  (let [days 28]
    ;; ;; A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
    (if (or (zero? (mod year 400)) 
            (zero? (mod year 100)) 
            (zero? (mod year 4))) 
      (inc days)
      days)))

(defn in? 
  "true if seq contains elm"
  [elm seq]  
  (some #(= elm %) seq))

(defn month-days
  [month year]
  (cond 
    (= month 2) (days-feb year)
    (in? month  [ 4, 6, 9, 11]) 30
    :else 31))

;; day of the week function

(def months [:jan :feb :mar :apr :may :jun :jul :aug :sep :oct :nov :dec])
;; -- end of unused --

;; Need a function to get the day of the week for a specific date
;; Found this:
;; http://gettingclojure.wikidot.com/cookbook:time-and-dates
(defn zeller [year month day]
  ;; returns number between 0 (Saturday) and 6 (Friday).
  (let [m (+ (mod (+ month 9) 12) 3)
        y (- year (quot (- m month) 12))
        J (quot y 100)
        K (mod y 100)
        q day]
    (mod (+ q
            (quot (* 26 (inc m)) 10)
            K
            (quot K 4)
            (quot J 4)
            (* 5 J))
         7)))

(def days [:su :mo :tu :we :th :fr :sa])

(defn get-day
  [year month day]
  ;; translate the zeller return value to the index into days
  (nth days (mod (+ 6 (zeller year month day)) 7)))

(defn sunday-the-first
  "Return true if we have a Sunday on the first of the month"
  [year month day] 
  (and (= day 1)
       (= :su (get-day year month day))))


(defn problem-019
  []
  (count (filter true? (for [year (range 1901 (inc 2000))
                             month (range 1 13)]
                         (sunday-the-first year month 1)))))

;; (problem-019) => 171




;;----------------------------------------------------------------------------------------------------
;; References
;; http://www.timeanddate.com/date/doomsday-weekday.html
;; http://www.stoimen.com/blog/2012/04/24/computer-algorithms-how-to-determine-the-day-of-the-week/
;; http://gettingclojure.wikidot.com/cookbook:time-and-dates
