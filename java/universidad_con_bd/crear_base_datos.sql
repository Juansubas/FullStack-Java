
--CREAR TABLA UNIVERSIDAD


CREATE TABLE Universidades(
	nit VARCHAR(20) PRIMARY KEY NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	email VARCHAR(120) NOT NULL
);

--CREAR TABLA TelefonosUniversidad
CREATE TABLE TelefonosUniversidad(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	numero_telefono VARCHAR(15) NOT NULL,
	universidad_nit VARCHAR(20) NOT NULL,
	FOREIGN KEY(universidad_nit) REFERENCES 
		Universidades(nit)
);


--CREAR TABLA Facultades
CREATE TABLE Facultades(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	universidad_nit VARCHAR(20) NOT NULL,
	FOREIGN KEY(universidad_nit) 
		REFERENCES Universidades(nit)
);


--CREAR TABLA Estudiantes
CREATE TABLE Estudiantes(
	cedula VARCHAR(15) PRIMARY KEY NOT NULL,
	codigo VARCHAR(10) NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	apellido VARCHAR(60) NOT NULL, 
	edad INTEGER NOT NULL, 
	sexo CHAR NOT NULL,
	facultad_id INTEGER NOT NULL,
	FOREIGN KEY(facultad_id) 
		REFERENCES Facultades(id)
);


--CREAR TABLA TelefonosEstudiante
CREATE TABLE TelefonosEstudiante(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	numero_telefono VARCHAR(15) NOT NULL,
	estudiante_cedula VARCHAR(15) NOT NULL,
	FOREIGN KEY(estudiante_cedula) 
		REFERENCES Estudiantes(cedula)
);











