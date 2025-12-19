CREATE DATABASE IF NOT EXISTS jurnal14;
USE jurnal14;


CREATE TABLE IF NOT EXISTS Student (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Nim INT,
    Class VARCHAR(50)
);

INSERT INTO Student (Name, Nim, Class) VALUES
('Florensius Hutagalung', 103032330113, 'IT-47-05');


SELECT * FROM Student;
