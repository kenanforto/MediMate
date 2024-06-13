-- drop and create schema
DROP SCHEMA IF EXISTS suppliesMS CASCADE;
CREATE SCHEMA suppliesMS;

-- create table
CREATE TABLE suppliesMS.supplies
(
    id               SERIAL PRIMARY KEY,
    medication_name  VARCHAR(100) NOT NULL,
    amount           INT NOT NULL,
    admin_id         INT NOT NULL
);
