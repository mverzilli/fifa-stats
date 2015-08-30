  (defproject fifa-stats "1.0.0-SNAPSHOT"
  :main fifa-stats.web
  :description "Demo Clojure web app"
  :url "http://clojure-getting-started.herokuapp.com"
  :license {:name "Eclipse Public License v1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-devel "1.2.2"]
                 [environ "1.0.0"]
                 [clj-time "0.11.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [yesql "0.4.2"]
                 [ragtime "0.5.1"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.3.1"]
            [lein-environ "1.0.0"]
            [lein-ring "0.9.6"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "fifa-stats.jar"
  :profiles {:production {:env {:production true}}}
  :ring {:handler fifa-stats.web/app})
