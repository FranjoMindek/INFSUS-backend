-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO
    client (client_national_id, client_phone_number, client_first_name, client_last_name)
VALUES
    ('12312312321321', '099-4750-456', 'Pero', 'Peric');

INSERT INTO
    process (process_id, process_name)
VALUES
    ('ROOM_STATUS', 'Stanje sobe'),
    ('RESERVATION_STATUS', 'Stanje rezervacije'),
    ('OVERNIGHT_STAY_STATUS', 'Stanje noćenja');

INSERT INTO
    status (status_id, process_id, status_name)
VALUES
    ('ROOM_STATUS.OCCUPIED', 'ROOM_STATUS', 'Zauzeta'),
--     ('ROOM_STATUS.RESERVED', 'ROOM_STATUS', 'Rezervirana'),
    ('ROOM_STATUS.READY', 'ROOM_STATUS', 'Slobodna'),
    ('ROOM_STATUS.UNREADY', 'ROOM_STATUS', 'Nespremna'),
    ('RESERVATION_STATUS.PENDING', 'RESERVATION_STATUS', 'U tijeku'),
    ('RESERVATION_STATUS.CANCELED', 'RESERVATION_STATUS', 'Otkazana'),
    ('RESERVATION_STATUS.FINISHED', 'RESERVATION_STATUS', 'Uspješna'),
    ('OVERNIGHT_STAY_STATUS.PENDING', 'OVERNIGHT_STAY_STATUS', 'U tijeku'),
    ('OVERNIGHT_STAY_STATUS.FINISHED', 'OVERNIGHT_STAY_STATUS', 'Završeno');

INSERT INTO
    room_bed_category (room_bed_category_id, room_bed_category_name)
VALUES
    ('DOUBLE_BED', 'Jedan bračni krevet'),
    ('ONE_SINGLE_BED', 'Jedan jednostruki krevet'),
    ('TWO_SINGLE_BED', 'Dva jednostruka kreveta'),
    ('THREE_SINGLE_BED', 'Tri jednostruka kreveta');

INSERT INTO
    room_quality_category (room_quality_category_id, room_quality_category_name)
VALUES
    ('BASIC', 'Minimalno opremljena'),
    ('STANDARD', 'Normalno opremljena '),
    ('PREMIUM', 'Luksuzno opremljena');

INSERT INTO
    room_category (room_category_id, room_category_price, room_bed_category_id, room_quality_category_id)
VALUES
    ('B_DOUBLE', 50, 'DOUBLE_BED', 'BASIC'),
    ('S_DOUBLE', 100, 'DOUBLE_BED', 'STANDARD'),
    ('P_DOUBLE', 200, 'DOUBLE_BED', 'PREMIUM'),
    ('B_ONE_SINGLE', 30, 'ONE_SINGLE_BED', 'BASIC'),
    ('S_ONE_SINGLE', 60, 'ONE_SINGLE_BED', 'STANDARD'),
    ('B_TWO_SINGLE', 50, 'TWO_SINGLE_BED', 'BASIC'),
    ('S_TWO_SINGLE', 100, 'TWO_SINGLE_BED', 'STANDARD'),
    ('B_THREE_SINGLE', 80, 'THREE_SINGLE_BED', 'BASIC'),
    ('S_THREE_SINGLE', 160, 'THREE_SINGLE_BED', 'STANDARD');

INSERT INTO
    room (room_code, room_floor, room_status_id, room_category_id)
VALUES
    ('001', 1, 'ROOM_STATUS.READY', 'B_DOUBLE'),
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


