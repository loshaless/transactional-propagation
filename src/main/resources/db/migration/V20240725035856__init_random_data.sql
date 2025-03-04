create table appointment
(
    id               bigint generated by default as identity
        constraint appointment_pk
            primary key,
    patient_id       integer                   not null
        constraint appointment_patient_id_fk
            references patient
            on update cascade on delete cascade,
    appointment_date date default CURRENT_DATE not null,
    appointment_time time default CURRENT_TIME not null,
    appointment_note varchar(1000)
);

comment on column appointment.patient_id is 'relate to table patient';

alter table appointment
    owner to "user";

create index appointment_appointment_date_index
    on appointment (appointment_date desc);

create index appointment_appointment_time_index
    on appointment (appointment_time desc);
--------------------------------------
create table patient
(
    id               integer generated by default as identity
        constraint patients_pk
            primary key,
    patient_name     varchar(50) not null,
    patient_email    varchar(50) not null,
    patient_phone_no varchar(50) not null
);

alter table patient
    owner to "user";

create unique index patient_phone_no_index
    on patient (patient_phone_no);
--------------------------------------

-- Insert 10 random patients
INSERT INTO patient (patient_name, patient_email, patient_phone_no)
SELECT
    left(md5(random()::text) || ' ' || md5(random()::text), 50) AS patient_name,
    left(md5(random()::text) || '@example.com', 50) AS patient_email,
    '555-' || lpad((random() * 10000)::int::text, 4, '0') AS patient_phone_no
FROM generate_series(1, 10);

-- Insert 100 random appointments
INSERT INTO appointment (patient_id, appointment_date, appointment_time, appointment_note)
SELECT
    patient_ids.id AS patient_id,
    CURRENT_DATE + (random() * 30)::int AS appointment_date,
    CURRENT_TIME + (random() * interval '12 hours') AS appointment_time,
    md5(random()::text) AS appointment_note
FROM generate_series(1, 100) gs
         JOIN (
    SELECT id FROM patient ORDER BY random() LIMIT 100
) patient_ids ON true;

truncate table appointment;