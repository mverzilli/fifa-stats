(ns fifa-stats.migrations
  (:require [ragtime.jdbc :as jdbc]
            [fifa-stats.data :as d]))

(def config
  {:datastore   (jdbc/sql-database (d/db))
   :migrations (jdbc/load-resources "migrations")})
