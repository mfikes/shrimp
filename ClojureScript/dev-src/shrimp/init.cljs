(ns shrimp.init
  (:require [weasel.repl :as ws-repl]))

(defn weasel-connect []
  (println "Connecting to brepl")
  (ws-repl/connect "ws://127.0.0.1:9001"))
