(defproject shrimp "0.1.0-SNAPSHOT"
  :description "Demo project for Goby."
  :dependencies [[org.clojure/clojure "1.7.0-beta1"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [goby "0.3.1"]
                 [org.omcljs/ambly "0.1.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.0.5"]]
  :source-paths ["src"]
  :clean-targets ["target" "out"]
  :cljsbuild {:builds {:dev
                       {:source-paths ["src"]
                        :compiler     {:output-to      "out/main.js"
                                       :output-dir     "out"
                                       :optimizations  :none}}
                       :rel
                       {:source-paths ["src"]
                        :compiler     {:output-to     "out/main.js"
                                       :optimizations :advanced
                                       :externs       ["externs.js"]
                                       :pretty-print  false
                                       :pseudo-names  false}}}})
