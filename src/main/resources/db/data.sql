INSERT INTO planet(name, description) VALUES('A', 'Earth');
INSERT INTO planet(name, description) VALUES('B', 'Moon');
INSERT INTO planet(name, description) VALUES('C', 'Jupiter');
INSERT INTO planet(name, description) VALUES('D', 'Venus');
INSERT INTO planet(name, description) VALUES('E', 'Mars');
INSERT INTO planet(name, description) VALUES('F', 'Saturn');
INSERT INTO planet(name, description) VALUES('G', 'Uranus');
INSERT INTO planet(name, description) VALUES('H', 'Pluto');
INSERT INTO planet(name, description) VALUES('I', 'Neptune');
INSERT INTO planet(name, description) VALUES('J', 'Mercury');
INSERT INTO planet(name, description) VALUES('K', 'Alpha Centauri');
INSERT INTO planet(name, description) VALUES('L', 'Luhman 16');
INSERT INTO planet(name, description) VALUES('M', 'Epsilon Eridani');
INSERT INTO planet(name, description) VALUES('N', 'Groombridge 34');
INSERT INTO planet(name, description) VALUES('O', 'Epsilon Indi');
INSERT INTO planet(name, description) VALUES('P', 'Tau Ceti');
INSERT INTO planet(name, description) VALUES('Q', 'Kapteyn''s star');
INSERT INTO planet(name, description) VALUES('R', 'Gliese 687');
INSERT INTO planet(name, description) VALUES('S', 'Gliese 674');
INSERT INTO planet(name, description) VALUES('T', 'Gliese 876#');
INSERT INTO planet(name, description) VALUES('U', 'Gliese 832');
INSERT INTO planet(name, description) VALUES('V', 'Fomalhaut');
INSERT INTO planet(name, description) VALUES('W', 'Virginis');
INSERT INTO planet(name, description) VALUES('X', 'HD 102365');
INSERT INTO planet(name, description) VALUES('Y', 'Gliese 176');
INSERT INTO planet(name, description) VALUES('Z', 'Gliese 436');
INSERT INTO planet(name, description) VALUES('A''', 'Pollux');
INSERT INTO planet(name, description) VALUES('B''', 'Gliese 86');
INSERT INTO planet(name, description) VALUES('C''', 'HIP 57050');
INSERT INTO planet(name, description) VALUES('D''', 'Piscium');
INSERT INTO planet(name, description) VALUES('E''', 'GJ 1214');
INSERT INTO planet(name, description) VALUES('F''', 'Upsilon Andromedae');
INSERT INTO planet(name, description) VALUES('G''', 'Gamma Cephei');
INSERT INTO planet(name, description) VALUES('H''', 'HD 176051');
INSERT INTO planet(name, description) VALUES('I''', 'Gliese 317');
INSERT INTO planet(name, description) VALUES('J''', 'HD 38858');
INSERT INTO planet(name, description) VALUES('K''', 'Ursae Majoris');
INSERT INTO planet(name, description) VALUES('L''', 'Lemons');

INSERT INTO edge(id, origin, destination, distance) VALUES(1, 'A', 'B', 0.44);
INSERT INTO edge(id, origin, destination, distance) VALUES(2, 'A', 'C', 1.89);
INSERT INTO edge(id, origin, destination, distance) VALUES(3, 'A', 'D', 0.10);
INSERT INTO edge(id, origin, destination, distance) VALUES(4, 'B', 'H', 2.44);
INSERT INTO edge(id, origin, destination, distance) VALUES(5, 'B', 'E', 3.45);
INSERT INTO edge(id, origin, destination, distance) VALUES(6, 'C', 'F', 0.49);
INSERT INTO edge(id, origin, destination, distance) VALUES(7, 'D', 'L', 2.34);
INSERT INTO edge(id, origin, destination, distance) VALUES(8, 'D', 'M', 2.61);
INSERT INTO edge(id, origin, destination, distance) VALUES(9, 'H', 'G', 3.71);
INSERT INTO edge(id, origin, destination, distance) VALUES(10, 'E', 'I', 8.09);
INSERT INTO edge(id, origin, destination, distance) VALUES(11, 'F', 'J', 5.46);
INSERT INTO edge(id, origin, destination, distance) VALUES(12, 'F', 'K', 3.67);
INSERT INTO edge(id, origin, destination, distance) VALUES(13, 'G', 'Z', 5.25);
INSERT INTO edge(id, origin, destination, distance) VALUES(14, 'I', 'Z', 13.97);
INSERT INTO edge(id, origin, destination, distance) VALUES(15, 'I', 'J', 14.78);
INSERT INTO edge(id, origin, destination, distance) VALUES(16, 'L', 'T', 15.23);
INSERT INTO edge(id, origin, destination, distance) VALUES(17, 'T', 'N', 10.43);
INSERT INTO edge(id, origin, destination, distance) VALUES(18, 'T', 'S', 14.22);
INSERT INTO edge(id, origin, destination, distance) VALUES(19, 'S', 'O', 6.02);
INSERT INTO edge(id, origin, destination, distance) VALUES(20, 'O', 'U', 5.26);
INSERT INTO edge(id, origin, destination, distance) VALUES(21, 'J', 'R', 12.34);
INSERT INTO edge(id, origin, destination, distance) VALUES(22, 'R', 'P', 10.10);
INSERT INTO edge(id, origin, destination, distance) VALUES(23, 'R', 'L''', 9.95);
INSERT INTO edge(id, origin, destination, distance) VALUES(24, 'Z', 'Y', 18.91);
INSERT INTO edge(id, origin, destination, distance) VALUES(25, 'Y', 'Q', 22.04);
INSERT INTO edge(id, origin, destination, distance) VALUES(26, 'Q', 'X', 10.51);
INSERT INTO edge(id, origin, destination, distance) VALUES(27, 'L''', 'X', 23.61);
INSERT INTO edge(id, origin, destination, distance) VALUES(28, 'X', 'K''', 19.94);
INSERT INTO edge(id, origin, destination, distance) VALUES(29, 'P', 'U', 9.31);
INSERT INTO edge(id, origin, destination, distance) VALUES(30, 'U', 'K''', 21.23);
INSERT INTO edge(id, origin, destination, distance) VALUES(31, 'U', 'J''', 25.96);
INSERT INTO edge(id, origin, destination, distance) VALUES(32, 'J''', 'V', 3.16);
INSERT INTO edge(id, origin, destination, distance) VALUES(33, 'K''', 'V', 20.42);
INSERT INTO edge(id, origin, destination, distance) VALUES(34, 'J''', 'I''', 17.10);
INSERT INTO edge(id, origin, destination, distance) VALUES(35, 'Y', 'A''', 19.52);
INSERT INTO edge(id, origin, destination, distance) VALUES(36, 'A''', 'B''', 31.56);
INSERT INTO edge(id, origin, destination, distance) VALUES(37, 'B''', 'C''', 23.13);
INSERT INTO edge(id, origin, destination, distance) VALUES(38, 'K''', 'W', 28.89);
INSERT INTO edge(id, origin, destination, distance) VALUES(39, 'W', 'C''', 10.64);
INSERT INTO edge(id, origin, destination, distance) VALUES(40, 'W', 'E''', 36.19);
INSERT INTO edge(id, origin, destination, distance) VALUES(41, 'C''', 'D''', 36.48);
INSERT INTO edge(id, origin, destination, distance) VALUES(42, 'E''', 'E''', 41.26);
INSERT INTO edge(id, origin, destination, distance) VALUES(43, 'E''', 'F''', 42.07);
INSERT INTO edge(id, origin, destination, distance) VALUES(44, 'F''', 'G''', 17.63);
INSERT INTO edge(id, origin, destination, distance) VALUES(45, 'G''', 'H''', 40.48);