(ns swing1
  (:use [clojure.contrib.swing-utils])
  (:import [javax.swing JFrame JLabel JButton JEditorPane SwingConstants UIManager]
           [java.awt BorderLayout]))
; Display the JFrame
(defn setNativeLookUI []
  ;; Use the operating system native UI look and feel, do not use the Swing oriented look
  (. UIManager (setLookAndFeel "com.sun.java.swing.plaf.windows.WindowsLookAndFeel")))
(let [my-label (JLabel. "Hello World!" SwingConstants/CENTER)
      panel (doto (JEditorPane. "text/html" "<h1>Sample text</h1><p>This is sample text</p>") )
      button (doto (JButton. "Do it!")
                  (add-action-listener
                    (fn [_]
                      (.setText my-label "Hello Clojure!")
                      (.setText panel (slurp "http://www.xkcd.com/"))
                    )))
     ]
     (doto 
        (JFrame. "My Swing App")
        (.setLayout (BorderLayout.))
        (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
        (.setSize 300 300)
        (.add "Center" button)
        (.add "South" my-label)
        (.add "North" panel)
        (.setVisible true)
        (.setAlwaysOnTop true)
     )
     (setNativeLookUI)
)