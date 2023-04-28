INSERT INTO client (client_national_id, client_phone_number, client_first_name, client_last_name)
VALUES ('24082000', '099-4750-456', 'Pero', 'Peric'),
       ('A12345678', '555-1234', 'John', 'Doe'),
       ('B23456789', '555-5678', 'Jane', 'Doe'),
       ('C34567890', '555-9012', 'Bob', 'Smith'),
       ('D45678901', '555-3456', 'Alice', 'Jones'),
       ('E56789012', '555-6789', 'Sam', 'Wilson'),
       ('F67890123', '555-2345', 'Emily', 'Nguyen'),
       ('G78901234', '555-7890', 'Michael', 'Brown'),
       ('H89012345', '555-9012', 'Sophie', 'Garcia'),
       ('I90123456', '555-3456', 'Adam', 'Jackson'),
       ('J01234567', '555-6789', 'Mia', 'Davis'),
       ('K12345678', '555-1234', 'Luke', 'Kim'),
       ('L23456789', '555-5678', 'Grace', 'Lee'),
       ('M34567890', '555-9012', 'Nathan', 'Scott'),
       ('N45678901', '555-3456', 'Rachel', 'Zhang'),
       ('O56789012', '555-6789', 'Ethan', 'Chen'),
       ('P67890123', '555-2345', 'Lila', 'Wang'),
       ('Q78901234', '555-7890', 'Kevin', 'Zhao'),
       ('R89012345', '555-9012', 'Olivia', 'Wu'),
       ('S90123456', '555-3456', 'Daniel', 'Gupta'),
       ('T01234567', '555-6789', 'Isabella', 'Patel'),
       ('U12345678', '555-1234', 'David', 'Sato'),
       ('V23456789', '555-5678', 'Yuna', 'Tanaka'),
       ('W34567890', '555-9012', 'Kyle', 'Kimura'),
       ('X45678901', '555-3456', 'Ava', 'Yamamoto'),
       ('Y56789012', '555-6789', 'Cameron', 'Ng'),
       ('Z67890123', '555-2345', 'Maya', 'Chin'),
       ('A78901234', '555-7890', 'Evan', 'Chu'),
       ('B89012345', '555-9012', 'Sophia', 'Shah'),
       ('C90123456', '555-3456', 'Jacob', 'Singh'),
       ('D01234567', '555-6789', 'Hannah', 'Patel');

INSERT INTO process (process_id, process_name)
VALUES ('ROOM_STATUS', 'Stanje sobe'),
       ('RESERVATION_STATUS', 'Stanje rezervacije'),
       ('OVERNIGHT_STAY_STATUS', 'Stanje noćenja');

INSERT INTO status (status_id, process_id, status_name)
VALUES ('ROOM_STATUS.OCCUPIED', 'ROOM_STATUS', 'Zauzeta'),
--     ('ROOM_STATUS.RESERVED', 'ROOM_STATUS', 'Rezervirana'),
       ('ROOM_STATUS.READY', 'ROOM_STATUS', 'Slobodna'),
       ('ROOM_STATUS.UNREADY', 'ROOM_STATUS', 'Nespremna'),
       ('RESERVATION_STATUS.PENDING', 'RESERVATION_STATUS', 'U tijeku'),
       ('RESERVATION_STATUS.CANCELED', 'RESERVATION_STATUS', 'Otkazana'),
       ('RESERVATION_STATUS.FINISHED', 'RESERVATION_STATUS', 'Uspješna'),
       ('OVERNIGHT_STAY_STATUS.PENDING', 'OVERNIGHT_STAY_STATUS', 'U tijeku'),
       ('OVERNIGHT_STAY_STATUS.FINISHED', 'OVERNIGHT_STAY_STATUS', 'Završeno');

INSERT INTO room_bed_category (room_bed_category_id, room_bed_category_name)
VALUES ('DOUBLE_BED', 'Jedan bračni krevet'),
       ('ONE_SINGLE_BED', 'Jedan jednostruki krevet'),
       ('TWO_SINGLE_BED', 'Dva jednostruka kreveta'),
       ('THREE_SINGLE_BED', 'Tri jednostruka kreveta');

INSERT INTO room_quality_category (room_quality_category_id, room_quality_category_name)
VALUES ('BASIC', 'Minimalno opremljena'),
       ('STANDARD', 'Normalno opremljena '),
       ('PREMIUM', 'Luksuzno opremljena');

INSERT INTO room_category (room_category_id, room_category_name, room_category_price, room_bed_category_id, room_quality_category_id)
VALUES ('B_DOUBLE', 'Obična bračni krevet', 50, 'DOUBLE_BED', 'BASIC'),
       ('S_DOUBLE', 'Standardna bračni krevet', 100, 'DOUBLE_BED', 'STANDARD'),
       ('P_DOUBLE', 'Luksuzna bračni krevet', 200, 'DOUBLE_BED', 'PREMIUM'),
       ('B_ONE_SINGLE', 'Obična jednokrevetna', 30, 'ONE_SINGLE_BED', 'BASIC'),
       ('S_ONE_SINGLE', 'Standardna jednokrevetna', 60, 'ONE_SINGLE_BED', 'STANDARD'),
       ('B_TWO_SINGLE', 'Obična dvokrevetna', 50, 'TWO_SINGLE_BED', 'BASIC'),
       ('S_TWO_SINGLE', 'Standardna dvokrevetna', 100, 'TWO_SINGLE_BED', 'STANDARD'),
       ('B_THREE_SINGLE', 'Obična trokrevetna', 80, 'THREE_SINGLE_BED', 'BASIC'),
       ('S_THREE_SINGLE', 'Standardna trokrevetna', 160, 'THREE_SINGLE_BED', 'STANDARD');

INSERT INTO room (room_code, room_floor, room_status_id, room_category_id)
VALUES ('001', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('002', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('003', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('004', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('005', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('006', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('007', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('008', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('009', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('010', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
       ('011', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('012', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('013', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('014', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('015', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('016', 1, 'ROOM_STATUS.READY', 'B_ONE_SINGLE'),
       ('017', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('018', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('019', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('020', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('021', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('022', 1, 'ROOM_STATUS.READY', 'B_TWO_SINGLE'),
       ('023', 1, 'ROOM_STATUS.READY', 'B_THREE_SINGLE'),
       ('024', 1, 'ROOM_STATUS.READY', 'B_THREE_SINGLE'),
       ('025', 1, 'ROOM_STATUS.READY', 'B_THREE_SINGLE'),
       ('026', 1, 'ROOM_STATUS.READY', 'B_THREE_SINGLE'),
       ('001', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('002', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('003', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('004', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('005', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('006', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('007', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('008', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('009', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('010', 2, 'ROOM_STATUS.READY', 'S_DOUBLE'),
       ('011', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('012', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('013', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('014', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('015', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('016', 2, 'ROOM_STATUS.READY', 'S_ONE_SINGLE'),
       ('017', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('018', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('019', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('020', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('021', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('022', 2, 'ROOM_STATUS.READY', 'S_TWO_SINGLE'),
       ('023', 2, 'ROOM_STATUS.READY', 'S_THREE_SINGLE'),
       ('024', 2, 'ROOM_STATUS.READY', 'S_THREE_SINGLE'),
       ('025', 2, 'ROOM_STATUS.READY', 'S_THREE_SINGLE'),
       ('026', 2, 'ROOM_STATUS.READY', 'S_THREE_SINGLE'),
       ('001', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('002', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('003', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('004', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('005', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('006', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('007', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('008', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('009', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('010', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('011', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('012', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('013', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('014', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('015', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('016', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('017', 3, 'ROOM_STATUS.READY', 'P_DOUBLE'),
       ('018', 3, 'ROOM_STATUS.READY', 'P_DOUBLE');

INSERT INTO reservation (client_id, room_id, reservation_date_from, reservation_date_to, reservation_status_id)
VALUES (10, 10, '2023-06-10', '2023-06-12', 'RESERVATION_STATUS.PENDING'),
       (11, 11, '2023-06-08', '2023-06-10', 'RESERVATION_STATUS.PENDING'),
       (12, 12, '2023-06-15', '2023-06-18', 'RESERVATION_STATUS.PENDING'),
       (13, 13, '2023-06-20', '2023-06-25', 'RESERVATION_STATUS.PENDING'),
       (14, 14, '2023-07-01', '2023-07-05', 'RESERVATION_STATUS.PENDING'),
       (15, 15, '2023-07-10', '2023-07-12', 'RESERVATION_STATUS.PENDING'),
       (16, 16, '2023-07-08', '2023-07-10', 'RESERVATION_STATUS.PENDING'),
       (17, 17, '2023-07-15', '2023-07-18', 'RESERVATION_STATUS.PENDING'),
       (18, 18, '2023-07-20', '2023-07-25', 'RESERVATION_STATUS.PENDING'),
       (19, 19, '2023-08-01', '2023-08-05', 'RESERVATION_STATUS.PENDING'),
       (20, 20, '2023-08-10', '2023-08-12', 'RESERVATION_STATUS.PENDING'),
       (21, 21, '2023-08-08', '2023-08-10', 'RESERVATION_STATUS.PENDING'),
       (22, 22, '2023-08-15', '2023-08-18', 'RESERVATION_STATUS.PENDING'),
       (23, 23, '2023-08-20', '2023-08-25', 'RESERVATION_STATUS.PENDING'),
       (24, 24, '2023-09-01', '2023-09-05', 'RESERVATION_STATUS.PENDING'),
       (25, 25, '2023-09-10', '2023-09-12', 'RESERVATION_STATUS.PENDING'),
       (26, 26, '2023-09-08', '2023-09-10', 'RESERVATION_STATUS.PENDING'),
       (27, 27, '2023-09-15', '2023-09-18', 'RESERVATION_STATUS.PENDING');
