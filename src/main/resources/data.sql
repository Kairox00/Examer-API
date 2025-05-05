DELETE FROM choice;
DELETE FROM question;
DELETE FROM exam_attempt;
DELETE FROM exam;
DELETE FROM student;

INSERT INTO student (id, name) VALUES
  ('b86458b1-53fc-41fc-9acb-84f6710d12d9', 'Khaled Romeh');

INSERT INTO exam (id, name, duration) VALUES
  ('2106968c-7407-4515-8bb0-16060955905c', 'Test Exam', 3600);

INSERT INTO exam_attempt (student_id, exam_id, score) VALUES
  ('b86458b1-53fc-41fc-9acb-84f6710d12d9', '2106968c-7407-4515-8bb0-16060955905c', 0); 

INSERT INTO question (id, score, text, exam_id) VALUES 
('11111111-aaaa-aaaa-aaaa-111111111111', 5, 'What is the capital of France?', '2106968c-7407-4515-8bb0-16060955905c'),
('22222222-bbbb-bbbb-bbbb-222222222222', 10, 'Explain the process of photosynthesis.', '2106968c-7407-4515-8bb0-16060955905c'),
('33333333-cccc-cccc-cccc-333333333333', 3, 'What is 7 multiplied by 6?', '2106968c-7407-4515-8bb0-16060955905c'),
('44444444-dddd-dddd-dddd-444444444444', 4, 'Define the term "ecosystem".', '2106968c-7407-4515-8bb0-16060955905c'),
('55555555-eeee-eeee-eeee-555555555555', 6, 'Who wrote "1984"?', '2106968c-7407-4515-8bb0-16060955905c'),
('66666666-ffff-ffff-ffff-666666666666', 7, 'Solve the equation: 2x + 3 = 11', '2106968c-7407-4515-8bb0-16060955905c'),
('77777777-aaaa-aaaa-aaaa-777777777777', 5, 'Name the largest planet in our solar system.', '2106968c-7407-4515-8bb0-16060955905c'),
('88888888-bbbb-bbbb-bbbb-888888888888', 8, 'Describe Newton’s First Law of Motion.', '2106968c-7407-4515-8bb0-16060955905c'),
('99999999-cccc-cccc-cccc-999999999999', 9, 'Translate "carpe diem" to English.', '2106968c-7407-4515-8bb0-16060955905c'),
('aaaaaaaa-dddd-dddd-dddd-aaaaaaaaaaaa', 2, 'What is the boiling point of water in Celsius?', '2106968c-7407-4515-8bb0-16060955905c');

-- Choices for question 1
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c1a11111-aaaa-aaaa-aaaa-111111111111', true,  'Paris',                      '11111111-aaaa-aaaa-aaaa-111111111111'),
  ('c1b11111-aaaa-aaaa-aaaa-111111111111', false, 'Berlin',                     '11111111-aaaa-aaaa-aaaa-111111111111'),
  ('c1c11111-aaaa-aaaa-aaaa-111111111111', false, 'Madrid',                     '11111111-aaaa-aaaa-aaaa-111111111111'),
  ('c1d11111-aaaa-aaaa-aaaa-111111111111', false, 'Rome',                       '11111111-aaaa-aaaa-aaaa-111111111111');

-- Choices for question 2
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c2a22222-bbbb-bbbb-bbbb-222222222222', true,  'Conversion of light to energy in plants', '22222222-bbbb-bbbb-bbbb-222222222222'),
  ('c2b22222-bbbb-bbbb-bbbb-222222222222', false, 'Animal reproduction cycle',               '22222222-bbbb-bbbb-bbbb-222222222222'),
  ('c2c22222-bbbb-bbbb-bbbb-222222222222', false, 'Wind cycle explanation',                  '22222222-bbbb-bbbb-bbbb-222222222222'),
  ('c2d22222-bbbb-bbbb-bbbb-222222222222', false, 'Water boiling',                           '22222222-bbbb-bbbb-bbbb-222222222222');

-- Choices for question 3
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c3a33333-cccc-cccc-cccc-333333333333', true,  '42',      '33333333-cccc-cccc-cccc-333333333333'),
  ('c3b33333-cccc-cccc-cccc-333333333333', false, '36',      '33333333-cccc-cccc-cccc-333333333333'),
  ('c3c33333-cccc-cccc-cccc-333333333333', false, '48',      '33333333-cccc-cccc-cccc-333333333333'),
  ('c3d33333-cccc-cccc-cccc-333333333333', false, '40',      '33333333-cccc-cccc-cccc-333333333333');

-- Choices for question 4
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c4a44444-dddd-dddd-dddd-444444444444', true,  'A community of interacting organisms and their environment', '44444444-dddd-dddd-dddd-444444444444'),
  ('c4b44444-dddd-dddd-dddd-444444444444', false, 'A weather pattern',                                             '44444444-dddd-dddd-dddd-444444444444'),
  ('c4c44444-dddd-dddd-dddd-444444444444', false, 'A food chain',                                                 '44444444-dddd-dddd-dddd-444444444444'),
  ('c4d44444-dddd-dddd-dddd-444444444444', false, 'A plant group',                                                '44444444-dddd-dddd-dddd-444444444444');

-- Choices for question 5
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c5a55555-eeee-eeee-eeee-555555555555', true,  'George Orwell',     '55555555-eeee-eeee-eeee-555555555555'),
  ('c5b55555-eeee-eeee-eeee-555555555555', false, 'Aldous Huxley',     '55555555-eeee-eeee-eeee-555555555555'),
  ('c5c55555-eeee-eeee-eeee-555555555555', false, 'Ray Bradbury',      '55555555-eeee-eeee-eeee-555555555555'),
  ('c5d55555-eeee-eeee-eeee-555555555555', false, 'J.K. Rowling',      '55555555-eeee-eeee-eeee-555555555555');

-- Choices for question 6
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c6a66666-ffff-ffff-ffff-666666666666', true,  'x = 4',      '66666666-ffff-ffff-ffff-666666666666'),
  ('c6b66666-ffff-ffff-ffff-666666666666', false, 'x = 5',      '66666666-ffff-ffff-ffff-666666666666'),
  ('c6c66666-ffff-ffff-ffff-666666666666', false, 'x = 3',      '66666666-ffff-ffff-ffff-666666666666'),
  ('c6d66666-ffff-ffff-ffff-666666666666', false, 'x = 2',      '66666666-ffff-ffff-ffff-666666666666');

-- Choices for question 7
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c7a77777-aaaa-aaaa-aaaa-777777777777', true,  'Jupiter',        '77777777-aaaa-aaaa-aaaa-777777777777'),
  ('c7b77777-aaaa-aaaa-aaaa-777777777777', false, 'Saturn',         '77777777-aaaa-aaaa-aaaa-777777777777'),
  ('c7c77777-aaaa-aaaa-aaaa-777777777777', false, 'Earth',          '77777777-aaaa-aaaa-aaaa-777777777777'),
  ('c7d77777-aaaa-aaaa-aaaa-777777777777', false, 'Neptune',        '77777777-aaaa-aaaa-aaaa-777777777777');

-- Choices for question 8
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c8a88888-bbbb-bbbb-bbbb-888888888888', true,  'An object in motion stays in motion unless acted on by an external force', '88888888-bbbb-bbbb-bbbb-888888888888'),
  ('c8b88888-bbbb-bbbb-bbbb-888888888888', false, 'Force equals mass times acceleration',                                      '88888888-bbbb-bbbb-bbbb-888888888888'),
  ('c8c88888-bbbb-bbbb-bbbb-888888888888', false, 'Every action has an equal and opposite reaction',                          '88888888-bbbb-bbbb-bbbb-888888888888'),
  ('c8d88888-bbbb-bbbb-bbbb-888888888888', false, 'Gravity pulls objects toward Earth',                                       '88888888-bbbb-bbbb-bbbb-888888888888');

-- Choices for question 9
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c9a99999-cccc-cccc-cccc-999999999999', true,  'Seize the day',      '99999999-cccc-cccc-cccc-999999999999'),
  ('c9b99999-cccc-cccc-cccc-999999999999', false, 'Live for tomorrow',  '99999999-cccc-cccc-cccc-999999999999'),
  ('c9c99999-cccc-cccc-cccc-999999999999', false, 'Stay calm',          '99999999-cccc-cccc-cccc-999999999999'),
  ('c9d99999-cccc-cccc-cccc-999999999999', false, 'Dream big',          '99999999-cccc-cccc-cccc-999999999999');

-- Choices for question 10
INSERT INTO choice (id, is_correct, text, question_id) VALUES
  ('c0a00000-dddd-dddd-dddd-aaaaaaaaaaaa', true,  '100°C',            'aaaaaaaa-dddd-dddd-dddd-aaaaaaaaaaaa'),
  ('c0b00000-dddd-dddd-dddd-aaaaaaaaaaaa', false, '0°C',              'aaaaaaaa-dddd-dddd-dddd-aaaaaaaaaaaa'),
  ('c0c00000-dddd-dddd-dddd-aaaaaaaaaaaa', false, '50°C',             'aaaaaaaa-dddd-dddd-dddd-aaaaaaaaaaaa'),
  ('c0d00000-dddd-dddd-dddd-aaaaaaaaaaaa', false, '212°C',            'aaaaaaaa-dddd-dddd-dddd-aaaaaaaaaaaa');
