-- truncate all tables
TRUNCATE TABLE workingHoursMS.track_working_hours CASCADE;
TRUNCATE TABLE workingHoursMS.working_hours CASCADE;

-- insert into track_working_hours
INSERT INTO workingHoursMS.track_working_hours (id, total_hours, break_hours, admin_id) VALUES (1, 8, 1, 1);
INSERT INTO workingHoursMS.track_working_hours (id, total_hours, break_hours, admin_id) VALUES (2, 8, 1, 2);

-- insert into working_hours
INSERT INTO workingHoursMS.working_hours (start_time, end_time, title, doctor_id, track_working_hours_id) VALUES ('09:00:00', '17:00:00', 'Regular Shift', 1, 1);
INSERT INTO workingHoursMS.working_hours (start_time, end_time, title, doctor_id, track_working_hours_id) VALUES ('09:00:00', '17:00:00', 'Regular Shift', 2, 2);