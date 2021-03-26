; Remko en Zeger 
; '(1 2 3)     ; list
;(println "Hello world")

; (defn greet  [name]  (str "Hello, " name) )
; (defn test-greet-returns-zeger )

;(defn assert-equals [string1, string2] 
;  (if (= string1 string2) true false)
;)
;(println (assert-equals (str 4) "4"))

;(println (alwaysfalse "dummy"))
;(defn alwaysfalse [ignore] (boolean true))

;(if (alwaysfalse 4) (println "true!") (println "false!"))
; (println  (greet "Zeger"))

; (defn assert-test-result [result, expected-result] )

; ------
; Greed code
; ------

(defn score [die1 die2]
  (+ (scoreForSingleDie die1) (scoreForSingleDie die2))
)

(defn scoreForSingleDie [die]
  (cond
    (= die 1) 100
    (= die 5) 50
    :else 0
  )
)
; -----
; Test
; ------
; testSixDiceContainsSingleOneRewards100  
(if (= (score 1 2) 100) true (println "Test failed, the value is" (score 1 2)))

; testSixDiceContainsZeroOneRewards0
(if (= (score 3 4) 0) true false)

; testSixDiceContainsSingleFiveRewards50
(if (= (score 4 5) 50) true false)

(if (= (score 6 4) 0) true false)

; 1 + 5 = 150
(if (= (score 1 5) 150) true false)