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
-- INSERT INTO customers (FIRST_NAME, LAST_NAME, DNI, EMAIL, PHONE, BIRTHDATE, STATE) VALUES
-- ('John', 'Doe', 12345678, 'johndoe@example.com', '+1234567890', '1990-01-01', false),
-- ('Alice', 'Smith', 23456789, 'alice.smith@example.com', '+9876543210', '1995-05-15', false),
-- ('Bob', 'Johnson', 34567891, 'bob.johnson@example.com', '+8765432109', '1988-08-20', false),
-- ('Eva', 'Brown', 14329876, 'eva.brown@example.com', '+7654321098', '1992-12-10', false),
-- ('Michael', 'Davis', 23548643,'michael.davis@example.com', '+6543210987', '1997-03-25', false);
