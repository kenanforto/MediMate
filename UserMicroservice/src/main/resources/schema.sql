-- Drop and create schema
DROP SCHEMA IF EXISTS userMS CASCADE;
CREATE SCHEMA userMS;

-- Create tables
CREATE TABLE userMS.user (
                               id              SERIAL PRIMARY KEY,
                               first_name      VARCHAR(255) NOT NULL,
                               last_name       VARCHAR(255) NOT NULL,
                               password        VARCHAR(255) NOT NULL,
                               email           VARCHAR(255) NOT NULL,
                               role_id         VARCHAR(255) NOT NULL
);

CREATE TABLE userMS.admin (
                                id              SERIAL PRIMARY KEY,
                                user_id         INT NOT NULL,
                                FOREIGN KEY (user_id) REFERENCES aeesuser.user (id)
);

CREATE TABLE userMS.doctor (
                                 id              SERIAL PRIMARY KEY,
                                 title           VARCHAR(255) NOT NULL,
                                 user_id         INT NOT NULL,
                                 FOREIGN KEY (user_id) REFERENCES aeesuser.user (id)
);

CREATE TABLE userMS.patient (
                                  id              SERIAL PRIMARY KEY,
                                  birthdate       DATE,
                                  gender          VARCHAR(255),
                                  address         VARCHAR(255),
                                  phone_number    VARCHAR(255),
                                  user_id         INT NOT NULL,
                                  FOREIGN KEY (user_id) REFERENCES aeesuser.user (id)
);

-- Grant all access to user postgres
GRANT ALL PRIVILEGES ON SCHEMA userMS TO postgres;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA userMS TO postgres;
