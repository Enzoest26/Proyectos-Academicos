/*
CREATE TABLE tbl_Alumnos
(
id_alum char(6) not null,
nombre_alum varchar(40) not null,
apelli_alum varchar(50) not null,
dni_alum varchar(8) not null,
fechaNa_alum date not null,
id_estado char(1) default '1'
)
DROP TABLE Personal.tbl_Alumnos

CREATE SCHEMA Personal

ALTER TABLE tbl_Alumnos
ADD constraint Pk_IDAlum
primary key (id_alum)


CREATE TABLE tbl_AlumnoEstado(
	id_estado char(1) not null,
    nombre_estado varchar(20) not null
)

ALTER TABLE tbl_AlumnoEstado
ADD CONSTRAINT PK_IDEstado
PRIMARY KEY (id_estado)

INSERT INTO tbl_AlumnoEstado values
('1','Activo'),
('2','Retirado')

ALTER TABLE tbl_Alumnos
ADD CONSTRAINT FK_IDEstado
FOREIGN KEY (id_estado) REFERENCES tbl_AlumnoEstado(id_estado)

TRUNCATE tbl_Alumnos
SELECT * FROM Personal.tbl_Alumnos


CREATE SCHEMA CURSOS;

CREATE TABLE tbl_Cursos
(
	id_curso char(6) not null,
    nombre_curso varchar(50) not null,
    id_prof char(6) not null,
    dias_curso varchar(40) not null,
    hora_curso time not null,
    id_tipo char(6) not null,
    fechaIni_curso date not null,
    fechaFin_curso date not null
);


CREATE TABLE tbl_Profesores
(
	id_prof char(6) not null,
    nombre_prof varchar(60) not null
);

DROP TABLE tbl_Profesores
CREATE TABLE tbl_CursosTipo
(
	id_tipo char(6) not null,
    nombre_tipo varchar(50) not null
);


DROP TABLE CURSOS.tbl_Tipo
INSERT INTO tbl_Profesores VALUES
('PR0001', 'Juan Pablo Estrada Gonzales'),
('PR0002', 'Diego Alan Aquino Estrada'),
('PR0003', 'Enzo Yén Ipanaque Quispe'),
('PR0004', 'Gonzalo Tino Esteban Chupitas')

TRUNCATE tbl_Profesores
INSERT INTO tbl_CursosTipo VALUES
('TC0001','Estudios Generales'),
('TC0002','Estudios de Carrera'),
('TC0003','Estudios de Extensión')


DESCRIBE Personal.tbl_Alumnos;

TRUNCATE Personal.tbl_Alumnos
INSERT INTO tbl_Alumnos VALUES 
('AL0001','José Manuel','Antón Lumbreras','79654135','1992-05-12',default),
('AL0002','María Carmen','Diego Torrents','78253645','2001-12-12',default),
('AL0003','María Belén','Arce Jiménez','96547812','2003-01-01','2'),
('AL0004','Isidro Hilario','Suárez Hidalgo','03564879','1995-10-20',default),
('AL0005','Ana Sofía','Castañeda Macias','12894756','2003-02-21','2')
DROP table CURSOS.tbl_General
*/
DESCRIBE CURSOS.tbl_General;
INSERT INTO tbl_Cursos VALUES
('CU0001', 'Desarrollo de Habilidades 2', 'PR0001', 'Martes, Jueves', '15:30:00','TC0001','2022-03-27','2022-06-28'),
('CU0002', 'Matematica Administrativa', 'PR0001', 'Martes, Jueves', '15:30:00','TC0002','2022-03-27','2022-06-28'),
('CU0003', 'Lenguaje de Programación', 'PR0003', 'Lunes', '08:30:00','TC0001','2022-03-27','2022-06-28'),
('CU0004', 'Programación Orientada a Objetos', 'PR0002', 'Miercoles', '08:30:00','TC0001','2022-03-27','2022-06-28');

describe tbl_Cursos;
truncate tbl_Cursos

ALTER TABLE tbl_Cursos
ADD CONSTRAINT PK_IDCurso
PRIMARY KEY (id_curso)

ALTER TABLE tbl_Cursos
ADD CONSTRAINT FK_IDTipoCurso
FOREIGN KEY (id_tipo) REFERENCES tbl_CursosTipo(id_tipo)

TRUNCATE tbl_CursosTipo
ALTER TABLE tbl_CursosTipo
ADD CONSTRAINT PK_IDTipoCurso
PRIMARY KEY (id_tipo)

ALTER TABLE tbl_Profesores
ADD CONSTRAINT PK_IDProfesores
PRIMARY KEY (id_prof)

ALTER TABLE tbl_Cursos
ADD CONSTRAINT FK_IDProfesor
FOREIGN KEY (id_prof) REFERENCES tbl_Profesores(id_prof)






