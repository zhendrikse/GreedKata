; ------------------------------- 
; U n i t  t e s t  l i b r a r y
; -------------------------------

(defmacro fn-name
  [f]
  `(-> ~f var meta :name str)
)

(defn execute-test [test-function, expected]
  (if (= (test-function) expected) 
    (println "Test ok") 
    (println (str "test failed, expected " expected " but was " (test-function)))
  )
)

; ------------------
; G r e e d  c o d e
; ------------------

(defn score [dice]
  (reduce addScoreForSingleDie 0,dice)
)

(defn addScoreForSingleDie [currentScore,die] 
;  (println "values: " currentScore die)
  (+ currentScore (calculateScoreForSingleDie die))
)

(defn calculateScoreForSingleDie [die]
  (cond
    (= die 1) 100
    (= die 5) 50
    ; Don't change below code as per request
    :else 0
  )
)

; ------------------
; U n i t  t e s t s
; ------------------
(defn single-one-rewards-onehundred [] (score [1 2]))  
(execute-test single-one-rewards-onehundred 100)

(defn no-one-rewards-zero [] (score [3 4]))
(execute-test no-one-rewards-zero 0)

(defn double-one-rewards-zero [] (score [1 1]))
(execute-test double-one-rewards-zero 0)

(defn single-five-rewards-fifty [] (score [5 4]))
(execute-test single-five-rewards-fifty 50)

(defn single-five-single-one-rewards-onefifty [] (score [1 5]))
(execute-test single-five-single-one-rewards-onefifty 150)
