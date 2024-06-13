-- Employee Table Creation
CREATE TABLE Employee (
    empcode INT PRIMARY KEY,
    empname VARCHAR(50),
    empage INT,
    empsalary DECIMAL(10, 2)
);

-- To view the values in table
SELECT * FROM Employee;