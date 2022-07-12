SELECT purpose, AVG(amount), SUM(amount)
FROM transactions
GROUP BY purpose
ORDER BY purpose ASC