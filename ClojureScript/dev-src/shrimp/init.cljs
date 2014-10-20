(ns shrimp.init
  (:require [weasel.repl :as ws-repl]))

(defn weasel-connect []
  (ws-repl/connect "ws://127.0.0.1:9001"))
