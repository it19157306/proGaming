CREATE DATABASE  IF NOT EXISTS `progaming` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `progaming`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: progaming
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `game_category`
--

DROP TABLE IF EXISTS `game_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_category` (
  `gID` int NOT NULL,
  `cat_id` int NOT NULL,
  PRIMARY KEY (`gID`,`cat_id`),
  KEY `cat_id` (`cat_id`),
  CONSTRAINT `game_category_ibfk_1` FOREIGN KEY (`gID`) REFERENCES `game` (`gID`) ON DELETE CASCADE,
  CONSTRAINT `game_category_ibfk_2` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_category`
--

LOCK TABLES `game_category` WRITE;
/*!40000 ALTER TABLE `game_category` DISABLE KEYS */;
INSERT INTO `game_category` VALUES (1,1),(2,1),(3,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(1,2),(5,2),(8,2),(12,2),(15,2),(17,2),(18,2),(22,2),(26,2),(28,2),(38,2),(41,2),(42,2),(52,2),(53,2),(2,3),(4,3),(14,3),(1,4),(3,4),(13,4),(15,4),(42,4),(51,4),(6,5),(35,5),(36,5),(48,5),(7,6),(40,6),(9,7),(21,7),(25,7),(26,7),(44,7),(45,7),(50,7),(10,8),(31,8),(11,9),(12,9),(16,9),(18,9),(20,9),(52,9),(17,10),(18,11),(19,12),(23,13),(24,14),(29,15),(32,15),(34,15),(37,15),(39,15),(45,15),(47,15),(49,15),(54,15),(30,16),(33,16),(42,16),(46,16),(49,16),(51,16),(43,17),(1,18),(20,18),(26,18),(27,18),(49,18),(50,18),(51,18),(53,18),(54,18),(1,19),(2,19),(10,19),(11,19),(12,19),(20,19),(22,19),(23,19),(24,19),(28,19),(34,19),(40,19),(41,19),(42,19),(43,19),(44,19),(49,19),(51,19);
/*!40000 ALTER TABLE `game_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-14  6:08:16
