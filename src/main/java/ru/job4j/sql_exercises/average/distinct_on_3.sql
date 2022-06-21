SELECT DISTINCT ON (price) name, price, count
FROM products
ORDER BY name, price, count