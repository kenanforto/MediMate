-- drop and create schema
DROP SCHEMA IF EXISTS workingHoursMS cascade;
CREATE SCHEMA workingHoursMS;

-- create tables
CREATE TABLE workingHoursMS.track_working_hours
(
    id           SERIAL PRIMARY KEY,
    total_hours  INT,
    break_hours  INT,
    admin_id     INT NOT NULL
);

CREATE TABLE workingHoursMS.working_hours
(
    id                    SERIAL PRIMARY KEY,
    start_time            TIME NOT NULL,
    end_time              TIME NOT NULL,
    title                 VARCHAR(50) NOT NULL,
    doctor_id             INT NOT NULL,
    track_working_hours_id INT NOT NULL,
    FOREIGN KEY (track_working_hours_id) REFERENCES workingHoursMS.track_working_hours (id)
);
