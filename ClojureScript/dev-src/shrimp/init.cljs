(ns shrimp.init
  (:require [weasel.repl :as ws-repl]))

(defn weasel-connect []
  (ws-repl/connect "ws://localhost:9001"))
