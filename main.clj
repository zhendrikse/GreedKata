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

(defn score [dice]
  ; only 100 when 1x 1
  (cond
    (= dice 1) 100
    (= dice 5) 50
    :else 0
  )
)

; -----
; Test
; ------
; testSixDiceContainsSingleOneRewards100  
(def dice-with-single-one 1)
(if (= (score dice-with-single-one) 100) true false)

; testSixDiceContainsZeroOneRewards0
(def dice-with-zero-one 2)
(if (= (score dice-with-zero-one) 0) true false)

; testSixDiceContainsSinglFiveRewards50
(def dice-with-single-five 5)
(if (= (score dice-with-single-five) 50) true false)

