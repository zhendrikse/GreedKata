; ------------------------------- 
; U n i t  t e s t  l i b r a r y
; -------------------------------

(defmacro fn-name
  [f]
  `(-> ~f var meta :name str)
)

(defn do-execute-test [test-function, expected]
  (if (= (test-function) expected) 
    "Ok"
    (str "Nok: expected " expected " but was " (test-function))
  )
)

(defn execute-test [test-function, expected]
  (println (str "Executing test..." (do-execute-test test-function expected)))
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
(defn single-one-scores-onehundred [] (score '(1 4 2 4 6 6))) 
(execute-test single-one-scores-onehundred 100)

(defn no-one-scores-zero [] (score '(3 4 2 4 4 6)))
(execute-test no-one-scores-zero 0)

(defn double-one-scores-zero [] (score '(1 4 1 4 4 6)))
(execute-test double-one-scores-zero 0)

(defn single-five-scores-fifty [] (score '(3 4 2 4 5 6)))
(execute-test single-five-scores-fifty 50)

(defn double-five-scores-zero [] (score '(5 4 2 4 5 6)))
(execute-test double-five-scores-zero 0)

(defn single-five-single-one-scores-onefifty [] (score '(1 4 2 4 5 6)))
(execute-test single-five-single-one-scores-onefifty 150)
