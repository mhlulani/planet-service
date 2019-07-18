-- CREATE SEQUENCE hibernate_sequence;
CREATE TABLE planet (name VARCHAR(10) PRIMARY KEY, description VARCHAR(50) NOT NULL);
CREATE TABLE edge (id BIGINT PRIMARY KEY, origin VARCHAR(10) NOT NULL, destination VARCHAR(10) NOT NULL, distance NUMERIC(12,2) NOT NULL);

ALTER TABLE edge ADD CONSTRAINT fk_origin FOREIGN KEY (origin) REFERENCES planet(name);
ALTER TABLE edge ADD CONSTRAINT fk_dest FOREIGN KEY (destination) REFERENCES planet(name);

