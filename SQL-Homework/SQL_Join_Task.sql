SELECT c.name as Customer, c.zip, i.name as Item, i.description, s.quantity, s.price FROM customer c
JOIN sale s ON c.id = s.customer_id
JOIN item i ON s.item_id = i.id;