SELECT purpose, AVG(amount)
FROM transactions
GROUP BY purpose