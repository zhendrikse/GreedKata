; ------------------------------- 
; U n i t  t e s t  l i b r a r y
; -------------------------------

;(defmacro fn-name
;  [f]
;  `(-> ~f var meta :name str)
;)

(defn execute-test [test-function, expected]
  (if (= (test-function) expected) 
    (println "Test ok") 
    (println (str "test failed, expected " expected " but was " (test-function)))
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

(defn count-ones [thrown-dice-list] 
  (count-occurrences 1 thrown-dice-list)
)       

(defn count-fives [thrown-dice-list] 
  (count-occurrences 5 thrown-dice-list)
)       

(defn score [thrown-dice-list]
  (cond
    (= (count-ones thrown-dice-list) 1) 100
    (= (count-fives thrown-dice-list) 1) 50
    ; Don't change below code as per request
    :else 0
  )
)

; ------------------
; U n i t  t e s t s
; ------------------
(defn single-one-rewards-onehundred [] (score '(1 4 2 4 5 6))) 
(execute-test single-one-rewards-onehundred 100)

(defn no-one-rewards-zero [] (score '(3 4 2 4 4 6)))
(execute-test no-one-rewards-zero 0)

(defn double-one-rewards-zero [] (score '(1 4 1 4 4 6)))
(execute-test double-one-rewards-zero 0)

(defn single-five-rewards-fifty [] (score '(3 4 2 4 5 6)))
(execute-test single-five-rewards-fifty 50)

(defn single-five-single-one-rewards-onefifty [] (score '(1 4 2 4 5 6)))
(execute-test single-five-single-one-rewards-onefifty 150)
