(ns shrimp.detail-view-controller
  (:require [shrimp.database :refer [database-manager]])
  (:require-macros [goby.macros :refer [defui]]))

(defui name-text-field description-text-field edible-switch)

(def shrimp (atom nil))

(defn do-name-changed! [new-name]
  (set! (.-name @shrimp) new-name)
  (.saveContext @database-manager))

(defn do-description-changed! [new-description]
  (set! (.-desc @shrimp) new-description)
  (.saveContext @database-manager))

(defn do-edible-changed! [new-value]
  (set! (.-edibleFlag @shrimp) new-value)
  (.saveContext @database-manager))

(defn- handle-view-did-load! []
  (set! (.-text @name-text-field) (.-name @shrimp))
  (set! (.-text @description-text-field) (.-desc @shrimp))
  (set! (.-on @edible-switch) (.-edibleFlag @shrimp))
  (.setEditingChangedCallback @name-text-field do-name-changed!)
  (.setEditingChangedCallback @description-text-field do-description-changed!)
  (.setValueChangedCallback @edible-switch do-edible-changed!))
