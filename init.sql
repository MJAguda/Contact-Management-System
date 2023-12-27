CREATE TABLE IF NOT EXISTS contact (
    ID INT PRIMARY KEY,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    ADDRESS VARCHAR(100),
    EMAIL VARCHAR(100),
    CONTACT_NUMBER VARCHAR(15)
);

INSERT INTO contact (ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, CONTACT_NUMBER)
VALUES (10001, 'Juan', 'Dela Cruz', '123 Main St', 'juan.delacruz@example.com', '+639123456789'),
       (10002, 'Maria', 'Santos', '456 Elm St', 'maria.santos@example.com', '+639987654321'),
       (10003, 'Michael', 'Gonzales', '789 Oak St', 'michael.gonzales@example.com', '+639555555555'),
       (10004, 'Sarah', 'Garcia', '321 Pine St', 'sarah.garcia@example.com', '+639111111111'),
       (10005, 'David', 'Tan', '654 Maple St', 'david.tan@example.com', '+639222222222'),
       (10006, 'Jose', 'Reyes', '654 Maple St', 'jose.reyes@example.com', '+639222222222'),
       (10007, 'Pedro', 'Lopez', '654 Maple St', 'pedro.lopez@example.com', '+639222222222'),
       (10008, 'Emily', 'Santos', '789 Oak St', 'emily.santos@example.com', '+639333333333'),
       (10009, 'Daniel', 'Gonzales', '456 Elm St', 'daniel.gonzales@example.com', '+639444444444'),
       (10010, 'Olivia', 'Garcia', '321 Pine St', 'olivia.garcia@example.com', '+639666666666');
