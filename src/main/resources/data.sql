INSERT INTO contacts (id, first_name, last_name, alias, phone_number)
VALUES (1001, 'Aliisa', 'Sära', 'Särin', '53333333'),
       (1002, 'Karl', 'Rebane', 'Reps', '544444444')
ON CONFLICT (id) DO NOTHING;

