(ns fifa-stats.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.handler :refer [site]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.stacktrace :as trace]
            [ring.middleware.params :as p]
            [environ.core :refer [env]]
            [fifa-stats.data :as data]))

(defroutes routes
  (GET "/singles" []
    {:status 200
     :body (data/all-singles)})
  (POST "/shorten/:slug" [slug target]
    {:status 200
     :body "foo"})
  (ANY "*" []
     (route/not-found (slurp (io/resource "404.html")))))

(def app (-> routes
             p/wrap-params))

(defn wrap-error-page [handler]
  (fn [req]
    (try (handler req)
          (catch Exception e
            {:status 500
              :headers {"Content-Type" "text/html"}
              :body (-> "500.html"
                        io/resource
                        slurp)}))))

(defn wrap-app [app]
  (-> app
    ((if (env :production)
          wrap-error-page
          trace/wrap-stacktrace))))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))
