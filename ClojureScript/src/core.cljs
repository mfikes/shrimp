(ns shrimp.core
  (:require [shrimp.init]
            [goby-core :refer [map-keys env]]))

(defn ^:export init!
  [js-env]

  (reset! env (map-keys keyword (cljs.core/js->clj js-env)))

  (enable-console-print!)
  (println "ClojureScript initialized: " @env)

  (when (:debug-build @env)
    (println "Connecting to brepl")
    (literacy-log.init/weasel-connect)
    (set! *print-newline* true)))
