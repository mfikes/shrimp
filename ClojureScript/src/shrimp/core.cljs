(ns shrimp.core
  (:require [shrimp.init]
            [goby.core :refer [env]]))

(defn map-keys [f m]
  (reduce-kv (fn [r k v] (assoc r (f k) v)) {} m))

(defn ^:export init!
  [js-env]

  (reset! env (map-keys keyword (cljs.core/js->clj js-env)))

  (enable-console-print!)
  (println "ClojureScript initialized: " @env)

  (when (:debug-build @env)
    (println "Connecting to brepl")
    (shrimp.init/weasel-connect)
    (set! *print-newline* true)))
