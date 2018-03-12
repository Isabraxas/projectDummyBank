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
  `monto` decimal(10,0) DEFAULT NULL,
  `moneda` varchar(255) NOT NULL,
  `banco` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_beneficiario`),
  UNIQUE KEY `numero_cuenta` (`numero_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beneficiario`
--

LOCK TABLES `Beneficiario` WRITE;
/*!40000 ALTER TABLE `Beneficiario` DISABLE KEYS */;
INSERT INTO `Beneficiario` VALUES (1,'Mario Ramos','3652789',78945612,200,'BOB','Viridian'),(3,'Adriana Velisar','54684',54698,112,'BSF','Viridian'),(4,'maria','3652789',78945613,200,'BOB','Viridian'),(15,'marco','211112',100004545,NULL,'BOB',NULL),(17,'marco','211112',666666,NULL,'BOB',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'J'),(2,'J'),(3,'J'),(4,'N'),(6,'N'),(7,'N');
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
INSERT INTO `Cliente_Beneficiario` VALUES (4,1),(6,1),(4,3),(4,15),(4,17);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Metodo`
--

LOCK TABLES `Metodo` WRITE;
/*!40000 ALTER TABLE `Metodo` DISABLE KEYS */;
INSERT INTO `Metodo` VALUES (1,'Efectivo en ventanilla'),(2,'Cheque'),(3,'Tarjeta de credito'),(4,'Tarnferencia cuentas propias'),(5,'Tarnferencia cuentas de terceros'),(6,'Tarnferencia cuentas de otros bancos');
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
INSERT INTO `Operador` VALUES (1,'xx',20),(2,'marcelo',7),(3,'isvar',10);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'peres','peres','','marco','carnet','211112','2000-02-01','la paz','boliviano','C. falsa','','222222','email@email.com','soltero','abogado','titular','','jhon peres','linda peres'),(2,'sanches','sanches','sanches','julia','carnet','44566','1995-02-01','santa cruz','boliviana','Av. falsa','C. Real','456789','e4mail@email.com','casada','ama de casa','titular','','steve sanches','rosa sanches'),(3,'jhonson','jhonson','','larry','carnet','989879','1980-10-10','cochabamba','boliviano','C. Lorem','C. Ipsum','445654','mail@email.com','viudo','informatico','titular','','larry senior','martha'),(4,'aaaa','bbbb','ccc','ddd','eee','132456','2000-06-06','fff','ggg','hhh','iii','jjj','kkk','lll','mmm','nnn','qqq','ooo','ppp'),(5,'zzz','zzz','zzz','zzz','zzz','444444','2001-01-01','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz','zzz'),(7,'ppp','ppp','ppp','ppp','ppp','78978798','2002-02-02','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp','ppp'),(8,'mats','boskowits','','mike','carnet','99885522','2005-05-05','la paz','boliviano','c. peres','','555555','mike@email.com','soltero','chofer','titular','','jhon mats','lia boskowits');
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
INSERT INTO `Persona_Natural` VALUES (4,1),(6,4),(7,5);
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
  `cliente_id` bigint(20) DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_aprobacion` datetime DEFAULT NULL,
  `fecha_ejecucion` datetime DEFAULT NULL,
  `numero_orden` bigint(20) NOT NULL,
  `metodo_id` bigint(20) NOT NULL,
  `estatus_id` bigint(20) NOT NULL,
  `autorizacion_id` bigint(20) DEFAULT NULL,
  `operacion_id` bigint(20) NOT NULL,
  `concepto_glosa` varchar(255) DEFAULT NULL,
  `monto` decimal(10,0) NOT NULL,
  `moneda` varchar(255) NOT NULL,
  `saldo` decimal(10,0) DEFAULT NULL,
  `beneficiario_id` bigint(20) NOT NULL,
  `operador_id` bigint(20) DEFAULT NULL,
  `regis_asfi` bigint(20) DEFAULT NULL,
  `registro_facturacion` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_transaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transaccion`
--

LOCK TABLES `Transaccion` WRITE;
/*!40000 ALTER TABLE `Transaccion` DISABLE KEYS */;
INSERT INTO `Transaccion` VALUES (2,12345678,NULL,'1972-01-01 00:00:01','1973-01-01 00:00:01','1974-01-01 00:00:01',1,3,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(6,12345679,NULL,'2015-10-21 00:00:00','1970-01-01 00:16:41','1970-01-01 00:16:41',1,1,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(7,12345677,NULL,'1972-01-01 00:00:01','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(8,12345677,NULL,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(9,12345677,NULL,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(10,12345673,NULL,'1985-01-01 00:00:01','0002-11-30 00:00:00','1989-01-01 00:00:01',2,2,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(13,124235,NULL,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,2,1,'transferencia pago curso',33,'BOB',4444,1,1,1,1),(14,22,NULL,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,1,1,'transferencia pago curso',50,'USD',70,1,1,1,1),(21,12345678,NULL,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(22,12345678,NULL,'2018-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(23,12345678,NULL,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(24,12345679,NULL,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(25,12345678,NULL,'2018-01-10 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(26,12345678,NULL,'2018-02-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(27,12345678,NULL,'2018-02-12 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(28,12345678,NULL,'2017-12-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(29,12345678,NULL,'2017-12-01 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(30,12345678,NULL,'2017-11-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(31,12345678,NULL,'2017-01-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(32,12345678,NULL,'2017-10-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(33,12345678,NULL,'2017-11-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(35,100004541,NULL,'2018-02-01 14:21:24','2018-03-01 17:02:52',NULL,12,1,2,NULL,1,NULL,100,'BOB',0,1,NULL,NULL,NULL),(36,100004541,NULL,'2018-03-01 14:54:30',NULL,NULL,1,1,1,NULL,1,NULL,100,'BOB',NULL,1,NULL,NULL,NULL),(37,100004541,NULL,'2018-03-01 15:58:27',NULL,NULL,1,1,1,NULL,1,NULL,100,'BOB',NULL,1,NULL,NULL,NULL),(38,100004541,NULL,'2018-03-01 16:01:17',NULL,NULL,1,1,1,NULL,1,NULL,100,'BOB',NULL,1,NULL,NULL,NULL),(39,100004541,NULL,'2018-03-01 16:02:23',NULL,NULL,1,1,1,NULL,1,NULL,100,'BOB',NULL,1,NULL,NULL,NULL),(40,100004541,NULL,'2018-03-01 16:05:18',NULL,NULL,1,1,1,NULL,1,NULL,100,'BOB',NULL,1,NULL,NULL,NULL),(41,100004541,NULL,'2018-03-01 16:07:09',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(42,100004541,NULL,'2018-03-01 16:12:26',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(43,100004541,NULL,'2018-03-01 16:14:34',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(44,100004541,NULL,'2018-03-01 16:18:46',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(45,100004541,NULL,'2018-03-01 16:20:09',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(46,100004541,NULL,'2018-03-01 16:58:06',NULL,NULL,15,1,1,NULL,1,NULL,100,'BOB',500,1,NULL,NULL,NULL),(47,100004541,NULL,'2018-03-02 09:04:55',NULL,NULL,15,1,3,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(48,100004541,NULL,'2018-03-02 09:07:15',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(49,100004541,NULL,'2018-03-02 09:08:03',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(50,100004541,NULL,'2018-03-02 09:08:43',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(51,100004541,NULL,'2018-03-02 09:10:07',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(52,100004541,NULL,'2018-03-02 09:10:49',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(53,100004541,NULL,'2018-03-02 09:12:05',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',590,1,NULL,NULL,NULL),(54,100004541,NULL,'2018-03-02 09:15:03',NULL,NULL,18,1,1,NULL,1,NULL,10,'BOB',490,1,NULL,NULL,NULL),(55,100004541,NULL,'2018-03-02 09:20:44',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',480,1,NULL,NULL,NULL),(56,100004541,NULL,'2018-03-02 09:24:25',NULL,NULL,15,1,2,NULL,1,NULL,10,'BOB',NULL,1,NULL,NULL,NULL),(57,100004541,NULL,'2018-03-02 09:45:46',NULL,NULL,15,2,1,NULL,1,NULL,10,'BOB',480,1,NULL,NULL,NULL),(58,100004541,NULL,'2018-03-02 10:01:55',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',NULL,1,NULL,NULL,NULL),(59,100004541,NULL,'2018-03-02 10:02:47','2018-03-02 10:02:46',NULL,15,1,2,NULL,1,NULL,10,'BOB',460,1,NULL,NULL,NULL),(60,100004541,NULL,'2018-03-02 10:06:29','2018-03-02 10:06:29',NULL,15,1,2,NULL,1,NULL,10,'BOB',450,1,NULL,NULL,NULL),(61,100004541,NULL,'2018-03-02 10:13:11','2018-03-02 10:13:10',NULL,15,1,2,NULL,1,NULL,10,'BOB',440,1,NULL,NULL,NULL),(62,100004541,NULL,'2018-03-02 10:14:09','2018-03-02 10:14:17',NULL,15,1,2,NULL,1,NULL,10,'BOB',430,1,NULL,NULL,NULL),(63,100004541,NULL,'2018-03-02 10:17:19','2018-03-02 10:17:18',NULL,15,1,2,NULL,1,NULL,10,'BOB',420,1,NULL,NULL,NULL),(64,100004541,NULL,'2018-03-02 10:25:21','2018-03-02 10:25:21',NULL,15,1,2,NULL,1,NULL,10,'BOB',410,1,NULL,NULL,NULL),(65,100004541,NULL,'2018-03-02 10:26:53','2018-03-02 10:26:53',NULL,15,1,2,NULL,1,NULL,10,'BOB',400,1,NULL,NULL,NULL),(66,100004541,NULL,'2018-03-02 10:31:13','2018-03-02 10:31:13',NULL,15,1,2,NULL,1,NULL,10,'BOB',390,1,NULL,NULL,NULL),(67,100004541,NULL,'2018-03-02 10:33:13','2018-03-02 10:33:13',NULL,15,1,2,NULL,1,NULL,10,'BOB',380,1,NULL,NULL,NULL),(68,100004541,NULL,'2018-03-02 10:35:02','2018-03-02 10:35:02',NULL,15,1,2,NULL,1,NULL,10,'BOB',370,1,NULL,NULL,NULL),(69,100004541,NULL,'2018-03-02 10:40:35','2018-03-02 10:40:35',NULL,15,1,5,NULL,1,NULL,10,'BOB',360,1,NULL,NULL,NULL),(70,100004541,NULL,'2018-03-02 11:37:22',NULL,NULL,15,1,1,NULL,1,NULL,10,'BOB',NULL,1,NULL,NULL,NULL),(71,100004541,NULL,'2018-03-02 11:38:13','2018-03-02 11:38:13',NULL,15,1,2,NULL,1,NULL,10,'BOB',350,1,NULL,NULL,NULL),(72,100004541,NULL,'2018-03-02 11:39:57','2018-03-02 11:39:56',NULL,15,1,2,NULL,1,NULL,10,'BOB',340,1,NULL,NULL,NULL),(73,100004541,NULL,'2018-03-02 11:44:44','2018-03-02 11:44:44',NULL,15,1,2,NULL,1,NULL,10,'BOB',330,1,NULL,NULL,NULL),(74,100004541,NULL,'2018-03-02 11:48:30','2018-03-02 11:48:30',NULL,15,1,5,NULL,1,NULL,10,'BOB',320,1,NULL,NULL,NULL),(75,100004541,NULL,'2018-03-02 11:49:34','2018-03-02 11:49:34',NULL,15,1,5,NULL,1,NULL,10,'BOB',310,1,NULL,NULL,NULL),(76,100004541,NULL,'2018-03-02 11:49:55','2018-03-02 11:49:54',NULL,15,1,5,NULL,1,NULL,10,'BOB',300,1,NULL,NULL,NULL),(77,100004541,NULL,'2018-03-02 11:55:44','2018-03-02 11:55:50',NULL,15,1,2,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(78,100004541,NULL,'2018-03-02 12:06:25','2018-03-02 12:06:27',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(79,100004541,NULL,'2018-03-02 12:07:27','2018-03-02 12:07:28',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(80,100004541,NULL,'2018-03-02 12:10:12','2018-03-02 12:10:13',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(81,100004541,NULL,'2018-03-02 12:12:47','2018-03-02 12:12:48',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(82,100004541,NULL,'2018-03-02 12:13:55','2018-03-02 12:13:56',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(83,100004541,NULL,'2018-03-02 12:17:45','2018-03-02 12:17:59',NULL,15,1,4,NULL,1,NULL,10,'BOB',290,1,NULL,NULL,NULL),(84,100004541,NULL,'2018-03-02 12:19:47',NULL,'2018-03-02 00:19:48',15,1,5,NULL,1,NULL,300,'BOB',NULL,1,NULL,NULL,NULL),(85,100004541,NULL,'2018-03-02 12:21:24',NULL,NULL,15,1,3,NULL,1,NULL,300,'BOB',NULL,1,NULL,NULL,NULL),(86,100004541,NULL,'2018-03-02 12:23:55',NULL,NULL,15,1,3,NULL,1,NULL,5050,'BOB',NULL,1,NULL,NULL,NULL),(87,100004541,NULL,'2018-03-02 16:24:00','2018-03-02 16:23:59',NULL,6034401397183876052,4,2,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(88,100004541,NULL,'2018-03-02 16:24:29','2018-03-02 16:24:35',NULL,-992788545193596049,4,4,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(89,100004541,NULL,'2018-03-02 16:28:08','2018-03-02 16:31:16','2018-03-02 16:28:12',-3832412082937910289,4,4,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(90,100004541,NULL,'2018-03-02 16:32:07','2018-03-02 16:32:08',NULL,-4291313642385993680,4,4,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(91,100004541,NULL,'2018-03-02 16:33:45','2018-03-02 16:33:46',NULL,-2658897112104085517,4,4,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(92,100004541,NULL,'2018-03-02 16:38:18','2018-03-02 16:38:20',NULL,2938851784566944645,4,4,1,1,'pago prestamo',10,'BOB',490,4,NULL,NULL,NULL),(93,100004541,NULL,'2018-03-05 10:56:34','2018-03-05 10:56:43',NULL,-7305825355841804228,1,4,1,1,'prueba pago ',10,'BOB',490,4,NULL,NULL,NULL),(94,100004541,NULL,'2018-03-05 13:30:00',NULL,NULL,2476162712342511670,1,2,1,1,'prueba pago prestamo',44,'22',NULL,4,NULL,NULL,NULL),(95,100004541,NULL,'2018-03-05 13:30:18',NULL,NULL,3966299454762513590,1,2,1,1,'prueba pago prestamo',44,'22',NULL,4,NULL,NULL,NULL),(96,100004541,NULL,'2018-03-05 14:29:07','2018-03-05 14:29:14',NULL,1976121993088867198,1,4,1,1,'prueba pago prestamo',44,'22',402,15,NULL,NULL,NULL),(97,100004541,NULL,'2018-03-05 14:42:06',NULL,'2018-03-05 14:42:13',3009297382815120773,1,5,1,1,'prueba pago prestamo',44,'22',NULL,15,NULL,NULL,NULL),(98,100004541,NULL,'2018-03-05 14:45:39','2018-03-05 14:59:25',NULL,-2095941127471783604,1,2,1,1,'prueba pago prestamo',44,'22',226,15,NULL,NULL,NULL),(99,100004541,NULL,'2018-03-05 14:45:54',NULL,NULL,2050397248709898111,1,2,1,1,'prueba pago prestamo',44,'22',NULL,15,NULL,NULL,NULL),(100,100004541,NULL,'2018-03-05 14:49:37',NULL,'2018-03-05 14:52:28',1680879644149528337,1,5,1,1,'prueba pago prestamo',44,'22',NULL,15,NULL,NULL,NULL),(101,100004541,NULL,'2018-03-05 15:20:04',NULL,NULL,-4273220991654801070,1,2,1,1,'prueba pago prestamo',100,'22',NULL,15,NULL,NULL,NULL),(102,100004541,NULL,'2018-03-05 15:24:58',NULL,NULL,-3582558437081699159,1,1,1,1,'prueba pago prestamo',100,'22',NULL,15,NULL,NULL,NULL),(103,100004541,NULL,'2018-03-05 15:27:22',NULL,NULL,2696101120407081046,1,2,1,1,'prueba pago prestamo',100,'22',NULL,15,NULL,NULL,NULL),(104,100004541,NULL,'2018-03-05 15:31:00','2018-03-05 15:31:16','2018-03-05 15:32:34',15,1,5,NULL,1,NULL,10,'jj',16,1,NULL,NULL,NULL),(105,100004541,NULL,'2018-03-05 15:35:10',NULL,NULL,5406112663458928522,1,3,1,1,'prueba pago prestamo',100,'22',NULL,15,NULL,NULL,NULL),(106,100004541,NULL,'2018-03-05 15:36:43','2018-03-05 15:36:44','2018-03-05 15:36:54',-6177818063362984674,1,5,1,1,'prueba pago prestamo',100,'22',900,15,NULL,NULL,NULL),(107,100004541,NULL,'2018-03-05 15:38:33','2018-03-05 15:38:33','2018-03-05 15:38:45',8932098772679416457,1,5,1,1,'prueba pago prestamo',100,'22',800,15,NULL,NULL,NULL),(108,100004541,NULL,'2018-03-05 15:39:11','2018-03-05 15:39:14',NULL,822170387606539325,1,2,1,1,'prueba pago prestamo',50,'22',750,15,NULL,NULL,NULL),(109,100004541,NULL,'2018-03-05 15:42:44','2018-03-05 15:43:02',NULL,6195346074537242991,1,2,1,1,'prueba pago prestamo',50,'22',700,15,NULL,NULL,NULL),(110,100004541,NULL,'2018-03-05 15:45:43','2018-03-05 15:45:53',NULL,15,1,4,NULL,1,NULL,10,'jj',700,1,NULL,NULL,NULL),(111,100004541,NULL,'2018-03-05 16:11:36','2018-03-05 16:11:48',NULL,2840900694414097676,1,4,1,1,'oooo',10,'kk',700,17,NULL,NULL,NULL),(112,100004541,NULL,'2018-03-05 16:42:46','2018-03-05 16:42:45','2018-03-05 16:42:48',6962028033586600,1,5,1,1,'oooo',10,'kk',690,17,NULL,NULL,NULL),(113,100004541,NULL,'2018-03-05 16:42:46','2018-03-05 16:42:45','2018-03-05 16:42:48',6962028033586600,1,5,1,2,'oooo',10,'kk',1010,17,NULL,NULL,NULL),(114,666666,NULL,'2018-03-05 16:42:46','2018-03-05 16:42:45','2018-03-05 16:42:48',6962028033586600,1,5,1,3,'oooo',10,'kk',1010,15,NULL,NULL,NULL),(116,100004541,NULL,'2018-03-06 11:46:06','2018-03-06 11:46:21','2018-03-06 11:46:31',-6167499341498064343,1,5,1,1,'prueba con update en cuenta beneficiario',25,'BOB',665,17,NULL,NULL,NULL),(117,100004541,NULL,'2018-03-06 11:47:16','2018-03-06 11:47:16','2018-03-06 11:47:18',-2853738475783637796,1,5,1,1,'prueba con update en cuenta beneficiario',25,'BOB',640,17,NULL,NULL,NULL),(118,100004541,NULL,'2018-03-06 11:48:46','2018-03-06 11:48:46','2018-03-06 11:48:47',-3684362043259187371,1,5,1,1,'prueba con update en cuenta beneficiario',25,'BOB',615,17,NULL,NULL,NULL),(119,100004541,NULL,'2018-03-06 11:49:11','2018-03-06 11:49:10','2018-03-06 11:49:12',1975982372680701808,1,5,1,1,'prueba con update en cuenta beneficiario',25,'BOB',590,17,NULL,NULL,NULL),(120,100004541,NULL,'2018-03-06 11:51:06','2018-03-06 11:51:06',NULL,8155130487240846895,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',565,17,NULL,NULL,NULL),(121,100004541,NULL,'2018-03-06 11:51:49','2018-03-06 11:51:49',NULL,-1226865274820008881,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',540,17,NULL,NULL,NULL),(122,100004541,NULL,'2018-03-06 11:52:46','2018-03-06 11:52:46',NULL,8156296403526380457,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',515,17,NULL,NULL,NULL),(123,100004541,NULL,'2018-03-06 11:53:24','2018-03-06 11:53:24',NULL,4929899664660755698,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',490,17,NULL,NULL,NULL),(124,100004541,NULL,'2018-03-06 11:54:55','2018-03-06 11:54:55',NULL,-5786733477061347485,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',465,17,NULL,NULL,NULL),(126,100004541,NULL,'2018-03-06 11:57:45','2018-03-06 11:57:47',NULL,-8898154673951561085,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',440,17,NULL,NULL,NULL),(127,87654321,4,'2018-03-06 12:01:34','2018-03-06 12:01:33',NULL,-7358308697687140463,1,2,1,1,'prueba con update en cuenta beneficiario',25,'BOB',415,17,NULL,NULL,NULL),(128,87654321,4,'2018-03-06 12:27:53','2018-03-06 12:27:52','2018-03-06 00:29:07',-363954934228779445,1,5,1,1,'prueba con update en cuenta beneficiario',25,'BOB',390,17,NULL,NULL,NULL),(129,87654321,4,'2018-03-06 12:28:00',NULL,NULL,-363954934228779445,1,2,1,2,'prueba con update en cuenta beneficiario',25,'BOB',1035,17,NULL,NULL,NULL);
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
  `moneda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `cliente_id_fk0` (`cliente_id`),
  CONSTRAINT `cliente_id_fk0` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (100,100004540,'ahorro',1000,1,NULL),(101,100004541,'deposito',390,4,NULL),(102,100004542,'deposito',700,6,NULL),(103,100004543,'ahorro',50,6,NULL),(104,100004544,'ahorro',50,7,NULL),(105,100004545,'prestamo',0,4,NULL),(106,100004545,'prestamo',0,6,NULL),(108,666666,'credito',1035,4,NULL);
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

-- Dump completed on 2018-03-09 17:03:17
