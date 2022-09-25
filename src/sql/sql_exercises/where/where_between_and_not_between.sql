SELECT id, purpose, client_id, amount, payment_date
FROM transactions
WHERE amount
BETWEEN 80 AND 190
AND payment_date
NOT BETWEEN '2022-02-01 12:00:00' AND '2022-08-01 12:00:00';
