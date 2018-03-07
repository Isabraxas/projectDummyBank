-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: viridianbank
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Autorizacion`
--

DROP TABLE IF EXISTS `Autorizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Autorizacion` (
  `id_autorizacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  `detalle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_autorizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autorizacion`
--

LOCK TABLES `Autorizacion` WRITE;
/*!40000 ALTER TABLE `Autorizacion` DISABLE KEYS */;
INSERT INTO `Autorizacion` VALUES (1,'A-1','primera'),(2,'A-2','segunda'),(3,'B-1','tercera');
/*!40000 ALTER TABLE `Autorizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Beneficiario`
--

DROP TABLE IF EXISTS `Beneficiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Beneficiario` (
  `id_beneficiario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_rs` varchar(255) NOT NULL,
  `nit_ci` varchar(255) NOT NULL,
  `numero_cuenta` bigint(20) NOT NULL,
  `monto` decimal(10,0) NOT NULL,
  `moneda` varchar(255) NOT NULL,
  `banco` varchar(255) NOT NULL,
  PRIMARY KEY (`id_beneficiario`),
  UNIQUE KEY `nit_ci` (`nit_ci`),
  UNIQUE KEY `numero_cuenta` (`numero_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beneficiario`
--

LOCK TABLES `Beneficiario` WRITE;
/*!40000 ALTER TABLE `Beneficiario` DISABLE KEYS */;
INSERT INTO `Beneficiario` VALUES (1,'Mario Ramos','3652789',78945612,200,'BOB','Viridian'),(3,'Adriana Velisar','54684',54698,112,'BSF','Viridian'),(4,'bob jhonson','11223344',100004544,500,'USD','bisa');
/*!40000 ALTER TABLE `Beneficiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(1) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'J'),(2,'J'),(3,'J'),(4,'N'),(6,'N'),(7,'N'),(9,'N'),(10,'N');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente_Beneficiario`
--

DROP TABLE IF EXISTS `Cliente_Beneficiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente_Beneficiario` (
  `cliente_id` bigint(20) NOT NULL,
  `beneficiario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cliente_id`,`beneficiario_id`),
  KEY `beneficiario_id` (`beneficiario_id`),
  CONSTRAINT `Cliente_Beneficiario_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id_cliente`),
  CONSTRAINT `Cliente_Beneficiario_ibfk_2` FOREIGN KEY (`beneficiario_id`) REFERENCES `Beneficiario` (`id_beneficiario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente_Beneficiario`
--

LOCK TABLES `Cliente_Beneficiario` WRITE;
/*!40000 ALTER TABLE `Cliente_Beneficiario` DISABLE KEYS */;
INSERT INTO `Cliente_Beneficiario` VALUES (4,1),(6,1),(4,3),(4,4);
/*!40000 ALTER TABLE `Cliente_Beneficiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estatus`
--

DROP TABLE IF EXISTS `Estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estatus` (
  `id_estatus` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_estatus`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estatus`
--

LOCK TABLES `Estatus` WRITE;
/*!40000 ALTER TABLE `Estatus` DISABLE KEYS */;
INSERT INTO `Estatus` VALUES (1,'Activa(estado inicial)'),(2,'Parcialmente comprometida'),(3,'Fallida'),(4,'Abortada'),(5,'Comprometida');
/*!40000 ALTER TABLE `Estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Metodo`
--

DROP TABLE IF EXISTS `Metodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Metodo` (
  `id_metodo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_metodo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Metodo`
--

LOCK TABLES `Metodo` WRITE;
/*!40000 ALTER TABLE `Metodo` DISABLE KEYS */;
INSERT INTO `Metodo` VALUES (1,'Efectivo en ventanilla'),(2,'Cheque'),(3,'Tarjeta de credito'),(4,'Tarnferencia cuentas propias'),(5,'Tarnferencia cuentas de terceros'),(6,'Tarnferencia cuentas de otros bancos'),(7,'Reversion Transaccion');
/*!40000 ALTER TABLE `Metodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operacion`
--

DROP TABLE IF EXISTS `Operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operacion` (
  `id_operacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_operacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operacion`
--

LOCK TABLES `Operacion` WRITE;
/*!40000 ALTER TABLE `Operacion` DISABLE KEYS */;
INSERT INTO `Operacion` VALUES (1,'Pago'),(2,'Deposito'),(3,'Pago Electronico'),(4,'Compra moneda extranjera');
/*!40000 ALTER TABLE `Operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operador`
--

DROP TABLE IF EXISTS `Operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operador` (
  `id_operador` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_operador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operador`
--

LOCK TABLES `Operador` WRITE;
/*!40000 ALTER TABLE `Operador` DISABLE KEYS */;
INSERT INTO `Operador` VALUES (2,'marcelo',7),(3,'isvar',10);
/*!40000 ALTER TABLE `Operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `id_persona` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `apellido_casado` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `documento_identidad` varchar(50) NOT NULL,
  `numero_documento` varchar(50) NOT NULL,
  `fecha_nacimiento` varchar(50) NOT NULL,
  `lugar_nacimiento` varchar(50) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  `domicilio` varchar(50) NOT NULL,
  `domicilio_trabajo` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `estado_civil` varchar(50) NOT NULL,
  `profesion` varchar(50) NOT NULL,
  `caracter_legal` varchar(50) NOT NULL,
  `nombre_conyuge` varchar(50) DEFAULT NULL,
  `nombre_padre` varchar(50) NOT NULL,
  `nombre_madre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'peres','peres','','marco','carnet','211112','2000-02-01','la paz','boliviano','C. falsa','','222222','email@email.com','soltero','abogado','titular','','jhon peres','linda peres'),(2,'sanches','sanches','sanches','julia','carnet','44566','1995-02-01','santa cruz','boliviana','Av. falsa','C. Real','456789','e4mail@email.com','casada','ama de casa','titular','','steve sanches','rosa sanches'),(3,'jhonson','jhonson','','larry','carnet','989879','1980-10-10','cochabamba','boliviano','C. Lorem','C. Ipsum','445654','mail@email.com','viudo','informatico','titular','','larry senior','martha'),(4,'aaaa','bbbb','ccc','ddd','eee','132456','2000-06-06','fff','ggg','hhh','iii','jjj','kkk','lll','mmm','nnn','qqq','ooo','ppp'),(5,'zzz','zzz','zzz','zzz','zzz','444444','2001-01-01','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz'),(7,'ppp','ppp','ppp','ppp','ppp','78978798','2002-02-02','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp'),(8,'mats','boskowits','','mike','carnet','99885522','2005-05-05','la paz','boliviano','c. peres','','555555','mike@email.com','soltero','chofer','titular','','jhon mats','lia boskowits'),(9,'oooo','oooo','oooo','oooo','oooo','0','2001-10-10','ooo','ooo','ooo','ooo','ooo','ooo','ooo','ooo','ooo','ooo','ooo','ooo'),(10,'xxx','xx','x','x','x','44','2001-01-01','x','x','x','x','x','x','x','x','x','x','x','x');
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona_Juridica`
--

DROP TABLE IF EXISTS `Persona_Juridica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona_Juridica` (
  `id_cliente` bigint(20) NOT NULL,
  `nombre_razon` varchar(100) NOT NULL,
  `nit` bigint(20) NOT NULL,
  `registro_fundaempresa` varchar(100) NOT NULL,
  `representante_legal` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona_Juridica`
--

LOCK TABLES `Persona_Juridica` WRITE;
/*!40000 ALTER TABLE `Persona_Juridica` DISABLE KEYS */;
INSERT INTO `Persona_Juridica` VALUES (1,'entel',111222333,'',2),(2,'multicine',222333444,'reg-fe2',3),(3,'factory',333444555,'reg-fe3',2);
/*!40000 ALTER TABLE `Persona_Juridica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona_Natural`
--

DROP TABLE IF EXISTS `Persona_Natural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona_Natural` (
  `id_cliente` bigint(20) NOT NULL,
  `persona_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `persona_id` (`persona_id`),
  CONSTRAINT `Persona_Natural_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona_Natural`
--

LOCK TABLES `Persona_Natural` WRITE;
/*!40000 ALTER TABLE `Persona_Natural` DISABLE KEYS */;
INSERT INTO `Persona_Natural` VALUES (4,1),(6,4),(7,5),(9,9),(10,10);
/*!40000 ALTER TABLE `Persona_Natural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transaccion`
--

DROP TABLE IF EXISTS `Transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transaccion` (
  `id_transaccion` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_cuenta` bigint(20) NOT NULL,
  `fecha_inicio` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fecha_aprobacion` datetime DEFAULT NULL,
  `fecha_ejecucion` datetime DEFAULT NULL,
  `numero_orden` bigint(20) NOT NULL,
  `metodo_id` bigint(20) NOT NULL,
  `estatus_id` bigint(20) NOT NULL,
  `autorizacion_id` bigint(20) NOT NULL,
  `operacion_id` bigint(20) NOT NULL,
  `concepto_glosa` varchar(255) NOT NULL,
  `monto` decimal(10,0) NOT NULL,
  `moneda` varchar(255) NOT NULL,
  `saldo` decimal(10,0) NOT NULL,
  `beneficiario_id` bigint(20) NOT NULL,
  `operador_id` bigint(20) NOT NULL,
  `regis_asfi` bigint(20) NOT NULL,
  `registro_facturacion` bigint(20) NOT NULL,
  PRIMARY KEY (`id_transaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transaccion`
--

LOCK TABLES `Transaccion` WRITE;
/*!40000 ALTER TABLE `Transaccion` DISABLE KEYS */;
INSERT INTO `Transaccion` VALUES (1,12345678,'1970-01-01 00:00:01','1970-01-01 00:00:01','1970-01-01 00:00:01',1,1,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(2,12345678,'1972-01-01 00:00:01','1973-01-01 00:00:01','1974-01-01 00:00:01',1,3,1,1,1,'transferencia pago curso',100,'USD',500,1,1,1,1),(6,12345679,'2015-10-21 00:00:00','1970-01-01 00:16:41','1970-01-01 00:16:41',1,1,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(7,12345677,'1972-01-01 00:00:01','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(8,12345677,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(9,12345677,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(10,12345673,'1985-01-01 00:00:01','0002-11-30 00:00:00','1989-01-01 00:00:01',2,2,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(13,124235,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,2,1,'transferencia pago curso',33,'BOB',4444,1,1,1,1),(14,22,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,1,1,'transferencia pago curso',50,'USD',70,1,1,1,1),(21,12345678,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(22,12345678,'2018-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(23,12345678,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(24,12345679,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(25,12345678,'2018-01-10 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(26,12345678,'2018-02-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(27,12345678,'2018-02-12 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(28,12345678,'2017-12-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(29,12345678,'2017-12-01 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(30,12345678,'2017-11-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(31,12345678,'2017-01-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(32,12345678,'2017-10-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(33,12345678,'2017-11-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(34,100004542,'2018-02-28 10:10:51',NULL,NULL,1,4,6,1,2,'transfer prueba',50,'BOB',50,1,0,1,1),(35,100004543,'2018-02-28 10:16:32',NULL,NULL,1,4,6,1,2,'transfer example 2',50,'BOB',50,1,0,1,1),(36,100004541,'2018-02-28 12:48:51',NULL,NULL,1,4,6,1,2,'transfer-terceros',50,'BOB',50,1,0,1,1),(37,100004542,'2018-02-28 15:12:09',NULL,NULL,1,4,5,1,2,'transfer update',50,'BOB',50,1,3,1,1),(38,100004541,'2018-03-01 09:47:58',NULL,NULL,1,6,5,1,2,'gringo',10,'USD',50,1,3,1,1),(39,100004541,'2018-03-02 09:11:59',NULL,NULL,1,5,1,1,2,'NOTA REVERTIR ESTA',5,'BOB',50,1,3,1,1),(40,78945612,'2018-03-02 09:13:26',NULL,NULL,1,7,2,1,2,'REVERSION TRANSACCION: 39',5,'BOB',50,1,3,1,1);
/*!40000 ALTER TABLE `Transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `id_cuenta` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_cuenta` bigint(20) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `saldo` decimal(10,0) NOT NULL,
  `cliente_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `cliente_id_fk0` (`cliente_id`),
  CONSTRAINT `cliente_id_fk0` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (100,100004540,'ahorro',1000,1),(101,100004541,'deposito',500,4),(102,100004542,'deposito',700,6),(103,100004543,'ahorro',50,6),(104,100004544,'ahorro',50,7);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-06 13:15:03
