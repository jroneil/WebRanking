-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ranks
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `ranks`
--

DROP TABLE IF EXISTS `ranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ranks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rec_date` datetime DEFAULT NULL,
  `website` varchar(100) NOT NULL,
  `visits` int(11) DEFAULT NULL,
  `recDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranks`
--

LOCK TABLES `ranks` WRITE;
/*!40000 ALTER TABLE `ranks` DISABLE KEYS */;
INSERT INTO `ranks` VALUES (1,'2016-01-06 00:00:00','www.bing.com',14065457,NULL),(2,'2016-01-06 00:00:00','www.ebay.com.au',19831166,NULL),(3,'2016-01-06 00:00:00','www.facebook.com',104346720,NULL),(4,'2016-01-06 00:00:00','mail.live.com',21536612,NULL),(5,'2016-01-06 00:00:00','www.wikipedia.org',13246531,NULL),(6,'2016-01-27 00:00:00','www.ebay.com.au',23154653,NULL),(7,'2016-01-06 00:00:00','au.yahoo.com',11492756,NULL),(8,'2016-01-06 00:00:00','www.google.com',26165099,NULL),(9,'2016-01-13 00:00:00','www.youtube.com',68487810,NULL),(10,'2016-01-27 00:00:00','www.wikipedia.org',16550230,NULL),(11,'2016-01-06 00:00:00','ninemsn.com.au',21734381,NULL),(12,'2016-01-20 00:00:00','mail.live.com',24344783,NULL),(13,'2016-01-20 00:00:00','www.ebay.com.au',22598506,NULL),(14,'2016-01-27 00:00:00','mail.live.com',24272437,NULL),(15,'2016-01-27 00:00:00','www.bing.com',16041776,NULL),(16,'2016-01-20 00:00:00','ninemsn.com.au',24241574,NULL),(17,'2016-01-20 00:00:00','www.facebook.com',118984483,NULL),(18,'2016-01-27 00:00:00','ninemsn.com.au',24521168,NULL),(19,'2016-01-27 00:00:00','www.facebook.com',123831275,NULL),(20,'2016-01-20 00:00:00','www.bing.com',16595739,NULL),(21,'2016-01-13 00:00:00','www.facebook.com',118506019,NULL),(22,'2016-01-20 00:00:00','www.google.com.au',170020924,NULL),(23,'2016-01-27 00:00:00','www.youtube.com',69327140,NULL),(24,'2016-01-13 00:00:00','mail.live.com',24772355,NULL),(25,'2016-01-13 00:00:00','ninemsn.com.au',24555033,NULL),(26,'2016-01-20 00:00:00','www.google.com',28996455,NULL),(27,'2016-01-13 00:00:00','www.bing.com',16618315,NULL),(28,'2016-01-27 00:00:00','www.google.com.au',171842376,NULL),(29,'2016-01-06 00:00:00','www.youtube.com',59811438,NULL),(30,'2016-01-13 00:00:00','www.netbank.commbank.com.au',13316233,NULL),(31,'2016-01-20 00:00:00','www.netbank.commbank.com.au',13072234,NULL),(32,'2016-01-13 00:00:00','www.ebay.com.au',22785028,NULL),(33,'2016-01-20 00:00:00','www.wikipedia.org',16519992,NULL),(34,'2016-01-27 00:00:00','www.bom.gov.au',14369775,NULL),(35,'2016-01-27 00:00:00','www.google.com',29422150,NULL),(36,'2016-01-20 00:00:00','www.youtube.com',69064107,NULL),(37,'2016-01-06 00:00:00','www.google.com.au',151749278,NULL),(38,'2016-01-13 00:00:00','www.wikipedia.org',16015926,NULL),(39,'2016-01-13 00:00:00','www.google.com',29203671,NULL),(40,'2016-01-13 00:00:00','www.google.com.au',172220397,NULL);
/*!40000 ALTER TABLE `ranks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-05 19:38:11
