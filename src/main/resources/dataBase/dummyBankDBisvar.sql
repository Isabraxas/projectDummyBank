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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Beneficiario`
--

LOCK TABLES `Beneficiario` WRITE;
/*!40000 ALTER TABLE `Beneficiario` DISABLE KEYS */;
INSERT INTO `Beneficiario` VALUES (1,'Mario Ramos','3652789',78945612,200,'BOB','Viridian'),(3,'Adriana Velisar','54684',54698,112,'BSF','Viridian');
/*!40000 ALTER TABLE `Beneficiario` ENABLE KEYS */;
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
INSERT INTO `Operador` VALUES (2,'marcelo',7),(3,'isvar',10);
/*!40000 ALTER TABLE `Operador` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transaccion`
--

LOCK TABLES `Transaccion` WRITE;
/*!40000 ALTER TABLE `Transaccion` DISABLE KEYS */;
INSERT INTO `Transaccion` VALUES (1,12345678,'1970-01-01 00:00:01','1970-01-01 00:00:01','1970-01-01 00:00:01',1,1,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(2,12345678,'1972-01-01 00:00:01','1973-01-01 00:00:01','1974-01-01 00:00:01',1,3,1,1,1,'transferencia pago curso',100,'USD',500,1,1,1,1),(6,12345679,'2015-10-21 00:00:00','1970-01-01 00:16:41','1970-01-01 00:16:41',1,1,1,1,1,'transferencia pago curso',100,'BOB',500,1,1,1,1),(7,12345677,'1972-01-01 00:00:01','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(8,12345677,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(9,12345677,'2018-02-26 12:21:08','1972-01-01 00:00:01','1972-01-01 00:00:01',2,1,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(10,12345673,'1985-01-01 00:00:01','0002-11-30 00:00:00','1989-01-01 00:00:01',2,2,2,2,2,'prueba nuevo',20,'USD',300,1,2,2,2),(13,124235,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,2,1,'transferencia pago curso',33,'BOB',4444,1,1,1,1),(14,22,'2018-02-26 12:22:03','1972-01-01 00:00:01','1972-01-01 00:00:01',1,1,1,1,1,'transferencia pago curso',50,'USD',70,1,1,1,1),(21,12345678,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(22,12345678,'2018-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(23,12345678,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(24,12345679,'2017-01-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(25,12345678,'2018-01-10 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(26,12345678,'2018-02-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(27,12345678,'2018-02-12 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(28,12345678,'2017-12-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(29,12345678,'2017-12-01 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(30,12345678,'2017-11-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(31,12345678,'2017-01-05 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(32,12345678,'2017-10-28 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1),(33,12345678,'2017-11-22 04:02:00','2019-02-23 04:02:26','2015-02-23 04:02:26',1,1,1,1,1,'no se',100,'BOB',500,1,1,1,1);
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
  `cliente_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,12345678,'ahorro',500,NULL),(2,12345679,'corriente',1000,NULL),(3,12345677,'ahorro',600,NULL);
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

-- Dump completed on 2018-02-26 15:50:45
