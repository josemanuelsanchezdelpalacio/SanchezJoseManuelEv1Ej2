/* ConstructoraH */
DROP DATABASE IF EXISTS constructoraH;
CREATE DATABASE constructoraH;
USE constructoraH;

/* Obras ejecutadas */
CREATE TABLE obra (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    direccion VARCHAR(50) NOT NULL,
    entrega DATE,
    PRIMARY KEY (id)
);

/* Empleados de la constructora */
CREATE TABLE empleado (
    id INT NOT NULL AUTO_INCREMENT,
    id_obra INT NOT NULL,
    dni VARCHAR(9) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    sueldo FLOAT,
    PRIMARY KEY (id),
    CONSTRAINT fk_obraEmp FOREIGN KEY (id_obra) REFERENCES obra(id)
);

/* Maquinaria de la empresa para realizar las obras */
CREATE TABLE maquinaria (
    id INT NOT NULL AUTO_INCREMENT,
    id_empleado INT NOT NULL,
	 id_obra INT NOT NULL,
    matricula VARCHAR(7) NOT NULL UNIQUE,
    modelo VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_empleado FOREIGN KEY (id_empleado) REFERENCES empleado(id),
    CONSTRAINT fk_obraMaq FOREIGN KEY (id_obra) REFERENCES obra(id)
);

INSERT INTO obra (nombre,direccion,entrega) VALUES ('URBANIZACIÓN BUENAVISTA','C/MAYOR 3', '2023/03/02');
INSERT INTO obra (nombre,direccion,entrega) VALUES ('RESIDENCIAL MIRAFLORES','C/MENOR 2', '2025/05/02');
INSERT INTO obra (nombre,direccion,entrega) VALUES ('BAR EL PEDREGAL','C/OSA 12', '2024/05/02');
INSERT INTO obra (nombre,direccion,entrega) VALUES ('POLIDEPORTIVO MUNICIPAL','C/FRONTÓN 25', '2024/10/20');


INSERT INTO empleado (id_obra,dni,nombre,sueldo) VALUES (1,'17123456A', 'PEDRO PICAPIEDRA', 3000.0);
INSERT INTO empleado (id_obra,dni,nombre,sueldo) VALUES (2,'19123456B', 'PABLO MARMOL', 2000.0);

INSERT INTO maquinaria (id_empleado,id_obra,matricula,modelo) VALUES (1,1,'1234BCD', 'EXCAVADORA 2000');
INSERT INTO maquinaria (id_empleado,id_obra,matricula,modelo) VALUES (2,2,'4567XYZ', 'MANITOU 3000');