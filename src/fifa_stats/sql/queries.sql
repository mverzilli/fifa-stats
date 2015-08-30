-- name: create-match<!
-- Creates a match
INSERT INTO match (team1, team2, player1, player2, player3, player4, score_team1, score_team2, updated_at, created_at)
VALUES (:team1, :team2, :player1, :player2, :player3, :player4, :score_team1, :score_team2, :updated_at, :created_at)

-- name: list-singles
-- List all single matches
SELECT *
FROM match
WHERE player2 IS NULL AND player4 IS NULL
ORDER BY created_at DESC
