-- truncate all tables
TRUNCATE TABLE suppliesMS.supplies CASCADE;

-- insert into supplies
INSERT INTO suppliesMS.supplies (medication_name, amount, admin_id) VALUES ('Paracetamol', 100, 1);
INSERT INTO suppliesMS.supplies (medication_name, amount, admin_id) VALUES ('Aspirin', 200, 2);
INSERT INTO suppliesMS.supplies (medication_name, amount, admin_id) VALUES ('Ibuprofen', 150, 1);
