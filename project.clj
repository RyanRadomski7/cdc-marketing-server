(defproject marketing "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.1"]]
  :ring {:handler marketing.handler/app}
  :main marketing.handler
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"] 
                        [ring "1.2.1"]
                        [ring/ring-jetty-adapter "1.2.1"]]}
   :uberjar {:aot :all
             :dependencies [[javax.servlet/servlet-api "2.5"]
                            [ring "1.2.1"]
                            [ring/ring-jetty-adapter "1.2.1"]]}})




















