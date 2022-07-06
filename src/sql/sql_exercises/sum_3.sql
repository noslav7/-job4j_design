SELECT purpose, SUM(amount)
FROM transactions
GROUP BY purpose
ORDER BY purpose DESC