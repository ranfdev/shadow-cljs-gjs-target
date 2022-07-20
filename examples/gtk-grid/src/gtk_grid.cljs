(ns gtk-grid
  (:require ["gjs.gi.Gtk" :as Gtk]))

(defn click-handler []
  (println "REPL example"))

(defn activate [app]
  (let [btn (new Gtk/Button #js {:label "My Button"})
        win (new Gtk/ApplicationWindow
                 #js
                  {:application app
                   :title "Button handler"
                   :child btn})]
    (doto btn
      (.connect "clicked" #(click-handler)))
    (doto win
      (.present))))
(defn ^:export main []
  (Gtk/init)
  (let [app (new Gtk/Application)]
    ;; Setup window.
    (doto app
      (.connect "activate" activate)
      (.run nil))))

