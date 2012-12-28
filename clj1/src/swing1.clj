(ns swing1
  (:import [javax.swing JFrame JLabel JButton JEditorPane SwingConstants UIManager JOptionPane]
           [java.awt BorderLayout]
           [java.awt.event ActionListener]))
; Display the JFrame
(defn setNativeLookUI []
  ;; Use the operating system native UI look and feel, do not use the Swing oriented look
  (. UIManager (setLookAndFeel "com.sun.java.swing.plaf.windows.WindowsLookAndFeel")))
(let [my-label (JLabel. "Hello World!" SwingConstants/CENTER)
      panel (doto (JEditorPane. "text/html" "<h1>Sample text</h1><p>This is sample text</p>") )
      button (doto (JButton. "Do it!")
                  (.addActionListener
                    (proxy [ActionListener] []
                      (actionPerformed [evt]
                        (JOptionPane/showMessageDialog  nil,
                          (str "<html>Hello from <b>Clojure</b>. Button "
                            (.getActionCommand evt) " clicked."))
                        (.setText panel (slurp "http://www.xkcd.com/"))
                    ))))
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