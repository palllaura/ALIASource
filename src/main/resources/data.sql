INSERT INTO contacts (id, first_name, last_name, alias, phone_number)
VALUES (1001, 'Aliisa', 'Sära', 'Särin', '53333333'),
       (1002, 'Karl', 'Rebane', 'Reps', '544444444'),
       (1003, 'Janet', 'Kose', 'Kosmos', '56893245'),
       (1004, 'Hektor', 'Kivi', 'Ivik', '53789231'),
       (1005, 'Mia', 'Räästas', 'Rästas', '52175432'),
       (1006, 'Fred', 'Tammeorg', 'Tõru', '56333789'),
       (1007, 'Ago', 'Saviauk', 'Aks', '52412334'),
       (1008, 'Elisabeth', 'Posti', 'Belladonna', '59765678'),
       (1009, 'Markus', 'Kuuse', 'Okas', '53232232'),
       (1010, 'Piia', 'Jänes', 'Pirx', '53111111')
ON CONFLICT (id) DO NOTHING;

