-- insert OPEN HOURS --
INSERT INTO open_hours (START_TIME, END_TIME) VALUES
('10:00:00', '14:00:00'),
('14:00:00', '18:00:00'),
('18:00:00', '22:00:00');

-- insert GAMES --
INSERT INTO GAME (NAME, OPEN_HOURS_ID, CAPACITY, PRICE) VALUES
('Carousel', 1, 20, 50.00);
('Bumper Cars', 2, 20, 50.00),
('Ferris Wheel', 3, 50, 80.00),
('Roller Coaster', 3, 30, 100.00),
