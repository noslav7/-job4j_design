SELECT id, purpose, client_id, amount, payment_date
FROM transactions
WHERE amount
NOT BETWEEN 100 AND 200;
