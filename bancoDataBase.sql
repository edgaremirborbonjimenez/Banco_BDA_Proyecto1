-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidoP` varchar(20) NOT NULL,
  `apellidoM` varchar(20) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `celular` varchar(10) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `idDireccion` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `celular_UNIQUE` (`celular`),
  KEY `idDireccion` (`idDireccion`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`idDireccion`) REFERENCES `direcciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (3,'Emir','Borbon','','2003-10-02','6421068907','123',1),(5,'Daniel Armando','Peña','García','3902-12-10','6441942558','25695Qfo',3),(6,'Alejandro','Emir','Minjarez','3901-02-01','1234567891','2345',4);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `INSERTAR_CUENTA` AFTER INSERT ON `clientes` FOR EACH ROW BEGIN
INSERT INTO CUENTAs(NUMCUENTA, FECHAAPERTURA, SALDO, IDCLIENTE)
VALUES((CAST((RAND()*10000000000) AS SIGNED)), CURRENT_DATE(), 0.00, NEW.ID);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numCuenta` varchar(40) DEFAULT (cast((rand() * 10000000000) as signed)),
  `fechaApertura` date DEFAULT (curdate()),
  `saldo` decimal(13,2) DEFAULT (0.0),
  `idCliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (14,'edf01606-afdb-11ed-8ad0-141877c424a4','2023-02-18',416.00,3),(15,'ee0eac5a-afdb-11ed-8ad0-141877c424a4','2023-02-18',800.00,4),(16,'9122025398','2023-02-21',384.00,2),(17,'9082813495','2023-02-21',0.00,6);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(20) NOT NULL,
  `colonia` varchar(20) NOT NULL,
  `numeroExterior` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (2,'Heriberto aja','Indeur','#30'),(3,'Jardines','Casa Blanca','2906'),(4,'Mi','Casa','0001');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retiros`
--

DROP TABLE IF EXISTS `retiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retiros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCuenta` int NOT NULL,
  `monto` decimal(13,2) NOT NULL,
  `fecha` datetime DEFAULT (curtime()),
  `folio` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `disponible` enum('pendiente','cancelado','retirado') NOT NULL,
  `fechaRetirado` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCuenta` (`idCuenta`),
  CONSTRAINT `retiros_ibfk_1` FOREIGN KEY (`idCuenta`) REFERENCES `cuentas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retiros`
--

LOCK TABLES `retiros` WRITE;
/*!40000 ALTER TABLE `retiros` DISABLE KEYS */;
INSERT INTO `retiros` VALUES (2,15,200.00,'2023-02-18 15:31:04','817268635','564654','retirado',NULL),(3,15,200.00,'2023-02-20 21:28:37','654654','654654','retirado','2023-02-20 21:30:05'),(4,14,50.00,'2023-02-21 00:36:13','443402582','234567','pendiente',NULL),(5,14,50.00,'2023-02-21 00:37:14','278759778','qqqqq','pendiente',NULL),(6,14,50.00,'2023-02-21 00:37:54','912392580','Aq1%$','pendiente',NULL);
/*!40000 ALTER TABLE `retiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencias`
--

DROP TABLE IF EXISTS `transferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferencias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCuentaUsuario` int NOT NULL,
  `idCuentaDestino` int NOT NULL,
  `monto` decimal(13,2) NOT NULL,
  `fecha` datetime DEFAULT (curtime()),
  PRIMARY KEY (`id`),
  KEY `idCuentaUsuario` (`idCuentaUsuario`),
  KEY `idCuentaDestino` (`idCuentaDestino`),
  CONSTRAINT `transferencias_ibfk_1` FOREIGN KEY (`idCuentaUsuario`) REFERENCES `cuentas` (`id`),
  CONSTRAINT `transferencias_ibfk_2` FOREIGN KEY (`idCuentaDestino`) REFERENCES `cuentas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencias`
--

LOCK TABLES `transferencias` WRITE;
/*!40000 ALTER TABLE `transferencias` DISABLE KEYS */;
INSERT INTO `transferencias` VALUES (5,14,15,400.00,'2023-02-18 15:31:04'),(6,14,16,50.00,'2023-02-21 00:16:04'),(7,14,16,50.00,'2023-02-21 00:18:34'),(8,14,16,100.00,'2023-02-21 00:21:52'),(9,14,16,100.00,'2023-02-21 00:22:00'),(10,14,16,54.00,'2023-02-21 00:41:18'),(11,14,16,30.00,'2023-02-21 00:49:24');
/*!40000 ALTER TABLE `transferencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'banco'
--

--
-- Dumping routines for database 'banco'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-21  3:09:00
