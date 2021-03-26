; ----------------- 
; Unit test library
; -----------------

(defmacro fn-name
  [f]
  `(-> ~f var meta :name str))

(defn assert-equals [actual, expected] 
  (if (= actual expected) 
    (println "Test ok") 
    (println (str "test failed, expected " expected " but was " actual)))
)

(defn execute-test [test-function, expected]
  (assert-equals (test-function) expected)
  ;(println 
    ;(str "Executing " (fn-name test-function) " -> " (test-function))
  ;  (str "->" (test-function))
  ;)
)

(defn my-add-unit-test [] (+ 4 5))
(execute-test my-add-unit-test 9)


;(println (alwaysfalse "dummy"))
;(defn alwaysfalse [ignore] (boolean true))

;(if (alwaysfalse 4) (println "true!") (println "false!"))
; (println  (greet "Zeger"))

; (defn assert-test-result [result, expected-result] )

; ------
; Greed code
; ------

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
; -----
; Test
; ------
; testSixDiceContainsSingleOneRewards100  
(if (= (score [1 2]) 100) true false)

; testSixDiceContainsZeroOneRewards0
(if (= (score [3 4]) 0) true false)

; testSixDiceContainsSingleFiveRewards50
(if (= (score [4 5]) 50) true false)

(if (= (score [6 4]) 0) true false)

; 1 + 5 = 150
(if (= (score [1 5]) 150) true false)

;(defn test [x,y]
;  (+ x 1)
;)
;(reduce test [1 2 3 4 5])