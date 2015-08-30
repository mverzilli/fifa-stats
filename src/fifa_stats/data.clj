(ns fifa-stats.data
  (:require [yesql.core :refer [defqueries]]
            [clj-time.core :as t]
            [clj-time.coerce :as c]))

(def db {:classname "org.postgresql.Driver"
          :subprotocol "postgresql"
          :subname "//localhost:5432/fifa-stats"
          :user "fifa-stats",
          :password "fifa-stats"})

(defqueries "fifa_stats/sql/queries.sql")

(defn create-singles-match [team1 team2 player1 player2 score1 score2]
  (let [now (c/to-sql-time (t/now))]
    (create-match<! db team1 team2 player1 nil player2 nil score1 score2 now now)))

(defn all-singles []
  (list-singles db))
