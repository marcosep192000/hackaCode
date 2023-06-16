-- insert OPEN HOURS --
INSERT INTO open_hours (START_TIME, END_TIME) VALUES
('10:00:00', '14:00:00'),
('14:00:00', '18:00:00'),
('18:00:00', '22:00:00');

-- insert GAMES --
INSERT INTO games (NAME, OPEN_HOURS_ID, CAPACITY, PRICE) VALUES
('Carousel', 1, 20, 50.00),
('Bumper Cars', 2, 20, 50.00),
('Ferris Wheel', 3, 50, 80.00),
('Roller Coaster', 3, 30, 100.00);

-- insert CUSTOMERS --
INSERT INTO customers (FIRST_NAME, LAST_NAME, DNI, EMAIL, PHONE, BIRTHDATE, STATE, REGISTRATION_DATE) VALUES
('Rodrigo', 'De Paul', 45678912, 'rodrigodepaul@gmail.com', '+54 9 11 1234 5678', '1990-01-01', false, NOW()),
('Tini', 'Stoessel', 34567891, 'tinitinitini@gmail.com', '+54 9 11 1234 5678', '2000-01-01', false, NOW());
