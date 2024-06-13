-- Empl Table creation
CREATE TABLE Empl (
    empno INT PRIMARY KEY,
    ename VARCHAR(50),
    job VARCHAR(50),
    mgr INT,
    hiredate DATE,
    sal DECIMAL(10, 2),
    comm DECIMAL(10, 2),
    deptno INT
);
-- Insert data into the Empl table
INSERT INTO Empl (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES
(8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 800.00, NULL, 20),
(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, NULL, 30),
(8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30),
(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 20),
(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30),
(8698, 'ΒΙΝΑ', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 30),
(8882, 'SHIVANSH', 'MANAGER', 8839, '1991-06-09', 2450.00, NULL, 10),
(8888, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20),
(8839, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10),
(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30);

-- To view the Table
SELECT * FROM Empl;

-- A. To display EName and Sal of employees whose salary is greater than or equal to 2200:
SELECT EName, Sal
FROM Empl
WHERE Sal >= 2200;

-- B. To display details of employees who are not receiving commission
SELECT * FROM Empl WHERE comm IS NULL;

-- C. To display employee name and salary of those employees whose salary is not in the range of 2500 to 4000:
SELECT ename,sal FROM Empl WHERE sal not between 2500 and 4000;

-- D. To display the name, job title, and salary of employees who don't have a manager:
SELECT ename,job,sal FROM Empl WHERE mgr IS NULL;

-- E. To display the name of an employee whose name contains "A" as the third alphabet:
SELECT ename FROM Empl WHERE ename LIKE '__A%';

-- F. To display the name of an employee whose name contains "T" as the last alphabet:
SELECT ename FROM Empl WHERE ename LIKE '%T';

UPDATE Empl  SET comm=300.00 WHERE empno=8499;


