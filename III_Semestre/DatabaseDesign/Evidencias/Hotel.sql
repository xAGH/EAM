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
	avilable BOOLEAN DEFAULT FALSE,
	price DECIMAL(4, 2) NOT NULL,
	room_type TINYINT NOT NULL REFERENCES room_type(code),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
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
	owner VARCHAR(20) NOT NULL REFERENCES guest(id),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
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
	code INT PRIMARY KEY,
	start_date DATE DEFAULT (CURRENT_DATE),
	start_time TIME DEFAULT (CURRENT_TIME),
	end_date DATE,
	end_time TIME,
	room TINYINT NOT NULL REFERENCES room(room_number),
	guest VARCHAR(20) NOT NULL REFERENCES guest(id),
	status CHAR(2) NOT NULL REFERENCES reservation_status(code),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP
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
	reservation INT NOT NULL REFERENCES reservation(code),
	service TINYINT NOT NULL REFERENCES service(code),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP,
	deleted_at TIMESTAMP,
	PRIMARY KEY(reservation, service)
);