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

(defn score-occurrences [dice-list value times score]
  (if (= (count-occurrences value dice-list) times) score 0)
)

(defn score [dice-list]
  (+ 
    (score-occurrences dice-list 1 1 100)  ; single one -> 100
    (score-occurrences dice-list 1 3 1000) ; tripe one -> 1000 
    (score-occurrences dice-list 2 3 200)  ; tripe one -> 1000 
    (score-occurrences dice-list 3 3 300)  ; tripe one -> 1000 
    (score-occurrences dice-list 4 3 400)  ; tripe one -> 1000 
    (score-occurrences dice-list 5 1 50)   ; single five -> 50
    (score-occurrences dice-list 5 3 500)  ; tripe one -> 1000 
    (score-occurrences dice-list 6 3 600)  ; tripe one -> 1000 
  )
)

; ------------------
; U n i t  t e s t s
; ------------------
(execute-test "single one in list" 100  (score '(1 4 2 4 6 6)))
(execute-test "not a single one in list" 0 (score '(3 4 2 4 6 6))) 
(execute-test "double one in list" 0 (score '(1 4 1 4 6 6)))
(execute-test "single five in list" 50 (score '(3 4 2 4 5 6)))
(execute-test "double five in list" 0 (score '(5 4 2 4 5 6)))
(execute-test "single five and single in list" 150 (score '(1 4 2 4 5 6)))
(execute-test "triple one in list" 1000 (score '(1 2 4 6 1 1)))
(execute-test "triple two in list" 200 (score '(2 6 4 6 2 2)))
(execute-test "triple three in list" 300 (score '(3 2 4 6 3 3)))
(execute-test "triple four in list" 400 (score '(3 2 4 6 4 4)))
(execute-test "triple five in list" 500 (score '(5 2 4 6 5 5)))
(execute-test "triple six in list" 600 (score '(3 2 4 6 6 6)))

(execute-test "test case 1 from kata" 1150 (score '(1 1 1 5 1)))
(execute-test "test case 2 from kata" 0 (score '(2 3 4 6 2)))
(execute-test "test case 3 from kata" 350 (score '(3 4 5 3 3)))
