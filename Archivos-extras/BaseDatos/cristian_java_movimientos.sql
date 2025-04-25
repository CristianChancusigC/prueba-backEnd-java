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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-25  3:50:24
