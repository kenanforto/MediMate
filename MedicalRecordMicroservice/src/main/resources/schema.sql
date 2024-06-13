-- drop and create schema
DROP SCHEMA IF EXISTS medicalRecordMS cascade;
CREATE SCHEMA medicalRecordMS;

-- create tables
CREATE TABLE medicalRecordMS.admission_record
(
    id               SERIAL PRIMARY KEY,
    admitted_at      DATE DEFAULT CURRENT_DATE,
    urgent           BOOLEAN,
    patient_id       INT NOT NULL,
    doctor_id        INT NOT NULL
);

CREATE TABLE medicalRecordMS.medical_record
(
    id                    SERIAL PRIMARY KEY,
    description           TEXT NOT NULL,
    created_date          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    patient_id            INT NOT NULL,
    doctor_id             INT NOT NULL,
    admission_record_id   INT NOT NULL,
    FOREIGN KEY (admission_record_id) REFERENCES medicalrecord.admission_record (id)
);

CREATE TABLE medicalRecordMS.doctor
(
    id          SERIAL PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    title       VARCHAR(50) NOT NULL
);

CREATE TABLE medicalRecordMS.patient
(
    id          SERIAL PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    birthdate   DATE NOT NULL,
    gender      VARCHAR(10) NOT NULL,
    address     VARCHAR(255),
    phone_number VARCHAR(20)
);
