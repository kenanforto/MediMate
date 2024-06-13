-- Truncate all tables
TRUNCATE TABLE userMS.user CASCADE;
TRUNCATE TABLE userMS.admin CASCADE;
TRUNCATE TABLE userMS.doctor CASCADE;
TRUNCATE TABLE userMS.patient CASCADE;

-- Insert data into user table
INSERT INTO userMS.user (id, first_name, last_name, password, email, role_id) VALUES
(1, 'Kenan', 'Forto', 'Sifra0001', 'kforto1@etf.unsa.ba', 'ADMIN'),
(2, 'Esma', 'Dervisevic', 'Sifra0002', 'edervisevic1@etf.unsa.ba', 'ADMIN'),
(3, 'Nejla', 'Sabotic', 'Sifra0003', 'nsabotic1@etf.unsa.ba', 'DOCTOR'),
(4, 'Taylor', 'Swift', 'Sifra0004', 'tswift1@etf.unsa.ba', 'PATIENT'),
(5, 'Sophia','Martinez','password', 'sophia.martinez@example.com', 'PATIENT'),
(6, 'Bagi', 'Sabotic', 'Sifra000323', 'bagi1@etf.unsa.ba', 'DOCTOR');

-- Insert data into admin table
INSERT INTO userMS.admin (id, user_id) VALUES (1, 1), (2, 2);

-- Insert data into doctor table
INSERT INTO userMS.doctor (id, title, user_id) VALUES (1, 'Pulmolog', 3), (2, 'Psihijatar', 6);

-- Insert data into patient table
INSERT INTO userMS.patient (id, birthdate, gender, address, phone_number, user_id) VALUES
    (1, '2000-01-01', 'Female', 'Sample Address', '123456789', 4),
    (2, '2000-01-01', 'Female', 'Sample Address 2', '1123456789', 5);
