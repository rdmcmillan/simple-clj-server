(defproject web-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.18"]
                 [compojure "1.5.0"]
                 [ring "1.2.1"]
                 [hiccup "1.0.5"]
                 [garden "1.3.2"]]
  :main ^:skip-aot web-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
