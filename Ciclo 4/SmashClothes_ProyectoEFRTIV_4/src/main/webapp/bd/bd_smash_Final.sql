CREATE DATABASE  IF NOT EXISTS `smashclothes3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smashclothes3`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: smashclothes3
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
-- Table structure for table `tb_boleta_cabezera`
--

DROP TABLE IF EXISTS `tb_boleta_cabezera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta_cabezera` (
  `num_bol` char(5) NOT NULL,
  `tipo_bol` varchar(45) NOT NULL,
  `cod_cli` char(5) NOT NULL,
  `fecha_bol` varchar(45) NOT NULL,
  `pagado_bol` varchar(45) NOT NULL,
  `precioTo_bol` double NOT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `FK_CodCli_Venta_idx` (`cod_cli`),
  CONSTRAINT `FK_CodCli_Venta` FOREIGN KEY (`cod_cli`) REFERENCES `tb_clientes` (`cod_cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta_cabezera`
--

LOCK TABLES `tb_boleta_cabezera` WRITE;
/*!40000 ALTER TABLE `tb_boleta_cabezera` DISABLE KEYS */;
INSERT INTO `tb_boleta_cabezera` VALUES ('BO001','Boleta','CL001','2022-11-11','Pagado',0),('BO002','Boleta','CL001','2022-11-11','Pagado',40),('BO003','Boleta','CL002','2022-11-11','Pagado',15.85),('BO004','Boleta','CL001','2022-11-12','Pagado',15.85),('BO005','Boleta','CL005','2022-11-15','Pagado',159.8);
/*!40000 ALTER TABLE `tb_boleta_cabezera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_boleta_detalle`
--

DROP TABLE IF EXISTS `tb_boleta_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta_detalle` (
  `num_bol` char(5) NOT NULL,
  `cod_prod` char(5) NOT NULL,
  `canti_deta` varchar(45) NOT NULL,
  `precioUni_deta` double NOT NULL,
  PRIMARY KEY (`num_bol`,`cod_prod`),
  KEY `FK_codProd_deta_idx` (`cod_prod`),
  CONSTRAINT `FK_codBol_deta` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta_cabezera` (`num_bol`),
  CONSTRAINT `FK_codProd_deta` FOREIGN KEY (`cod_prod`) REFERENCES `tb_productos` (`cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta_detalle`
--

LOCK TABLES `tb_boleta_detalle` WRITE;
/*!40000 ALTER TABLE `tb_boleta_detalle` DISABLE KEYS */;
INSERT INTO `tb_boleta_detalle` VALUES ('BO001','PR001','2',25),('BO001','PR002','2',35),('BO002','PR001','2',25),('BO002','PR003','4',15),('BO003','PR003','8',15.85),('BO004','PR003','2',15.85),('BO005','PR013','3',59.9),('BO005','PR035','3',99.9);
/*!40000 ALTER TABLE `tb_boleta_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cab_boleta_cli`
--

DROP TABLE IF EXISTS `tb_cab_boleta_cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cab_boleta_cli` (
  `num_bol` char(5) NOT NULL,
  `fch_bol` date DEFAULT NULL,
  `cod_cliente` int NOT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `cod_cliente` (`cod_cliente`),
  CONSTRAINT `tb_cab_boleta_cli_ibfk_1` FOREIGN KEY (`cod_cliente`) REFERENCES `tb_cuenta_usuarios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cab_boleta_cli`
--

LOCK TABLES `tb_cab_boleta_cli` WRITE;
/*!40000 ALTER TABLE `tb_cab_boleta_cli` DISABLE KEYS */;
INSERT INTO `tb_cab_boleta_cli` VALUES ('B0001','2022-11-15',2);
/*!40000 ALTER TABLE `tb_cab_boleta_cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria` (
  `id_cate` char(5) NOT NULL,
  `descrip_cate` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
INSERT INTO `tb_categoria` VALUES ('CA001','Camisa'),('CA002','Gorra'),('CA003','Polo'),('CA004','Cargo Jean'),('CA005','Pantalon'),('CA006','Short');
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `cod_cli` char(5) NOT NULL,
  `nombres_cli` varchar(100) NOT NULL,
  `apellidos_cli` varchar(100) NOT NULL,
  `tipoDoc_cli` int NOT NULL,
  `numDoc_cli` varchar(50) NOT NULL,
  `sexo_cli` varchar(20) NOT NULL,
  `edad_cli` int NOT NULL,
  `fechaNa_cli` date NOT NULL,
  `id_estado` int NOT NULL DEFAULT '1',
  `correo_cli` varchar(45) DEFAULT NULL,
  `fotoRu_cli` varchar(300) DEFAULT NULL,
  `extension_cli` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cli`),
  KEY `FK_estado_cli_idx` (`id_estado`),
  KEY `FK_tipoDoc_cli_idx` (`tipoDoc_cli`),
  CONSTRAINT `FK_estado_cli` FOREIGN KEY (`id_estado`) REFERENCES `tb_estados` (`idestado`),
  CONSTRAINT `FK_tipoDocu_cli` FOREIGN KEY (`tipoDoc_cli`) REFERENCES `tb_tipodocumento` (`id_tipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES ('CL001','Enzo Andreade','Estrada Quispe',2,'78695412','Femenino',15,'2020-12-12',2,'aeasd@gmail.com','C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\clientes\\CL001.png','png'),('CL002','Carlos Juan','Estrada Alvarez',1,' 78968912','Femenino',42,'2022-06-10',2,'carlitos@gmail.com','C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\clientes\\CL002.jpg','jpg'),('CL003','Rodrigo Juan','Juarez Quiroz',2,' 789654894','Femenino',35,'2001-02-02',1,'rodrigo@gmail.com','C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\clientes\\CL003.jpg','jpg'),('CL004','Carlos Juan','Estrada Alvarez',1,'99996542','Femenino',42,'2022-11-02',2,'juancita@hotmail.com','C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\clientes\\CL004.jpg','jpg'),('CL005','Luis','Abregu',1,'87654321','Femenino',19,'2002-12-22',1,'luisab@mail.com','','');
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cuenta_usuarios`
--

DROP TABLE IF EXISTS `tb_cuenta_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cuenta_usuarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `usuario` char(45) NOT NULL,
  `clave` char(5) DEFAULT NULL,
  `fnacim` date DEFAULT NULL,
  `idtipo` int DEFAULT '2',
  `idestado` int DEFAULT '1',
  PRIMARY KEY (`codigo`),
  KEY `tb_usuarios_ibfk_1` (`idtipo`),
  KEY `tb_usuarios_ibfk_2` (`idestado`),
  CONSTRAINT `tb_cuenta_usuarios_ibfk_1` FOREIGN KEY (`idtipo`) REFERENCES `tb_tipos` (`idtipo`),
  CONSTRAINT `tb_cuenta_usuarios_ibfk_2` FOREIGN KEY (`idestado`) REFERENCES `tb_estados` (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cuenta_usuarios`
--

LOCK TABLES `tb_cuenta_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_cuenta_usuarios` DISABLE KEYS */;
INSERT INTO `tb_cuenta_usuarios` VALUES (1,'Admin','Smash','admin@mail.com','1111','2022-10-04',1,1),(2,'Nicolas','Adanaque Leon','nico@mail.com','2004','2004-04-22',2,1),(3,'Jefe','General','jefe@mail.com','jefe','1982-11-06',1,1),(9,'Jesus ','Alva','jesus@gmail.com','jesus','2022-10-20',2,1),(10,'Luis','Abregu','luis@mail.com','luis','2003-02-12',2,1),(11,'Andrea Angela','Hilanez Gutierrz','PR037@mail.com','8433','2000-12-12',1,1),(12,'AEA AEA','AEA AEA','12@mail.com','1681','2000-12-12',4,1),(13,'Juan del Amisa','Arquides Euribes','US008@mail.com','2404','2000-12-12',4,1),(14,'Gustavo Hola','Albornoz Galvan','US009@mail.com','4334','2000-12-12',4,1),(15,'Andrea Angela','Albornoz Galvan','US010@mail.com','8626','2000-12-12',1,1),(16,'Andrea Angela','Albornoz Galvan','US011@mail.com','8296','2000-12-12',1,1);
/*!40000 ALTER TABLE `tb_cuenta_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_det_boleta_cli`
--

DROP TABLE IF EXISTS `tb_det_boleta_cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_det_boleta_cli` (
  `num_bol` char(5) NOT NULL,
  `idprod` char(5) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `preciovta` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`num_bol`,`idprod`),
  KEY `idprod` (`idprod`),
  CONSTRAINT `tb_det_boleta_cli_ibfk_1` FOREIGN KEY (`num_bol`) REFERENCES `tb_cab_boleta_cli` (`num_bol`),
  CONSTRAINT `tb_det_boleta_cli_ibfk_2` FOREIGN KEY (`idprod`) REFERENCES `tb_productos` (`cod_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_det_boleta_cli`
--

LOCK TABLES `tb_det_boleta_cli` WRITE;
/*!40000 ALTER TABLE `tb_det_boleta_cli` DISABLE KEYS */;
INSERT INTO `tb_det_boleta_cli` VALUES ('B0001','PR001',1,25.12),('B0001','PR002',1,35.15);
/*!40000 ALTER TABLE `tb_det_boleta_cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estados`
--

DROP TABLE IF EXISTS `tb_estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estados` (
  `idestado` int NOT NULL,
  `descripcion` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estados`
--

LOCK TABLES `tb_estados` WRITE;
/*!40000 ALTER TABLE `tb_estados` DISABLE KEYS */;
INSERT INTO `tb_estados` VALUES (1,'activo'),(2,'eliminado'),(3,'suspendido');
/*!40000 ALTER TABLE `tb_estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_productos`
--

DROP TABLE IF EXISTS `tb_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_productos` (
  `cod_prod` char(5) NOT NULL,
  `fecha_prod` date NOT NULL,
  `descrip_prod` varchar(200) NOT NULL,
  `id_cate` char(5) NOT NULL,
  `idestado` int NOT NULL,
  `stock_prod` int NOT NULL,
  `precio_prod` double NOT NULL,
  `nombre_prod` varchar(50) NOT NULL,
  `cod_pro` char(5) NOT NULL,
  `fotoRut_prod` varchar(300) DEFAULT NULL,
  `fotoExte_prod` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_prod`),
  KEY `FK_codPro_Prod_idx` (`cod_pro`),
  KEY `FK_estado_Prod_idx` (`idestado`),
  KEY `FK_categoria_Prod_idx` (`id_cate`),
  CONSTRAINT `FK_categoria_Prod` FOREIGN KEY (`id_cate`) REFERENCES `tb_categoria` (`id_cate`),
  CONSTRAINT `FK_codPro_Prod` FOREIGN KEY (`cod_pro`) REFERENCES `tb_proveedor` (`cod_pro`),
  CONSTRAINT `FK_estado_Prod` FOREIGN KEY (`idestado`) REFERENCES `tb_estados` (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_productos`
--

LOCK TABLES `tb_productos` WRITE;
/*!40000 ALTER TABLE `tb_productos` DISABLE KEYS */;
INSERT INTO `tb_productos` VALUES ('PR001','2020-12-15','Tela fina de utilización diaria','CA002',2,10,25.12,'Camisa Herker','PO001',NULL,NULL),('PR002','2021-11-12','Tela escarlata de uso ocasional','CA001',2,17,35.15,'Pantalón Gucci','PO001',NULL,NULL),('PR003','2022-11-10','  Tela de Carbón Saludable','CA003',2,18,15.85,'Medias Adidas','PO002','C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\productos\\PR003.jpg','jpg'),('PR004','2021-05-29','Telas de algodón','CA001',1,25,99.9,'Camisa Oversize Cuadros','PO001',NULL,NULL),('PR005','2021-08-25','Telas de algodón','CA001',1,10,99.99,'Camisa Oversize Negra Estilo Coreano','PO001',NULL,NULL),('PR006','2021-11-30','Telas de algodón','CA001',1,30,109.9,'Camisa Oversize Soviet','PO001',NULL,NULL),('PR007','2021-11-30','Gorras de Drill ','CA002',1,30,49.5,'Gorra NY Negra','PO001',NULL,NULL),('PR008','2021-11-12','Gorras de Drill ','CA002',1,20,49.5,'Gorra Champion Negra','PO001',NULL,NULL),('PR009','2021-11-12','Gorras de Drill ','CA002',1,20,49.5,'Gorra Champion Roja','PO001',NULL,NULL),('PR010','2021-11-12','Gorras de Drill ','CA002',1,20,49.5,'Gorra Happiness Negra','PO001',NULL,NULL),('PR011','2021-11-12','Gorras de Drill ','CA002',1,15,49.5,'Gorra NY Roja','PO001',NULL,NULL),('PR012','2021-11-12','Gorras de Drill ','CA002',1,20,49.5,'Gorra NIKE SB Negra','PO001',NULL,NULL),('PR013','2021-11-12','Algodón Jersey 20/1','CA003',1,22,59.9,'Polo Phoenix Black','PO001',NULL,NULL),('PR014','2021-11-12','Algodón Jersey 20/1','CA003',1,30,59.99,'Polo All Up','PO001',NULL,NULL),('PR015','2021-11-12','Algodón Jersey 20/1','CA003',1,35,49.5,'Polo Oversize Basico Verde','PO001',NULL,NULL),('PR016','2021-11-12','Algodón Jersey 20/1','CA003',1,45,50.4,'Polo Oversize Urbano','PO001',NULL,NULL),('PR017','2021-11-12','Algodón Jersey 20/1','CA003',1,35,39.9,'The Cult Polo Oversize','PO001',NULL,NULL),('PR018','2021-11-12','Algodón Jersey 20/1','CA003',1,40,39.99,'Polo Oversize Aesthetic','PO001',NULL,NULL),('PR019','2021-11-12','Tela DENIN pesada y rígida','CA004',1,10,149.9,'Jean Rasgado Sky','PO001',NULL,NULL),('PR020','2021-11-12','tela DENIN pesada y rígida','CA004',1,15,139.9,'Jean Rasgado Negro','PO001',NULL,NULL),('PR021','2021-11-12','tela DENIN pesada y rígida','CA004',1,15,129.9,'Cargo Jean Baige','PO001',NULL,NULL),('PR022','2021-11-12','tela DENIN pesada y rígida','CA004',1,10,129.9,'Cargo Jean Plomo','PO001',NULL,NULL),('PR023','2021-11-12','tela DENIN pesada y rígida','CA004',1,20,129.9,'Jean Jogger Pitillo','PO001',NULL,NULL),('PR024','2021-11-12','tela DENIN pesada y rígida','CA004',1,10,129.9,'Jean Rasgado','PO001',NULL,NULL),('PR025','2021-11-12','Confeccionado en tejido vaquero','CA005',1,10,139.9,'Pantalon Cargo Negro Hip Hop','PO001',NULL,NULL),('PR026','2021-11-12','Confeccionado en tejido vaquero','CA005',1,30,99.99,'Pantalon Cargo Verde','PO001',NULL,NULL),('PR027','2021-11-12','Confeccionado en tejido vaquero','CA005',1,30,119.9,'Pantalon cargo Baige','PO001',NULL,NULL),('PR028','2021-11-12','Confeccionado en tejido vaquero','CA005',1,15,99.99,'Pantalon Cesar Verde','PO001',NULL,NULL),('PR029','2021-11-12','Confeccionado en tejido vaquero','CA005',1,10,129.5,'Pantalon Zagregad Camel','PO001',NULL,NULL),('PR030','2021-11-12','Confeccionado en tejido vaquero','CA005',1,10,129.5,'Pantalon Zagregad Verde','PO001',NULL,NULL),('PR031','2021-11-12','Microfibra Beach','CA006',1,30,99.9,'Short Cargo Negro','PO001',NULL,NULL),('PR032','2021-11-12','Microfibra Beach','CA006',1,15,99.9,'Short Cargo Blanco','PO001',NULL,NULL),('PR033','2021-11-12','Microfibra Beach','CA006',1,25,99.9,'Short Cargo Baige','PO001',NULL,NULL),('PR034','2021-11-12','Microfibra Beach','CA006',1,15,99.9,'Short Cargo Militar','PO001',NULL,NULL),('PR035','2021-11-12','Microfibra Beach','CA006',1,17,99.9,'Short Cargo Lima Beige','PO001',NULL,NULL),('PR036','2021-11-12','Microfibra Beach','CA006',1,15,99.9,'Short Cargo Plomo','PO001',NULL,NULL);
/*!40000 ALTER TABLE `tb_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `cod_pro` char(5) NOT NULL,
  `repre_pro` varchar(200) NOT NULL,
  `empresa_pro` varchar(250) NOT NULL,
  `ruc_pro` varchar(11) NOT NULL,
  `pais_pro` varchar(100) NOT NULL,
  `correo_pro` varchar(100) NOT NULL,
  `tele_pro` varchar(20) NOT NULL,
  `id_estado` int DEFAULT '1',
  `fotoRu_pro` varchar(300) DEFAULT NULL,
  `fotoExte_pro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_pro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES ('PO001','Juan Albañez Quispe','Joselito SAC','7896541234','Perú','jose_sac@gmail.com','995874123',2,NULL,NULL),('PO002','Albedrio Juan Perez','Adidas SAC','789456125','Perú','albredio@hotmail.com','988765412',1,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\proveedores\\PO002.png','png');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipodocumento`
--

DROP TABLE IF EXISTS `tb_tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipodocumento` (
  `id_tipoDoc` int NOT NULL,
  `descrip_tipoDoc` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipodocumento`
--

LOCK TABLES `tb_tipodocumento` WRITE;
/*!40000 ALTER TABLE `tb_tipodocumento` DISABLE KEYS */;
INSERT INTO `tb_tipodocumento` VALUES (1,'DNI'),(2,'Pasaporte');
/*!40000 ALTER TABLE `tb_tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipos`
--

DROP TABLE IF EXISTS `tb_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipos` (
  `idtipo` int NOT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipos`
--

LOCK TABLES `tb_tipos` WRITE;
/*!40000 ALTER TABLE `tb_tipos` DISABLE KEYS */;
INSERT INTO `tb_tipos` VALUES (1,'Administrativo'),(2,'Cliente'),(3,'Gerente'),(4,'Asistente de Ventas'),(5,'Cajero');
/*!40000 ALTER TABLE `tb_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `cod_usu` char(5) NOT NULL,
  `nombres_usu` varchar(120) NOT NULL,
  `apellido_usu` varchar(120) NOT NULL,
  `tipoDoc_usu` int NOT NULL,
  `numDoc_usu` int NOT NULL,
  `sexo_usu` varchar(30) NOT NULL,
  `edad_usu` int NOT NULL,
  `id_tipo` int NOT NULL,
  `depa_usu` varchar(90) NOT NULL,
  `domici_usu` varchar(120) NOT NULL,
  `distrito_usu` varchar(50) NOT NULL,
  `provi_usu` varchar(50) NOT NULL,
  `pais_usu` varchar(120) NOT NULL,
  `nacio_usu` varchar(100) NOT NULL,
  `correo_usu` varchar(50) NOT NULL,
  `id_estado` int DEFAULT '1',
  `id_cuenta` int NOT NULL DEFAULT '1',
  `fotoRu_usu` varchar(300) DEFAULT NULL,
  `fotoExten_usu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `FK_idTipo_Usu_idx` (`id_tipo`),
  KEY `FK_estado_Usu_idx` (`id_estado`),
  KEY `FK_tipoDoc_Usu_idx` (`tipoDoc_usu`),
  KEY `FK_Cod_Cuenta_Usu_idx` (`id_cuenta`),
  CONSTRAINT `FK_Cod_Cuenta_Usu` FOREIGN KEY (`id_cuenta`) REFERENCES `tb_cuenta_usuarios` (`codigo`),
  CONSTRAINT `FK_estado_Usu` FOREIGN KEY (`id_estado`) REFERENCES `tb_estados` (`idestado`),
  CONSTRAINT `FK_idTipo_Usu` FOREIGN KEY (`id_tipo`) REFERENCES `tb_tipos` (`idtipo`),
  CONSTRAINT `FK_tipoDoc_Usu` FOREIGN KEY (`tipoDoc_usu`) REFERENCES `tb_tipodocumento` (`id_tipoDoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES ('US001','Lalo LLosas','Alvares Rodriguez',1,99999,'Femenino',20,1,'RR.HH.','Las Rocas - 156','Lima','Lima','Perú','Peruano','laliot@gamil.com',2,1,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\usuarios\\US001.jpg','jpg'),('US004','Andrea Angela','Albornoz Galvan',1,78965412,'Femenino',20,1,'RR.HH.','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,1,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\EFRTS4_Proyecto\\src\\main\\webapp\\imgs\\usuarios\\US005.jpg','jpg'),('US006','Andrea Angela','Hilanez Gutierrz',1,9999999,'Femenino',15,1,'RR.HH.','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',2,11,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US006.png','png'),('US007','AEA AEA','AEA AEA',1,78965412,'Femenino',15,4,'Administración','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,12,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US007.png','png'),('US008','Juan del Amisa','Arquides Euribes',1,78965412,'Femenino',15,4,'RR.HH.','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,13,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US008.png','png'),('US009','Gustavo Hola','Albornoz Galvan',1,78965412,'Femenino',45,4,'Administración','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,14,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US009.png','png'),('US010','Andrea Angela','Albornoz Galvan',1,78965412,'Femenino',15,1,'RR.HH.','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,15,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US010.png','png'),('US011','Andrea Angela','Albornoz Galvan',1,9999999,'Femenino',15,1,'RR.HH.','Las Flores - 521','San Isidro','Lima','Perú','Peruana','andelia@gmail.com',1,16,'C:\\Users\\Usuario\\Desktop\\Practicas Clase\\LP II\\PROYECTO EFRT IV\\SmashClothes_ProyectoEFRTIV\\src\\main\\webapp\\imgs\\usuarios\\US011.png','png');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'smashclothes3'
--

--
-- Dumping routines for database 'smashclothes3'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_validaAcceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validaAcceso`(usr char(45), pas char(5))
begin
select * from tb_usuarios where usuario = usr and clave = pas;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_validaAccesoMini` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_validaAccesoMini`(usr char(45), pas char(5))
begin
select * from tb_cuenta_usuarios where usuario = usr and clave = pas;
end ;;
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

-- Dump completed on 2022-11-17  0:06:07
