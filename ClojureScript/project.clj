(defproject shrimp "0.1.0-SNAPSHOT"
            :description "Demo project for Goby."
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [org.clojure/clojurescript "0.0-2511"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [goby "0.1.0"]
                           [weasel "0.4.2"]]
            :plugins [[lein-cljsbuild "1.0.3"]
                      [jarohen/simple-brepl "0.1.2"]]
            :source-paths ["src"]
            :brepl {:ip "127.0.0.1"}
            :cljsbuild {:builds {:dev
                                  {:source-paths ["src"
                                                  "dev-src"]
                                   :compiler     {:output-to     "js/main.js"
                                                  :optimizations :whitespace
                                                  :static-fns    false
                                                  :externs       ["externs.js"]
                                                  :pretty-print  true}}
                                 :rel
                                  {:source-paths ["src"
                                                  "rel-src"]
                                   :compiler     {:output-to     "js/main.js"
                                                  :optimizations :advanced
                                                  :static-fns    true
                                                  :externs       ["externs.js"]
                                                  :pretty-print  false
                                                  :pseudo-names  false}}}})
