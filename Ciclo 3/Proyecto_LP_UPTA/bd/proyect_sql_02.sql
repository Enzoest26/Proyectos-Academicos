CREATE DATABASE  IF NOT EXISTS `proyecto_lp_02` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyecto_lp_02`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_lp_02
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_alumnoestado`
--

DROP TABLE IF EXISTS `tbl_alumnoestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_alumnoestado` (
  `id_estado` char(1) NOT NULL,
  `nombre_estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_alumnoestado`
--

LOCK TABLES `tbl_alumnoestado` WRITE;
/*!40000 ALTER TABLE `tbl_alumnoestado` DISABLE KEYS */;
INSERT INTO `tbl_alumnoestado` VALUES ('1','Activo'),('2','Retirado');
/*!40000 ALTER TABLE `tbl_alumnoestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_alumnos`
--

DROP TABLE IF EXISTS `tbl_alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_alumnos` (
  `id_alum` char(6) NOT NULL,
  `nombre_alum` varchar(40) NOT NULL,
  `apelli_alum` varchar(50) NOT NULL,
  `dni_alum` varchar(8) NOT NULL,
  `fechaNa_alum` date NOT NULL,
  `edad_alum` int NOT NULL DEFAULT '18',
  `id_estado` char(1) NOT NULL DEFAULT '1',
  `teleMo_alum` varchar(9) NOT NULL,
  `teleFi_alum` varchar(7) NOT NULL,
  `domici_alum` varchar(50) NOT NULL,
  `id_distrito` char(6) NOT NULL,
  `correo_alum` varchar(45) DEFAULT NULL,
  `sexo_alum` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_alum`),
  KEY `FK_IDEstado` (`id_estado`),
  KEY `FK_AlumIDDistrito` (`id_distrito`),
  CONSTRAINT `FK_AlumIDDistrito` FOREIGN KEY (`id_distrito`) REFERENCES `tbl_distrito` (`id_distrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_alumnos`
--

LOCK TABLES `tbl_alumnos` WRITE;
/*!40000 ALTER TABLE `tbl_alumnos` DISABLE KEYS */;
INSERT INTO `tbl_alumnos` VALUES ('AL0001','JosÃ© Manuel','AntÃ³n Lumbreras','79654135','1992-05-12',18,'1','993558224','2654782','401 - Las Rocas','DIS001',NULL,NULL),('AL0002','MarÃ­a Carmen','Diego Torrents','78253645','2001-12-12',18,'2','968574123','6541237','501 - LAs Palmeras','DIS002',NULL,NULL),('AL0003','MarÃ­a BelÃ©n','Arce JimÃ©nez','96547812','2003-01-01',18,'2','987456321','4567812','201 - Las Runas','DIS004',NULL,NULL),('AL0004','Isidro Hilario','SuÃ¡rez Hidalgo','03564879','1995-10-20',18,'1','968523147','1234567','503 - Las Flores','DIS001',NULL,NULL),('AL0005','Ana SofÃ­a','CastaÃ±eda Macias','12894756','2003-02-21',18,'2','987456321','2645786','201 - Las Orquideas','DIS002',NULL,NULL),('AL0006','Diego Estrada','Quispe Huamani','78654123','2022-06-22',18,'1','916432578','8453212','203 - San Juancinto','DIS003',NULL,NULL),('AL0010','Diego Estrada','Alvarez Gonzalez','78654123','2022-06-01',18,'1','987654321','2654137','Las Huacas - 550','DIS002','estradita456@hotmail.com','Masculino'),('AL0011','Eduardo Martines','Estrada Joaquin','65983214','2022-05-05',15,'1','987654321','2563147','Las Huecas - 150','DIS005','eudarcito156@hotmail.com','Femenino');
/*!40000 ALTER TABLE `tbl_alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cabe_boletas`
--

DROP TABLE IF EXISTS `tbl_cabe_boletas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cabe_boletas` (
  `id_boleta` char(6) NOT NULL,
  `fecha_boleta` date NOT NULL,
  `id_alum` char(6) NOT NULL,
  `id_emple` char(6) NOT NULL,
  `precioTo_boleta` double NOT NULL,
  `id_tipobol` char(6) DEFAULT 'BTI001',
  PRIMARY KEY (`id_boleta`),
  KEY `FK_alumno_idx` (`id_alum`),
  KEY `FK_empleado_idx` (`id_emple`),
  KEY `FK_CaIDTipoBol_idx` (`id_tipobol`),
  CONSTRAINT `FK_alumno` FOREIGN KEY (`id_alum`) REFERENCES `tbl_alumnos` (`id_alum`),
  CONSTRAINT `FK_CaIDTipoBol` FOREIGN KEY (`id_tipobol`) REFERENCES `tbl_tipoboleta` (`id_tipobol`),
  CONSTRAINT `FK_empleado` FOREIGN KEY (`id_emple`) REFERENCES `tbl_empleados` (`id_emple`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cabe_boletas`
--

LOCK TABLES `tbl_cabe_boletas` WRITE;
/*!40000 ALTER TABLE `tbl_cabe_boletas` DISABLE KEYS */;
INSERT INTO `tbl_cabe_boletas` VALUES ('B00001','2022-05-15','AL0001','TB0001',120.15,'BTI001'),('B00002','2022-06-07','AL0002','TB0001',450,'BTI001'),('B00003','2022-06-07','AL0001','TB0001',870,'BTI001'),('B00004','2022-06-07','AL0002','TB0001',300,'BTI001'),('B00005','2022-06-08','AL0005','TB0001',300,'BTI001'),('B00006','2022-06-09','AL0001','TB0001',150,'BTI001'),('B00007','2022-06-14','AL0003','TB0001',300,'BTI001'),('B00008','2022-06-23','AL0006','TB0001',50.8,'BTI002'),('B00009','2022-06-23','AL0003','TB0001',50.8,'BTI002'),('B00010','2022-06-23','AL0004','TB0001',150.5,'BTI003');
/*!40000 ALTER TABLE `tbl_cabe_boletas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_carreras`
--

DROP TABLE IF EXISTS `tbl_carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_carreras` (
  `id_carrera` char(6) NOT NULL,
  `nombre_carrera` varchar(45) DEFAULT NULL,
  `id_facultad` char(6) DEFAULT NULL,
  PRIMARY KEY (`id_carrera`),
  KEY `FK_CarreIDFacultad_idx` (`id_facultad`),
  CONSTRAINT `FK_CarreIDFacultad` FOREIGN KEY (`id_facultad`) REFERENCES `tbl_facultad` (`id_facultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_carreras`
--

LOCK TABLES `tbl_carreras` WRITE;
/*!40000 ALTER TABLE `tbl_carreras` DISABLE KEYS */;
INSERT INTO `tbl_carreras` VALUES ('CAR001','EconomÃ­a','FAC002'),('CAR002','SociologÃ­a','FAC002'),('CAR003','Fisica','FAC003'),('CAR004','Matematica','FAC003'),('CAR005','Veterinaria','FAC004'),('CAR006','Derecho','FAC001');
/*!40000 ALTER TABLE `tbl_carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_conexion_emple`
--

DROP TABLE IF EXISTS `tbl_conexion_emple`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_conexion_emple` (
  `id_emple` char(6) DEFAULT NULL,
  `id_estado` int DEFAULT NULL,
  KEY `FK_IDEstado_idx` (`id_estado`),
  KEY `FK_IDEmple_idx` (`id_emple`),
  CONSTRAINT `FK_IDEmple` FOREIGN KEY (`id_emple`) REFERENCES `tbl_empleados` (`id_emple`),
  CONSTRAINT `FK_IDEstadoConec` FOREIGN KEY (`id_estado`) REFERENCES `tbl_estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_conexion_emple`
--

LOCK TABLES `tbl_conexion_emple` WRITE;
/*!40000 ALTER TABLE `tbl_conexion_emple` DISABLE KEYS */;
INSERT INTO `tbl_conexion_emple` VALUES ('TB0001',1),('TB0002',1);
/*!40000 ALTER TABLE `tbl_conexion_emple` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cuentas`
--

DROP TABLE IF EXISTS `tbl_cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cuentas` (
  `id_cuenta` char(6) NOT NULL,
  `usu_cuenta` varchar(20) DEFAULT NULL,
  `pass_cuenta` varchar(20) DEFAULT NULL,
  `id_emple` char(6) DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cuentas`
--

LOCK TABLES `tbl_cuentas` WRITE;
/*!40000 ALTER TABLE `tbl_cuentas` DISABLE KEYS */;
INSERT INTO `tbl_cuentas` VALUES ('AC0001','dEstrada','Juancito123','TB0001'),('AC0002','dJuan','Lunacita456','TB0002'),('AC0003','dAndrea','Lapicito999','TB0003');
/*!40000 ALTER TABLE `tbl_cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cursos`
--

DROP TABLE IF EXISTS `tbl_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cursos` (
  `id_curso` char(6) NOT NULL,
  `nombre_curso` varchar(50) NOT NULL,
  `id_prof` char(6) NOT NULL,
  `ciclo` varchar(40) DEFAULT NULL,
  `id_carrera` char(6) DEFAULT NULL,
  `dias_curso` varchar(40) NOT NULL,
  `id_tipo` char(6) NOT NULL,
  `fechaIni_curso` date NOT NULL,
  `fechaFin_curso` date NOT NULL,
  `id_horario` char(3) NOT NULL,
  `vacantes_curso` int NOT NULL DEFAULT '15',
  `creditos_curso` int DEFAULT '10',
  PRIMARY KEY (`id_curso`),
  KEY `FK_IDTipoCurso` (`id_tipo`),
  KEY `FK_IDProfesor` (`id_prof`),
  KEY `FK_IDHorario_idx` (`id_horario`),
  KEY `FK_IdCarrera_idx` (`id_carrera`),
  CONSTRAINT `FK_IdCarrera` FOREIGN KEY (`id_carrera`) REFERENCES `tbl_carreras` (`id_carrera`),
  CONSTRAINT `FK_IDHorario` FOREIGN KEY (`id_horario`) REFERENCES `tbl_horario` (`id_horario`),
  CONSTRAINT `FK_IDProfesor` FOREIGN KEY (`id_prof`) REFERENCES `tbl_profesores` (`id_prof`),
  CONSTRAINT `FK_IDTipoCurso` FOREIGN KEY (`id_tipo`) REFERENCES `tbl_cursostipo` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cursos`
--

LOCK TABLES `tbl_cursos` WRITE;
/*!40000 ALTER TABLE `tbl_cursos` DISABLE KEYS */;
INSERT INTO `tbl_cursos` VALUES ('CU0001','Desarrollo de Habilidades 2','PR0001',NULL,NULL,'Jueves','TC0001','2022-03-27','2022-06-28','H01',13,10),('CU0002','Matematica Administrativa','PR0001',NULL,NULL,'Lunes','TC0002','2022-03-27','2022-06-28','H12',12,10),('CU0003','Lenguaje de ProgramaciÃ³n','PR0003',NULL,NULL,'Lunes','TC0001','2022-03-27','2022-06-28','H08',11,10),('CU0004','ProgramaciÃ³n Orientada a Objetos','PR0002',NULL,NULL,'Miercoles','TC0001','2022-03-27','2022-06-28','H10',11,10);
/*!40000 ALTER TABLE `tbl_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_cursostipo`
--

DROP TABLE IF EXISTS `tbl_cursostipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_cursostipo` (
  `id_tipo` char(6) NOT NULL,
  `nombre_tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_cursostipo`
--

LOCK TABLES `tbl_cursostipo` WRITE;
/*!40000 ALTER TABLE `tbl_cursostipo` DISABLE KEYS */;
INSERT INTO `tbl_cursostipo` VALUES ('TC0001','Estudios Generales'),('TC0002','Estudios de Carrera'),('TC0003','Estudios de ExtensiÃ³n');
/*!40000 ALTER TABLE `tbl_cursostipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_detalleboleta`
--

DROP TABLE IF EXISTS `tbl_detalleboleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_detalleboleta` (
  `id_boleta` char(6) NOT NULL,
  `id_curso` char(6) NOT NULL,
  `precio_curso` double NOT NULL DEFAULT '156.12',
  KEY `FK_idBoleta_idx` (`id_boleta`),
  KEY `FK_idCurso_idx` (`id_curso`),
  CONSTRAINT `FK_idBoleta` FOREIGN KEY (`id_boleta`) REFERENCES `tbl_cabe_boletas` (`id_boleta`),
  CONSTRAINT `FK_idCurso` FOREIGN KEY (`id_curso`) REFERENCES `tbl_cursos` (`id_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_detalleboleta`
--

LOCK TABLES `tbl_detalleboleta` WRITE;
/*!40000 ALTER TABLE `tbl_detalleboleta` DISABLE KEYS */;
INSERT INTO `tbl_detalleboleta` VALUES ('B00004','CU0003',150),('B00004','CU0004',150),('B00005','CU0002',150),('B00005','CU0001',150),('B00006','CU0002',150),('B00007','CU0001',150),('B00007','CU0004',150);
/*!40000 ALTER TABLE `tbl_detalleboleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_detalleinforme`
--

DROP TABLE IF EXISTS `tbl_detalleinforme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_detalleinforme` (
  `id_informe` char(6) NOT NULL,
  `fecha_detainfo` date NOT NULL,
  `descrip_detainfo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_detalleinforme`
--

LOCK TABLES `tbl_detalleinforme` WRITE;
/*!40000 ALTER TABLE `tbl_detalleinforme` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_detalleinforme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_distrito`
--

DROP TABLE IF EXISTS `tbl_distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_distrito` (
  `id_distrito` char(6) NOT NULL,
  `nombre_distrito` varchar(45) NOT NULL,
  PRIMARY KEY (`id_distrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_distrito`
--

LOCK TABLES `tbl_distrito` WRITE;
/*!40000 ALTER TABLE `tbl_distrito` DISABLE KEYS */;
INSERT INTO `tbl_distrito` VALUES ('DIS001','San Juan de Miraflores'),('DIS002','San Juan de Lurigancho'),('DIS003','BreÃ±a'),('DIS004','Cercado de Lima'),('DIS005','Villa el Salvador'),('DIS006','La Molina'),('DIS007','San Isisdro');
/*!40000 ALTER TABLE `tbl_distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_empleados`
--

DROP TABLE IF EXISTS `tbl_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_empleados` (
  `id_emple` char(6) NOT NULL,
  `nombre_emple` varchar(45) NOT NULL,
  `apellido_emple` varchar(45) NOT NULL,
  `dni_emple` varchar(8) NOT NULL,
  `id_tipo` char(6) NOT NULL DEFAULT 'TT0001',
  PRIMARY KEY (`id_emple`),
  KEY `FK_TipoEmpleado_idx` (`id_tipo`),
  CONSTRAINT `FK_TipoEmpleado` FOREIGN KEY (`id_tipo`) REFERENCES `tbl_tipo_empleado` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_empleados`
--

LOCK TABLES `tbl_empleados` WRITE;
/*!40000 ALTER TABLE `tbl_empleados` DISABLE KEYS */;
INSERT INTO `tbl_empleados` VALUES ('TB0001','Diego','Estrada','78654123','TT0001'),('TB0002','Juan','Alvaro','89657412','TT0001'),('TB0003','Andrea','Estrada','78451236','TT0002');
/*!40000 ALTER TABLE `tbl_empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_estado`
--

DROP TABLE IF EXISTS `tbl_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `desc_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_estado`
--

LOCK TABLES `tbl_estado` WRITE;
/*!40000 ALTER TABLE `tbl_estado` DISABLE KEYS */;
INSERT INTO `tbl_estado` VALUES (1,'Conectado'),(2,'Desconectado');
/*!40000 ALTER TABLE `tbl_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_facultad`
--

DROP TABLE IF EXISTS `tbl_facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_facultad` (
  `id_facultad` char(6) NOT NULL,
  `descri_facultad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_facultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_facultad`
--

LOCK TABLES `tbl_facultad` WRITE;
/*!40000 ALTER TABLE `tbl_facultad` DISABLE KEYS */;
INSERT INTO `tbl_facultad` VALUES ('FAC001','Derecho'),('FAC002','Ciencia Sociales'),('FAC003','Ciencia e Ingenieria'),('FAC004','Medicina');
/*!40000 ALTER TABLE `tbl_facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_horario`
--

DROP TABLE IF EXISTS `tbl_horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_horario` (
  `id_horario` char(3) NOT NULL,
  `tiempo_horario` time NOT NULL,
  PRIMARY KEY (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_horario`
--

LOCK TABLES `tbl_horario` WRITE;
/*!40000 ALTER TABLE `tbl_horario` DISABLE KEYS */;
INSERT INTO `tbl_horario` VALUES ('H01','07:00:00'),('H02','08:30:00'),('H03','10:00:00'),('H04','11:30:00'),('H05','13:00:00'),('H06','14:30:00'),('H07','14:30:00'),('H08','16:00:00'),('H09','17:30:00'),('H10','19:00:00'),('H11','20:30:00'),('H12','22:00:00');
/*!40000 ALTER TABLE `tbl_horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_informe`
--

DROP TABLE IF EXISTS `tbl_informe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_informe` (
  `id_informe` char(6) NOT NULL,
  `id_tipoinfo` char(6) DEFAULT NULL,
  `id_emple` char(6) DEFAULT NULL,
  `estado_informe` varchar(20) DEFAULT 'NO REVISADO',
  PRIMARY KEY (`id_informe`),
  KEY `FK_INIDEmple_idx` (`id_tipoinfo`),
  KEY `FK_INIDEmple_idx1` (`id_emple`),
  CONSTRAINT `FK_INIDEmple` FOREIGN KEY (`id_emple`) REFERENCES `tbl_empleados` (`id_emple`),
  CONSTRAINT `FK_INIDTipo` FOREIGN KEY (`id_tipoinfo`) REFERENCES `tbl_tipoinforme` (`id_tipoinfo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_informe`
--

LOCK TABLES `tbl_informe` WRITE;
/*!40000 ALTER TABLE `tbl_informe` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_informe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_profesores`
--

DROP TABLE IF EXISTS `tbl_profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_profesores` (
  `id_prof` char(6) NOT NULL,
  `nombre_prof` varchar(60) NOT NULL,
  `apelli_prof` varchar(60) DEFAULT NULL,
  `dni_prof` char(8) DEFAULT NULL,
  `fechaNa_prof` date DEFAULT NULL,
  `edad_prof` int DEFAULT NULL,
  `cel_prof` char(9) DEFAULT NULL,
  `domici_prof` varchar(100) DEFAULT NULL,
  `id_distrito` char(6) DEFAULT NULL,
  `correo_prof` varchar(60) DEFAULT NULL,
  `sexo_prof` varchar(15) DEFAULT NULL,
  `id_sede` char(6) DEFAULT NULL,
  PRIMARY KEY (`id_prof`),
  KEY `id_sede_idx` (`id_sede`),
  KEY `id_distrito_idx` (`id_distrito`),
  CONSTRAINT `id_distrito` FOREIGN KEY (`id_distrito`) REFERENCES `tbl_distrito` (`id_distrito`),
  CONSTRAINT `id_sede` FOREIGN KEY (`id_sede`) REFERENCES `tbl_sede` (`id_sede`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_profesores`
--

LOCK TABLES `tbl_profesores` WRITE;
/*!40000 ALTER TABLE `tbl_profesores` DISABLE KEYS */;
INSERT INTO `tbl_profesores` VALUES ('PR0001','Juan Pablo Estrada Gonzales',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('PR0002','Diego Alan Aquino Estrada',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('PR0003','Enzo YÃ©n Ipanaque Quispe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('PR0004','Gonzalo Tino Esteban Chupitas',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('PR0005','Micheal Krud','Minek Pens','12345678','1980-05-05',32,'123456789','Av los aires #121 Urb Causa Genial ','DIS001','mmm1980@gmail.com','Masculino ','SE0003'),('PR0006','Eudardo Martinez','Estrada Gonzales','98765432','2022-06-03',12,'987654321','emea@gmail.com','DIS001','jasd@gmail.com','Masculino ','SE0002');
/*!40000 ALTER TABLE `tbl_profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sede`
--

DROP TABLE IF EXISTS `tbl_sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_sede` (
  `id_sede` char(6) NOT NULL,
  `nombre_sede` varchar(45) NOT NULL,
  `id_distrito` char(6) NOT NULL,
  PRIMARY KEY (`id_sede`),
  KEY `FK_IDDistrito_idx` (`id_distrito`),
  CONSTRAINT `FK_SedeIDDistrito` FOREIGN KEY (`id_distrito`) REFERENCES `tbl_distrito` (`id_distrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sede`
--

LOCK TABLES `tbl_sede` WRITE;
/*!40000 ALTER TABLE `tbl_sede` DISABLE KEYS */;
INSERT INTO `tbl_sede` VALUES ('SE0001','Sinchi Roca','DIS001'),('SE0002','Central','DIS002'),('SE0003','Cenepa','DIS003'),('SE0004','Cesar Vallejo','DIS005');
/*!40000 ALTER TABLE `tbl_sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_solicitud`
--

DROP TABLE IF EXISTS `tbl_solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_solicitud` (
  `id_solicitud` char(6) NOT NULL,
  `id_tiposoli` char(6) NOT NULL,
  `id_emple` char(6) NOT NULL,
  `fecha_solicitud` date DEFAULT NULL,
  KEY `FK_SolIDEmple_idx` (`id_emple`),
  KEY `FK_SolIDTipoSol_idx` (`id_tiposoli`),
  CONSTRAINT `FK_SolIDEmple` FOREIGN KEY (`id_emple`) REFERENCES `tbl_empleados` (`id_emple`),
  CONSTRAINT `FK_SolIDTipoSol` FOREIGN KEY (`id_tiposoli`) REFERENCES `tbl_tiposolicitud` (`id_tiposoli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_solicitud`
--

LOCK TABLES `tbl_solicitud` WRITE;
/*!40000 ALTER TABLE `tbl_solicitud` DISABLE KEYS */;
INSERT INTO `tbl_solicitud` VALUES ('SOL001','SLT001','TB0001',NULL),('SOL002','SLT001','TB0002',NULL),('SOL003','SLT001','TB0002',NULL),('SOL004','SLT001','TB0001',NULL),('SOL005','SLT002','TB0003',NULL);
/*!40000 ALTER TABLE `tbl_solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_solidetalle`
--

DROP TABLE IF EXISTS `tbl_solidetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_solidetalle` (
  `id_solicitud` char(6) NOT NULL,
  `id_alumno` char(6) NOT NULL,
  `id_sede` char(6) NOT NULL,
  `motivo_solicamse` varchar(200) NOT NULL,
  PRIMARY KEY (`id_solicitud`),
  KEY `FK_SCSIDAlumno_idx` (`id_alumno`),
  KEY `FK_SCSIDSede_idx` (`id_sede`),
  CONSTRAINT `FK_SCSIDAlumno` FOREIGN KEY (`id_alumno`) REFERENCES `tbl_alumnos` (`id_alum`),
  CONSTRAINT `FK_SCSIDSede` FOREIGN KEY (`id_sede`) REFERENCES `tbl_sede` (`id_sede`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_solidetalle`
--

LOCK TABLES `tbl_solidetalle` WRITE;
/*!40000 ALTER TABLE `tbl_solidetalle` DISABLE KEYS */;
INSERT INTO `tbl_solidetalle` VALUES ('SOL001','AL0001','SE0001','TB0001'),('SOL002','AL0010','SE0002','TB0002'),('SOL003','AL0006','SE0002','TB0002'),('SOL004','AL0006','SE0001','Por problemas familiares.\nY por economicos'),('SOL005','AL0010','SE0002','Problemas economicos.\nY Familiares.');
/*!40000 ALTER TABLE `tbl_solidetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipo_empleado`
--

DROP TABLE IF EXISTS `tbl_tipo_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tipo_empleado` (
  `id_tipo` char(6) NOT NULL,
  `descrip_tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipo_empleado`
--

LOCK TABLES `tbl_tipo_empleado` WRITE;
/*!40000 ALTER TABLE `tbl_tipo_empleado` DISABLE KEYS */;
INSERT INTO `tbl_tipo_empleado` VALUES ('TT0001','Asistente'),('TT0002','Administrador'),('TT0003','Gerente');
/*!40000 ALTER TABLE `tbl_tipo_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipoboleta`
--

DROP TABLE IF EXISTS `tbl_tipoboleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tipoboleta` (
  `id_tipobol` char(6) NOT NULL,
  `descrip_tipobol` varchar(45) NOT NULL,
  `precio_tipobol` double DEFAULT NULL,
  PRIMARY KEY (`id_tipobol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipoboleta`
--

LOCK TABLES `tbl_tipoboleta` WRITE;
/*!40000 ALTER TABLE `tbl_tipoboleta` DISABLE KEYS */;
INSERT INTO `tbl_tipoboleta` VALUES ('BTI001','Matricula',0),('BTI002','Retiro de Asignatura',50.8),('BTI003','Certificado',150.5);
/*!40000 ALTER TABLE `tbl_tipoboleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tipoinforme`
--

DROP TABLE IF EXISTS `tbl_tipoinforme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tipoinforme` (
  `id_tipoinfo` char(6) NOT NULL,
  `nombre_tipoinfo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipoinfo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tipoinforme`
--

LOCK TABLES `tbl_tipoinforme` WRITE;
/*!40000 ALTER TABLE `tbl_tipoinforme` DISABLE KEYS */;
INSERT INTO `tbl_tipoinforme` VALUES ('INT001','Informe de RecaudaciÃ³n diario'),('INT002','Informe de encuestas'),('INT003','Informe Mensual de Aprobados');
/*!40000 ALTER TABLE `tbl_tipoinforme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tiposolicitud`
--

DROP TABLE IF EXISTS `tbl_tiposolicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_tiposolicitud` (
  `id_tiposoli` char(6) NOT NULL,
  `nombre_tiposoli` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tiposoli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tiposolicitud`
--

LOCK TABLES `tbl_tiposolicitud` WRITE;
/*!40000 ALTER TABLE `tbl_tiposolicitud` DISABLE KEYS */;
INSERT INTO `tbl_tiposolicitud` VALUES ('SLT001','Solicitud de Cambio de Sede'),('SLT002','Solicitud de Retiro de Asignatura'),('SLT003','Solicitud de Encuestas');
/*!40000 ALTER TABLE `tbl_tiposolicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proyecto_lp_02'
--

--
-- Dumping routines for database 'proyecto_lp_02'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_BuscarAlumno` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_BuscarAlumno`(condicion varchar(30))
BEGIN
SELECT id_alum, concat(nombre_alum,' ',apelli_alum), dni_alum  FROM tbl_alumnos where nombre_alum like concat(condicion,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_BuscarCurso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_BuscarCurso`(condi varchar(50))
BEGIN
	SELECT C.id_curso, C.nombre_curso, P.nombre_prof, C.dias_curso,H.tiempo_horario FROM tbl_cursos as C
    INNER JOIN tbl_profesores as P 
    ON (C.id_prof = P.id_prof) 
    INNER JOIN tbl_horario as H
    ON(H.id_horario = C.id_horario)
    WHERE C.nombre_curso like concat(condi, '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_VerificarLogueo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_VerificarLogueo`(usu varchar(20), pass varchar(20))
BEGIN
	SELECT * FROM tbl_cuentas WHERE usu_cuenta = usu and pass_cuenta = pass;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 10:15:42
