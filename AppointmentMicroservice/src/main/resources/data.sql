-- truncate all tables
TRUNCATE TABLE appointmentMS.appointment CASCADE;

-- insert into appointment
INSERT INTO appointmentMS.appointment (appointment_datetime, patient_id, doctor_id) VALUES ('2023-06-01 09:00:00', 1, 1);
INSERT INTO appointmentMS.appointment (appointment_datetime, patient_id, doctor_id) VALUES ('2023-06-15 10:30:00', 2, 2);
