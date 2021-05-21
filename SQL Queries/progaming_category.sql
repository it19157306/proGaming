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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cat_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cat_icon` varchar(255) NOT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'All Games','<i class=\"fas fa-gamepad\"></i>'),(2,'Sports','<i class=\"fas fa-running\"></i>'),(3,'Puzzle','<i class=\"fas fa-puzzle-piece\"></i>'),(4,'Stunt','<i class=\"fas fa-snowboarding\"></i>'),(5,'Zombie','<i class=\"fas fa-angry\"></i>'),(6,'Platform','<i class=\"fas fa-ruler-horizontal\"></i>'),(7,'Shooting','<i class=\"fas fa-meteor\"></i>'),(8,'Destruction','<i class=\"fas fa-bomb\"></i>'),(9,'Multiplayer','<i class=\"fas fa-users\"></i>'),(10,'Golf','<i class=\"fas fa-golf-ball\"></i>'),(11,'Basketball','<i class=\"fas fa-basketball-ball\"></i>'),(12,'Political','<i class=\"fas fa-flag-usa\"></i>'),(13,'Flying','<i class=\"fas fa-plane\"></i>'),(14,'Halloween','<i class=\"fas fa-ghost\"></i>'),(15,'Action','<i class=\"fas fa-user-ninja\"></i>'),(16,'Racing','<i class=\"fas fa-car\"></i>'),(17,'Stratergy','<i class=\"fas fa-calculator\"></i>'),(18,'Featured Games','<i class=\"fas fa-feather-alt\"></i>'),(19,'Trending','<i class=\"fas fa-poll\"></i>');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-14  6:08:14
