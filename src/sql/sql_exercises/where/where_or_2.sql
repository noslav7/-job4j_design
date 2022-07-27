SELECT id, purpose, client_id, amount, payment_date FROM transactions WHERE purpose = 'Credit' OR amount > 170;
