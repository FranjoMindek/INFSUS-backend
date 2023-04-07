DROP TABLE IF EXISTS process CASCADE;
CREATE TABLE IF NOT EXISTS process
(
    process_id   VARCHAR(64) PRIMARY KEY,
    process_name VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS status CASCADE;
CREATE TABLE  IF NOT EXISTS status
(
    status_id   VARCHAR(64) PRIMARY KEY,
    process_id  VARCHAR(64) NOT NULL,
    status_name VARCHAR(64) NOT NULL,
    FOREIGN KEY (process_id) REFERENCES process (process_id)
);

DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE  IF NOT EXISTS client
(
    client_id           SERIAL PRIMARY KEY,
    client_national_id  VARCHAR(64) NOT NULL UNIQUE,
    client_phone_number VARCHAR(64) NOT NULL,
    client_first_name   VARCHAR(64),
    client_last_name    VARCHAR(64)
);

DROP TABLE IF EXISTS room_bed_category CASCADE;
CREATE TABLE  IF NOT EXISTS room_bed_category
(
    room_bed_category_id   VARCHAR(64) PRIMARY KEY,
    room_bed_category_name VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS room_quality_category CASCADE;
CREATE TABLE  IF NOT EXISTS room_quality_category
(
    room_quality_category_id   VARCHAR(64) PRIMARY KEY,
    room_quality_category_name VARCHAR(64) NOT NULL
);

DROP TABLE IF EXISTS room_category CASCADE;
CREATE TABLE  IF NOT EXISTS room_category
(
    room_category_id         VARCHAR(64) PRIMARY KEY,
    room_category_price      INTEGER     NOT NULL,
    room_bed_category_id     VARCHAR(64) NOT NULL,
    room_quality_category_id VARCHAR(64) NOT NULL,
    FOREIGN KEY (room_bed_category_id) REFERENCES room_bed_category (room_bed_category_id),
    FOREIGN KEY (room_quality_category_id) REFERENCES room_quality_category (room_quality_category_id),
    UNIQUE (room_category_price, room_bed_category_id, room_quality_category_id)
);

DROP TABLE IF EXISTS room CASCADE;
CREATE TABLE  IF NOT EXISTS room
(
    room_id          SERIAL PRIMARY KEY,
    room_code        VARCHAR(16) NOT NULL,
    room_floor       INTEGER     NOT NULL,
    room_status_id   VARCHAR(64) NOT NULL,
    room_category_id VARCHAR(64) NOT NULL,
    FOREIGN KEY (room_category_id) REFERENCES room_category (room_category_id),
    FOREIGN KEY (room_status_id) REFERENCES status (status_id),
    UNIQUE (room_code, room_floor)
);

DROP TABLE IF EXISTS overnight_stay CASCADE;
CREATE TABLE  IF NOT EXISTS overnight_stay
(
    overnight_stay_id        SERIAL PRIMARY KEY,
    client_id                INTEGER NOT NULL,
    room_id                  INTEGER NOT NULL,
    overnight_stay_date_from DATE,
    overnight_stay_date_to   DATE,
    overnight_stay_status_id VARCHAR(64),
    FOREIGN KEY (client_id) REFERENCES client (client_id),
    FOREIGN KEY (room_id) REFERENCES room (room_id),
    FOREIGN KEY (overnight_stay_status_id) REFERENCES status (status_id)
);

DROP TABLE IF EXISTS reservation CASCADE;
CREATE TABLE  IF NOT EXISTS reservation
(
    reservation_id        SERIAL PRIMARY KEY,
    client_id             INTEGER NOT NULL,
    room_id               INTEGER NOT NULL,
    reservation_date_from DATE,
    reservation_date_to   DATE,
    reservation_status_id VARCHAR(64),
    FOREIGN KEY (client_id) REFERENCES client (client_id),
    FOREIGN KEY (room_id) REFERENCES room (room_id),
    FOREIGN KEY (reservation_status_id) REFERENCES status (status_id)
);