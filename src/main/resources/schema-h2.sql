-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE process (
    process_id VARCHAR2(64 CHARACTERS) PRIMARY KEY,
    process_name VARCHAR2(64 CHARACTERS) NOT NULL
);

CREATE TABLE status (
    status_id VARCHAR2(64 CHARACTERS) PRIMARY KEY,
    process_id VARCHAR2(64 CHARACTERS) NOT NULL,
    status_name VARCHAR2(64 CHARACTERS) NOT NULL,
    FOREIGN KEY (process_id) REFERENCES process(process_id)
);

CREATE TABLE client (
    client_id SERIAL PRIMARY KEY,
    client_national_id VARCHAR2(64 CHARACTERS) NOT NULL UNIQUE,
    client_phone_number VARCHAR2(64 CHARACTERS) NOT NULL,
    client_first_name VARCHAR2(64 CHARACTERS),
    client_last_name VARCHAR2(64 CHARACTERS)
);

CREATE TABLE room_bed_category (
    room_bed_category_id VARCHAR2(64 CHARACTERS) PRIMARY KEY,
    room_bed_category_name VARCHAR2(64 CHARACTERS) NOT NULL
);

CREATE TABLE room_quality_category (
    room_quality_category_id VARCHAR2(64 CHARACTERS) PRIMARY KEY,
    room_quality_category_name VARCHAR2(64 CHARACTERS) NOT NULL
);

CREATE TABLE room_category (
    room_category_id VARCHAR2(64 CHARACTERS) PRIMARY KEY,
    room_category_price INTEGER NOT NULL,
    room_bed_category_id VARCHAR2(64 CHARACTERS) NOT NULL,
    room_quality_category_id VARCHAR2(64 CHARACTERS) NOT NULL,
    FOREIGN KEY (room_bed_category_id) REFERENCES room_bed_category(room_bed_category_id),
    FOREIGN KEY (room_quality_category_id) REFERENCES room_quality_category(room_quality_category_id)
);

CREATE TABLE room (
    room_id SERIAL PRIMARY KEY,
    room_code VARCHAR2(16 CHARACTERS) NOT NULL,
    room_floor INTEGER NOT NULL,
    room_status_id VARCHAR2(64 CHARACTERS) NOT NULL,
    room_category_id VARCHAR2(64 CHARACTERS) NOT NULL,
    FOREIGN KEY (room_category_id) REFERENCES room_category(room_category_id),
    FOREIGN KEY (room_status_id) REFERENCES status(status_id)
);

CREATE TABLE overnight_stay (
    overnight_stay_id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    overnight_stay_date_from DATE,
    overnight_stay_date_to DATE,
    overnight_stay_status_id VARCHAR2(64 CHARACTERS),
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    FOREIGN KEY (overnight_stay_status_id) REFERENCES status(status_id)
);

CREATE TABLE reservation (
    reservation_id SERIAL PRIMARY KEY,
    client_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    reservation_date_from DATE,
    reservation_date_to DATE,
    reservation_status_id VARCHAR2(64 CHARACTERS),
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    FOREIGN KEY (reservation_status_id) REFERENCES status(status_id)
);