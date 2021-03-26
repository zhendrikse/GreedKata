; ------------------------------- 
; U n i t  t e s t  l i b r a r y
; -------------------------------

(defn execute-test [text, expected, actual]
  (if (= actual expected) 
    (str "Running " text "... ok")
    (str "Running " text "... failed, expected >>" expected "<< but was >>" actual "<<")
  )
)

; ------------------
; G r e e d  c o d e
; ------------------

; Function stolen from stackoverflow 
(defn count-occurrences [s searchlist]
  (->> searchlist
       flatten
       (filter #{s})
       count))

(defn score-ones [thrown-dice-list] 
  (if (= (count-occurrences 1 thrown-dice-list) 1) 100 0)
)       

(defn score-fives [thrown-dice-list] 
  (if (= (count-occurrences 5 thrown-dice-list) 1) 50 0)
)       

(defn score [thrown-dice-list]
  (+ (score-ones thrown-dice-list) (score-fives thrown-dice-list))
)

; ------------------
; U n i t  t e s t s
; ------------------
(execute-test "single one in list" 100  (score '(1 4 2 4 6 6)))

(execute-test "not a single one in list" 0 (score '(3 4 2 4 6 6))) 

(execute-test "double one in list" 0 (score '(1 4 1 4 4 6)))

(execute-test "single five in list" 50 (score '(3 4 2 4 5 6)))

(execute-test "double five in list" 0 (score '(5 4 2 4 5 6)))

(execute-test "single five and single in list" 150 (score '(1 4 2 4 5 6)))
