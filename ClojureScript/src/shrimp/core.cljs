(ns shrimp.core
  (:require [goby.core :refer [env]]
            [shrimp.database]
            [shrimp.master-view-controller]
            [shrimp.detail-view-controller]))

(defn map-keys [f m]
  (reduce-kv (fn [r k v] (assoc r (f k) v)) {} m))

(defn ^:export init!
  [js-env]

  (reset! env (map-keys keyword (cljs.core/js->clj js-env)))

  (enable-console-print!)
  (println "ClojureScript initialized: " @env)

  (when (:debug-build @env)
    (set! *print-newline* true)))
