(defproject shrimp "0.1.0-SNAPSHOT"
  :description "Demo project for Goby."
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2913"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [goby "0.1.0"]
                 [org.omcljs/ambly "0.1.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.0.5"]]
  :source-paths ["src"]
  :cljsbuild {:builds {:dev
                       {:source-paths ["src"]
                        :compiler     {:output-dir     "out"
                                       :output-to      "js/main.js"
                                       :optimizations  :none
                                       :cache-analysis true
                                       :source-map     true}}
                       :rel
                       {:source-paths ["src"]
                        :compiler     {:output-to     "js/main.js"
                                       :optimizations :advanced
                                       :externs       ["externs.js"]
                                       :pretty-print  false
                                       :pseudo-names  false}}}})
