DELETE FROM show_seat;
DELETE FROM movie_show;
DELETE FROM movies;
DELETE FROM screen_seats;
DELETE FROM seat;
DELETE FROM screen;
DELETE FROM theatre;
DELETE FROM region;

ALTER TABLE show_seat AUTO_INCREMENT = 1;
ALTER TABLE movie_show AUTO_INCREMENT = 1;
ALTER TABLE movies AUTO_INCREMENT = 1;
ALTER TABLE screen_seats AUTO_INCREMENT = 1;
ALTER TABLE seat AUTO_INCREMENT = 1;
ALTER TABLE screen AUTO_INCREMENT = 1;
ALTER TABLE theatre AUTO_INCREMENT = 1;
ALTER TABLE region AUTO_INCREMENT = 1;

INSERT INTO region(latitude,longitude,name) VALUES (1.1, 2.1, 'Delhi');
INSERT INTO region(latitude,longitude,name) VALUES (3.1, 2.5, 'Mumbai');

INSERT INTO theatre(address,name,region_id) VALUES
('3. Bangla road','PVR',1),('4. MG road','MBD',2);

INSERT INTO screen(name,theatre_id) VALUES
('Screen1',1),('Screen2',1),('Screen3',2);

INSERT INTO seat(col_num, seat_number, row_num, seat_type) VALUES
(1,12,'A',1),(1,19,'C',2),(1,20,'D',2);

INSERT INTO screen_seats(screen_id, seats_id)  VALUES
(1,1),(1,2),(2,3);

INSERT INTO movies(category, duration, language, name, rating) VALUES
                                                                   ('DRAMA',180,'HINDI','kal ho na ho',4.0),
                                                                   ('ACTION',200,'TELUGU','baahubali',5.0);

INSERT INTO movie_show(end_time, start_time, movie_id, screen_id) VALUES
                                                                      ('2020-09-11','2020-08-10',1,1),
                                                                      ('2020-09-11','2020-08-11',2,1),
                                                                      ('2020-09-11','2020-08-11',1,2);

INSERT INTO  show_seat(price, show_seat_status, seat_id, show_id) VALUES
                                                                      (100,1,1,1),
                                                                      (120,1,2,1),
                                                                      (140,1,3,1);