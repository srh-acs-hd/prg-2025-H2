
--- examples are based on lastName: USE normally the id field for update and delete operations


INSERT INTO uni.student (firstName, lastName, age)
VALUES ('Student', 'SRH', 21);

SELECT * FROM uni.student;


UPDATE uni.student
SET age = 22
WHERE lastName = 'SRH';

SELECT firstName, lastName, age
FROM uni.student
WHERE lastName = 'SRH';

DELETE FROM uni.student
WHERE lastName = 'SRH';