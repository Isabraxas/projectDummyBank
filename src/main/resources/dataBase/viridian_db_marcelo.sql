-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: viridian_db
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

-- Dump completed on 2018-02-26 15:50:43
