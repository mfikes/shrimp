(ns shrimp.database)

(def database-manager (atom nil))

(defn ^:export set-database-manager! [database-manager]
  (reset! shrimp.database/database-manager database-manager))
