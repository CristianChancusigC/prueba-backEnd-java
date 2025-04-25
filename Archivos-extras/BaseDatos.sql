-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: cristian_java
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(255) NOT NULL,
  `estado` bit(1) NOT NULL,
  `persona_id` bigint NOT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `FKmc52upywn8gona2iiwwwphb92` (`persona_id`),
  CONSTRAINT `FKmc52upywn8gona2iiwwwphb92` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'123465',_binary '',1),(2,'987455',_binary '',2),(3,'1234',_binary '',3),(5,'5678',_binary '',5),(6,'1245',_binary '',6),(7,'654321',_binary '',7),(11,'123456',_binary '',11),(14,'456987',_binary '',14);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `cuenta_id` bigint NOT NULL AUTO_INCREMENT,
  `numero_cuenta` varchar(255) NOT NULL,
  `tipo_cuenta` varchar(255) NOT NULL,
  `saldo_inicial` double NOT NULL,
  `estado` bit(1) NOT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`cuenta_id`),
  UNIQUE KEY `numero_cuenta_UNIQUE` (`numero_cuenta`),
  KEY `FK4p224uogyy5hmxvn8fwa2jlug` (`cliente_id`),
  CONSTRAINT `FK4p224uogyy5hmxvn8fwa2jlug` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,'123123','ahorros',21,_binary '',1),(2,'456465','corriente',411,_binary '',2),(7,'478758','Ahorro',1460,_binary '',1),(11,'225487','Corriente',100,_binary '',2),(12,'11117','Ahorro',15,_binary '',1),(13,'22224','Corriente',25,_binary '',7),(14,'22226','Corriente',300,_binary '',7),(15,'33336','Corriente',3050,_binary '',5),(16,'4444','Corriente',1500,_binary '',14);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id_movimiento` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `tipo_movimiento` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  `saldo` double NOT NULL,
  `cuenta_id` bigint NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `FKof0364849tnpw8nw69v8m1vq4` (`cuenta_id`),
  CONSTRAINT `FKof0364849tnpw8nw69v8m1vq4` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`cuenta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'2024-04-04','ahorro',50,50,1),(2,'2024-12-12','corriente',100,200,2),(3,'2025-04-24','Ahorro',31,131,1),(4,'2025-04-24','Ahorro',-90,162,1),(5,'2025-04-24','Ahorro',-60,162,1),(6,'2025-04-24','Ahorro',-60,162,1),(7,'2025-04-24','Ahorro',-20,102,1),(8,'2025-04-24','Ahorro',-50,82,1),(9,'2025-04-24','Ahorro',-11,32,1),(10,'2025-04-24','Ahorro',-11,511,2),(11,'2025-04-24','Ahorro',-500,2000,7),(12,'2025-04-24','Ahorro',-100,1500,7),(13,'2025-04-24','Ahorro',50,1400,7),(14,'2025-04-24','Ahorro',-100,1350,7),(15,'2025-04-24','Ahorro',90,1440,7),(16,'2025-04-24','Ahorro',-40,1400,7),(17,'2025-04-24','Ahorro',-40,1360,7),(19,'2025-04-24','Ahorro',100,1460,7),(20,'2025-04-24','Ahorro',25,3075,15),(21,'2025-04-24','Ahorro',-25,3050,15);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `persona_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `identificacion` int NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Cristian','Hombre',26,789456,'Quito','098254785'),(2,'Dario','Hombre',22,123789,'Quito','456987'),(3,'Jose Lema','Mujer',19,789456,'Otavalo sn y principal','098254785'),(5,'Marianela Montalvo','Hombre',28,456123,'Amazonas y NNUU','097548965'),(6,'Juan Osorio','Hombre',33,789789,'13 junio y Equinoccial','098874587'),(7,'Lucia Perez','Mujer',25,654987,'Quito','0988774455'),(11,'Test Cliente','Hombre',27,546789132,'Quito','098765432'),(14,'Karina Casa','Mujer',28,784512,'Sangolqui','098523654');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-25  3:57:21
