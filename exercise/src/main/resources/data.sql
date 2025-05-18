DELETE FROM students;
DELETE FROM books;
DELETE FROM locations;
DELETE FROM authors;

INSERT INTO students (first_name, last_name, carnet, email) VALUES ('Jose', 'Jacobo', '00243522', '00243522@uca.edu.sv');
INSERT INTO students (first_name, last_name,  carnet, email) VALUES ('Paola', 'Perez', '00117222', '00117222@uca.edu.sv');
INSERT INTO students (first_name, last_name,  carnet, email) VALUES ('Jose', 'Ramírez', '00989821', '00989821@uca.edu.sv');
INSERT INTO students (first_name, last_name, carnet, email) VALUES ('Luis', 'Hernández', '00678901', '00678921@uca.edu.sv');
INSERT INTO students (first_name, last_name, carnet, email) VALUES ('Sofía', 'Castro', '00789012', '00789012@uca.edu.sv');
INSERT INTO students (first_name, last_name, carnet, email) VALUES ('Luis', 'Méndez', '00890123', '00890123@uca.edu.sv');
INSERT INTO students (first_name, last_name, carnet, email) VALUES ('Andrea', 'Perez', '00901234', '00901214@uca.edu.sv');

-- Insertar autores
INSERT INTO authors (first_name, last_name) VALUES ('Stephen', 'King');
INSERT INTO authors (first_name, last_name) VALUES ('Gabriel', 'García Márquez');
INSERT INTO authors (first_name, last_name) VALUES ('J.K.', 'Rowling');

-- Insertar ubicaciones
INSERT INTO locations (floor, shelf, level) VALUES (1, 2, 1);
INSERT INTO locations (floor, shelf, level) VALUES (2, 3,2);
INSERT INTO locations (floor, shelf, level) VALUES (3, 1, 3);
INSERT INTO locations (floor, shelf, level) VALUES (4, 4, 4);

-- Insertar libros
INSERT INTO books (title, author_id, location_id) VALUES ('IT', 1, 1);
INSERT INTO books (title, author_id, location_id) VALUES ('Cien Años de Soledad', 2, 2);
INSERT INTO books (title, author_id, location_id) VALUES ('Harry Potter y la Piedra Filosofal', 3, 3);
INSERT INTO books (title, author_id, location_id) VALUES ('Carrie', 1, 4);

INSERT INTO loans (student_id, book_id, loan_date, return_date)
VALUES (1, 1, '2024-05-01', '2024-05-15');

INSERT INTO loans (student_id, book_id, loan_date, return_date)
VALUES (2, 3, '2024-05-10', '2024-05-24');

INSERT INTO loans (student_id, book_id, loan_date, return_date)
VALUES (3, 2, '2024-05-12', '2024-05-26');