/* ############################## DATABASE CREATION ############################## */
CREATE DATABASE IF NOT EXISTS hotel;

USE hotel;

-- Room
CREATE TABLE IF NOT EXISTS room_type(
	code TINYINT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	description TEXT NOT NULL,
	capacity CHAR(1) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS room(
	room_number TINYINT PRIMARY KEY,
	available BOOLEAN DEFAULT FALSE,
	price DECIMAL NOT NULL,
	room_type TINYINT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP,
	FOREIGN KEY (room_type) REFERENCES room_type(code)
);

-- Guest
CREATE TABLE IF NOT EXISTS guest(
	id VARCHAR(20) PRIMARY KEY,
	first_name VARCHAR(30) NOT NULL,
	second_name VARCHAR(30),
	first_surname VARCHAR(30) NOT NULL,
	second_surname VARCHAR(30),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS phones(
	phone_number VARCHAR(15) PRIMARY KEY,
	owner VARCHAR(20) NOT NULL ,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP,
	FOREIGN KEY (owner) REFERENCES guest(id)
);

-- Reservation
CREATE TABLE IF NOT EXISTS reservation_status(
	code CHAR(2) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	description TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reservation(
	code INT PRIMARY KEY AUTO_INCREMENT,
	start_date DATE DEFAULT (CURRENT_DATE),
	start_time TIME DEFAULT (CURRENT_TIME),
	end_date DATE,
	end_time TIME,
	room TINYINT NOT NULL,
	guest VARCHAR(20) NOT NULL,
	status CHAR(2) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP,
	FOREIGN KEY (room) REFERENCES room(room_number),
	FOREIGN KEY (guest) REFERENCES guest(id),
	FOREIGN KEY (status) REFERENCES reservation_status(code)
);

-- Service
CREATE TABLE IF NOT EXISTS service(
	code TINYINT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	description TEXT NOT NULL,
	price DECIMAL NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reservation_service(
	quantity SMALLINT NOT NULL,
	total_price DECIMAL NOT NULL,
	reservation INT NOT NULL,
	service TINYINT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP,
	FOREIGN KEY (reservation) REFERENCES reservation(code),
	FOREIGN KEY (service) REFERENCES service(code),
	PRIMARY KEY(reservation, service)
);

/* ############################## DATA INSERTION ############################## */

-- Room
INSERT INTO room_type (code, name, description, capacity)
VALUES
	(1, 'Standard', 'Cozy and budget-friendly for solo travelers or couples.', '2'),
	(2, 'Deluxe', 'Spacious and luxurious with extra amenities for a relaxing stay.', '2'),
	(3, 'Suite', 'Opulent suite with a separate living area and stunning views.', '4'),
	(4, 'Family', 'Family-friendly room with ample space for parents and children.', '4'),
	(5, 'Presidential', 'Luxury suite with top-notch amenities and services.', '2');

INSERT INTO room (room_number, available, price, room_type)
VALUES 
	(101, FALSE, 70, 1),
	(102, TRUE, 90, 2),
	(103, FALSE, 140.00, 3),
	(104, TRUE, 120, 4),
	(105, FALSE, 200, 5);

-- Guest
INSERT INTO guest (id, first_name, second_name, first_surname, second_surname)
VALUES
	('1065473869', 'Manuel', 'Alejandro', 'Henao', NULL),
	('4639586', 'James', NULL, 'León', NULL),
	('6294083756', 'Sara', NULL, 'Pinzón', 'García'),
	('8716393', 'Daniel', NULL, 'Herrera', NULL),
	('1004928376', 'Juan', 'Esteban', 'Reyes', 'Arias');
 
INSERT INTO phones(phone_number, owner)
VALUES
	('3013467283', '1065473869'),
	('3098765294', '4639586'),
	('3156278349', '6294083756'),
	('3013467281', '1065473869'),
	('3108907890', '1004928376');
	
-- Reservation
INSERT INTO reservation_status (code, name, description)
VALUES
  ('RS', 'Reserved', 'The room is reserved and awaiting check-in.'),
  ('CN', 'Checked In', 'The guest has checked into the room.'),
  ('CO', 'Checked Out', 'The guest has checked out of the room.'),
  ('CA', 'Canceled', 'The reservation has been canceled.'),
  ('WA', 'Waiting Approval', 'The reservation is pending approval.');
 
INSERT INTO reservation (start_date, start_time, end_date, end_time, room, guest, status)
VALUES 
	(CURRENT_DATE, '12:30:00', CURRENT_DATE + INTERVAl 1 day, '12:30:00', 101, '1065473869', 'CN'),
	(CURRENT_DATE + INTERVAL 5 day, '10:00:00', CURRENT_DATE + INTERVAl 8 day, '10:00:00', 103, '4639586', 'RS'),
	(CURRENT_DATE, '02:30:00', CURRENT_DATE + INTERVAl 3 day, '02:30:00', 102, '6294083756', 'CA'),
	(CURRENT_DATE - INTERVAL 2 day, '23:00:00', CURRENT_DATE - INTERVAl 1 day, '23:00:00', 104, '8716393', 'CO'),
	(CURRENT_DATE, '13:00:00', CURRENT_DATE + INTERVAl 10 day, '13:00:00', 105, '1004928376', 'WA');

-- Services
INSERT INTO service (code, name, description, price)
VALUES
	(1, 'Room Cleaning', 'Daily cleaning and tidying of guest rooms', 25.00),
	(2, 'Breakfast Buffet', 'Full breakfast buffet for person with a variety of options.', 15.00),
	(3, 'Airport Shuttle', 'Shuttle service to and from the airport', 50.00),
	(4, 'Spa Package', 'Relaxing spa treatments and massages', 120.00),
	(5, 'Concierge Service', 'Personalized concierge assistance for guests', 20.00);


INSERT INTO reservation_service (quantity, total_price, reservation, service)
VALUES
	(2, 50.00, 1, 1),
	(1, 15.00, 1, 2),
	(3, 150.00, 2, 3),
	(1, 120.00, 4, 4),
	(2, 100.00, 1, 3);