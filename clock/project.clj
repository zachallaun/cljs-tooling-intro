(defproject clock "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2371"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild
  {:builds [{:id "clock"
             :source-paths ["src"]
             :compiler {:output-to "clock.js"
                        :output-dir "out"
                        :optimizations :none
                        :source-map true}}
            {:id "prod"
             :source-paths ["src"]
             :compiler {:optimizations :advanced
                        :externs ["resources/moment-externs.js"]
                        :output-to "clock_prod.js"}}]})
