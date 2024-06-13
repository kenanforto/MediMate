-- truncate all tables
TRUNCATE TABLE medicalRecordMS.admission_record CASCADE;
TRUNCATE TABLE medicalRecordMS.medical_record CASCADE;
TRUNCATE TABLE medicalRecordMS.doctor CASCADE;
TRUNCATE TABLE medicalRecordMS.patient CASCADE;

-- insert into doctor
INSERT INTO medicalRecordMS.doctor (id, first_name, last_name, title) VALUES (1,'John', 'Doe', 'Cardiologist');
INSERT INTO medicalRecordMS.doctor (id, first_name, last_name, title) VALUES (2,'Alice', 'Smith', 'Neurologist');

-- insert into patient
INSERT INTO medicalRecordMS.patient (id, first_name, last_name, birthdate, gender, address, phone_number) VALUES (1, 'Jane', 'Doe', '1990-05-15', 'FEMALE', '123 Main St, City, Country', '+1234567890');
INSERT INTO medicalRecordMS.patient (id, first_name, last_name, birthdate, gender, address, phone_number) VALUES (2, 'Michael', 'Smith', '1985-07-20', 'MALE', '456 Oak St, City, Country', '+1987654321');

-- insert into admission_record
INSERT INTO medicalRecordMS.admission_record (id, admitted_at, urgent, patient_id, doctor_id) VALUES (1, '2023-06-01', true, 1, 1);
INSERT INTO medicalRecordMS.admission_record (id, admitted_at, urgent, patient_id, doctor_id) VALUES (2, '2023-06-15', false, 2, 2);

-- insert into medical_record
INSERT INTO medicalRecordMS.medical_record (description, patient_id, doctor_id, admission_record_id) VALUES ('Patient diagnosed with flu.', 1, 1, 1);
INSERT INTO medicalRecordMS.medical_record (description, patient_id, doctor_id, admission_record_id) VALUES ('Patient underwent surgery.', 2, 2, 2);
