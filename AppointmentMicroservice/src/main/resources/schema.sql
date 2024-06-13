-- drop and create schema
DROP SCHEMA IF EXISTS appointmentMS CASCADE;
CREATE SCHEMA appointmentMS;

-- create table
CREATE TABLE appointmentMS.appointment
(
    id                    SERIAL PRIMARY KEY,
    appointment_datetime  TIMESTAMP NOT NULL,
    created_date          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    patient_id            INT NOT NULL,
    doctor_id             INT NOT NULL
);
