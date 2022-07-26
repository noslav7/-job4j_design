SELECT id, purpose, client_id, amount, payment_date
FROM transactions
WHERE purpose != 'vacation'
AND amount < 150;