SELECT * FROM employees;

--Punto #1
SELECT last_name, salary FROM employees WHERE salary > 12000;

--Punto #2
SELECT last_name, department_id  FROM employees WHERE employee_id =176;

--Punto #3

SELECT last_name, salary FROM employees 
WHERE salary not BETWEEN 5000 and 12000;

SELECT last_name, salary  FROM employees 
WHERE salary < 5000 OR salary >12000;

--Punto #4
SELECT last_name, job_id, hire_date 
FROM employees
WHERE last_name = "Chen" OR last_name = "Taylor" 
ORDER BY hire_date ASC;

--Punto #5
SELECT last_name, department_id 
FROM employees 
WHERE department_id=2 OR department_id=5 
ORDER BY first_name ASC;

SELECT last_name, department_id
FROM employees
WHERE department_id=6 OR department_id=10;
ORDER BY first_name ASC;


--Punto #6
SELECT last_name AS Employees, salary AS Monthly_Salary 
FROM employees 
WHERE salary >= 5000 AND salary <=12000 
AND (department_id = 20 OR department_id =50);

SELECT last_name AS Employee, salary AS Monthly_Salary 
FROM employees 
WHERE ((salary >= 5000 AND salary <=12000) 
AND (department_id=2 OR department_id=5));

SELECT last_name Employee, salary Monthly_Salary 
FROM employees WHERE salary 
BETWEEN 5000 AND 12000 
AND (department_id =2 OR department_id =5);

SELECT last_name Employee,salary AS Mounthly_Salary 
FROM employees
WHERE salary BETWEEN 5000 AND 12000 
AND (department_id=6 OR department_id=10);

--Punto #7
SELECT last_name,hire_date
FROM employees 
WHERE  hire_date LIKE '%1994%';

SELECT last_name,hire_date 
FROM employees 
WHERE hire_date LIKE '1994%';

--Punto #8
SELECT e.last_name, j.job_title
FROM employees e 
INNER JOIN jobs j ON e.job_id = j.job_id 
WHERE manager_id IS NULL;

--Punto #9
/*Obtener:
 * apellido, salario y nombre del departamento de todas las 
 * personas que tengan un salario entre 4000 y 8000,
 * ordenar los registros de forma descendente 
 * teniendo como referencia la columna salario
 */
SELECT e.last_name, e.salary, d.department_name 
FROM employees e 
INNER JOIN departments d ON e.department_id = d.department_id  
WHERE e.salary 
BETWEEN 4000 AND 8000 ORDER BY e.salary DESC;

SELECT e.last_name, e.salary, d.department_name 
FROM employees e 
INNER JOIN departments d ON e.department_id = d.department_id 
WHERE (salary >= 4000 AND salary <=8000) 
ORDER BY e.salary DESC;

--
/*
 * Obtener toda la información de los empleados con las siguientes columnas:
 * *Nombre
 * *Apellido
 * *Nombre del cargo (job_title)
 * *Nombre del departamento al que pertenece
 * *Ciudad en la que se encuentra el departamento
 * *Estado o provincia de la ciudad 
 * *País
 * *Región
 * */

SELECT e.first_name, e.last_name, d.department_name,
		l.city, l.state_province
FROM employees e 
INNER JOIN departments d ON d.department_id = e.department_id 
INNER JOIN locations l ON l.location_id = d.location_id;

SELECT e.first_name, e.last_name, j.job_title, d.department_name, 
	l.city, l.state_province, c.country_name, r.region_name  
FROM employees e 
INNER JOIN jobs j ON j.job_id = e.job_id 
INNER JOIN departments d ON e.department_id = d.department_id 
INNER JOIN locations l ON l.location_id = d.location_id 
INNER JOIN countries c ON c.country_id = l.country_id 
INNER JOIN regions r ON r.region_id = c.region_id;




--Ordenar consulta

--Orda datos de mayor a menor
SELECT employee_id, last_name, salary  
FROM employees 
ORDER BY salary DESC;

--Ordena datos de menor a mayor
SELECT employee_id AS id, last_name apellido, salary salario  
FROM employees 
ORDER BY salary ASC;

SELECT COUNT(*) cant_empleado FROM employees;


--Traer datos en común (usando like)

--Obtener todos los empleados que su nombre empiecen por D
SELECT first_name FROM employees
WHERE first_name LIKE 'D%';

--Obtener todos los empleados que su nombre termine en D
SELECT first_name FROM employees
WHERE first_name LIKE '%D';


----Obtener todos los empleados que su nombre tenga la letra D
SELECT first_name FROM employees
WHERE first_name LIKE '%D%';

--Comparar con valores nulos

--Obtener todos los registros que no tengan NULL en el campo 'telefono'
SELECT last_name, phone_number FROM employees 
WHERE phone_number IS NOT NULL;

--Obtener todos los registros que tengan NULL en el campo 'telefono'
SELECT last_name, phone_number FROM employees 
WHERE phone_number IS NULL;

select * from jobs;

SELECT * FROM locations;

SELECT * FROM countries;

SELECT l.city, l.state_province, c.country_name 
FROM locations l 
LEFT JOIN countries c ON l.country_id = c.country_id 
WHERE l.country_id = 'US';

--OBTENER TODOS LOS REGISTROS DE LAS DOS TABLAS
/*
SELECT l.city, l.state_province, c.country_name 
FROM locations l 
FULL OUTER JOIN countries c ON l.country_id = c.country_id;
*/
