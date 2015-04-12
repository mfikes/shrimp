(ns shrimp.master-view-controller
  (:require [goby.core :refer [reify-fetched-results-controller-delegate TableViewDataSource
                               table-view-cell-editing-styles TableViewDelegate]]
            [shrimp.detail-view-controller]
            [shrimp.database :refer [database-manager]])
  (:require-macros [goby.macros :refer [defui reify]]))

(defui table-view)

(def fetched-results-controller (atom nil))

(defn setup-fetched-results-controller-delegate []
  (set! (.-cljsDelegate @fetched-results-controller)
        (reify-fetched-results-controller-delegate table-view)))

(defn setup-table-view-data-source []
  (set! (.-dataSource @table-view)
        (reify TableViewDataSource

          (number-of-rows-in-section [_ section]
            (.numberOfObjectsInSection @fetched-results-controller section))

          (init-cell-for-row-at-index-path [_ cell section row]
            (let [shrimp (.objectAtSectionRow @fetched-results-controller section row)]
              (set! (-> cell .-textLabel .-text) (.-name shrimp))))

          (number-of-sections [_]
            (.sectionCount @fetched-results-controller)))))

(defn setup-table-view-delegate []
  (set! (.-delegate @table-view)
        (reify TableViewDelegate
          (did-select-row-at-index-path [_ section row]
            (reset! shrimp.detail-view-controller/shrimp (.objectAtSectionRow @fetched-results-controller section row))))))

(defn- handle-view-did-load! []
  (when @fetched-results-controller
    (set! (.-cljsDelegate @fetched-results-controller) nil))
  (reset! fetched-results-controller (.createShrimpFetchedResultsController @database-manager))
  (setup-fetched-results-controller-delegate)
  (.performFetch @fetched-results-controller)

  (setup-table-view-data-source)
  (setup-table-view-delegate))