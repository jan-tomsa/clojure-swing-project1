(ns swing1
  (:use [clojure.contrib.swing-utils])
  (:import [javax.swing JFrame JLabel JButton SwingConstants UIManager]
           [java.awt BorderLayout]))
; Display the JFrame
(defn setNativeLookUI []
  ;; Use the operating system native UI look and feel, do not use the Swing oriented look
  (. UIManager (setLookAndFeel "com.sun.java.swing.plaf.windows.WindowsLookAndFeel")))
(let [my-label (JLabel. "Hello World!" SwingConstants/CENTER)
        button (doto (JButton. "Do it!")
                  (add-action-listener
                    (fn [_]
                     (.setText my-label
                      "Hello Clojure!"))))]
     (doto 
        (JFrame. "My Swing App")
        (.setLayout (BorderLayout.))
	(.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
	(.setSize 200 200)
	(.add "Center" button)
	(.add "South" my-label)
	(.setVisible true)
	(.setAlwaysOnTop true)
     )
     (setNativeLookUI)
)
