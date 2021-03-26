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

(defn score [dice] 100)

; -----
; Test
; ------
; testSixDiceContainsSingleOneRewards100
(def dice-with-single-one '(1 2 3 4 5 6))
(if (= (score dice-with-single-one) 100) true false)

; testSixDiceContainsZeroOneRewards0
(def dice-with-zero-one '(2 2 3 4 5 6))
(if (= (score dice-with-zero-one) 0) true false)


; testSixDiceContainsSingleOneRewards100
; (def dice-with-single-one '(1 2 3 4 5 6))
; (println dice)
; (if (= (score dice-with-single-one) 100) true false)

