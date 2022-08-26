/*
 * Esto es un comentario de
 * varias lineas
 */

--Comentario de una linea


--Crear mi primera BD
CREATE TABLE grupo_24(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	jornada VARCHAR(10) NOT NULL,
	promedio_edad DOUBLE NOT NULL,
	universidad VARCHAR(50) NOT NULL
);

--Insertar datos
INSERT INTO grupo_24(jornada, promedio_edad, universidad) 
VALUES("Noche", 29.5, "UTP");

INSERT INTO grupo_24 (jornada, promedio_edad, universidad)
VALUES("Tarde", 28.2, "UTP");

INSERT INTO grupo_24(jornada, promedio_edad, universidad) 
VALUES("Mañana", 20.5, "UTP");

--Consultar datos de la tabla
SELECT * FROM grupo_24;

SELECT promedio_edad, jornada FROM grupo_24;

SELECT COUNT(*) FROM grupo_24;

--ACTUALIZAR UN REGISTRO
--Actualiza todos ls registros
UPDATE grupo_24 SET universidad="UPB";

--Actualizar un registro en específico
UPDATE grupo_24 SET universidad="UTP" WHERE id=1;

--Actualizar varios registros
UPDATE grupo_24 SET universidad="UDEA" WHERE id=2 OR id=3;

--ELIMINAR UN REGISTRO
DELETE FROM grupo_24 WHERE id=2;


--Eliminar una tabla
DROP TABLE grupo_24;