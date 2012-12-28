(def my-list ["A" "B" "C" "D" "E" "F" "G" "H" "I"])

(doseq [i my-list, j my-list]
  (print (str "*" i) )
  )


(doseq [i my-list]
  (prn i)
  )
