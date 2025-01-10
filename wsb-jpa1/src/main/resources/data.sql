INSERT INTO doctor (doctor_number, email, first_name, last_name, specialization, telephone_number) VALUES
('D01', 'h.montana@example.com', 'Hannah', 'Montana', 'DERMATOLOGIST', '090454738'),
('D02', 'b.spears@example.com', 'Britney', 'Spears', 'OCULIST', '789465789'),
('D03', 'j.bieber@example.com', 'Justin', 'Bieber', 'SURGEON', '654562846'),
('D04', 'xxxx@example.com', 'Hannah', 'Montana', 'DERMATOLOGIST', '456123412'),
('D05', 'yyyyy@example.com', 'Hannah', 'Montana', 'OCULIST', '785412452'),
('D06', 'zzzzz@example.com', 'Hannah', 'Montana', 'SURGEON', '762412852');

INSERT INTO patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number, has_been_vaccinated) VALUES
('1928-11-18', 'mickeyy2@example.com', 'Mickey', 'Mouse', 'P01', '989652454', 1),
('2018-07-31', 'harryy22@example.com', 'Harry', 'Potter', 'P02', '751954356', 0),
('1969-09-13', 'doobydoo@example.com', 'Scooby', 'Doo', 'P03', '333125469', 1);

INSERT INTO address (address_line1, address_line2, city, postal_code, doctor_id, patient_id) VALUES
('Legnicka 19', 'm2', 'Wroclove', '35-200', 1, 1),
('Strzegomska 44', 'm17', 'Warszawa', '47-600', 2, 2);

INSERT INTO visit (description, time, doctor_id, patient_id) VALUES
('Wizyta u neurologa', '2024-12-08 14:00:00', 1, 1),
('Wizyta u pediatry', '2024-12-08 15:00:00', 2, 2),
('Kontrola u diabetologa', '2024-12-08 16:00:00', 3, 3),
('Wizyta u neurologa', '2024-12-08 14:00:00', 4, 1),
('Wizyta u pediatry', '2024-12-08 15:00:00', 5, 2),
('Kontrola u diabetologa', '2024-12-08 16:00:00', 6, 3);

insert into medical_treatment (description, type, visit_id) values
('Rehabilitacja pourazowa', 'USG', 1),
('Antybiotykoterapia', 'RTG', 2),
('Badanie poziomu cukru we krwi', 'EKG', 3);

