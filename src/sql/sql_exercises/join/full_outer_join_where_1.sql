SELECT e.name, d.name
FROM employees AS e
FULL OUTER JOIN departments AS d on e.department_id = d.id
WHERE e.name IS NULL;