(def my-list ["A" "B" "C" "D" "E" "F" "G" "H" "I"])

(println "Cartesian:")
(doseq [i my-list, j my-list]
  (print
    (str i "-" j " ")))

(println "\n\nSimple cycle:")
(doseq [i my-list]
  (prn i))
