SELECT id, first_name, last_name, active, email
FROM customers
WHERE length(last_name) >= 5
AND active = false;