-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: trip_management_sys
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=493 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (249,'Afghanistan'),(250,'Land Islands'),(251,'Albania'),(252,'Algeria'),(253,'American Samoa'),(254,'Andorra'),(255,'Angola'),(256,'Anguilla'),(257,'Antarctica'),(258,'Antigua and Barbuda'),(259,'Argentina'),(260,'Armenia'),(261,'Aruba'),(262,'Australia'),(263,'Austria'),(264,'Azerbaijan'),(265,'Bahamas'),(266,'Bahrain'),(267,'Bangladesh'),(268,'Barbados'),(269,'Belarus'),(270,'Belgium'),(271,'Belize'),(272,'Benin'),(273,'Bermuda'),(274,'Bhutan'),(275,'Bolivia'),(276,'Bosnia and Herzegovina'),(277,'Botswana'),(278,'Bouvet Island'),(279,'Brazil'),(280,'British Indian Ocean Territory'),(281,'Brunei Darussalam'),(282,'Bulgaria'),(283,'Burkina Faso'),(284,'Burundi'),(285,'Cambodia'),(286,'Cameroon'),(287,'Canada'),(288,'Cape Verde'),(289,'Cayman Islands'),(290,'Central African Republic'),(291,'Chad'),(292,'Chile'),(293,'China'),(294,'Christmas Island'),(295,'Cocos (Keeling) Islands'),(296,'Colombia'),(297,'Comoros'),(298,'Congo'),(299,'Congo, The Democratic Republic of the'),(300,'Cook Islands'),(301,'Costa Rica'),(302,'Cote D\'Ivoire'),(303,'Croatia'),(304,'Cuba'),(305,'Cyprus'),(306,'Czech Republic'),(307,'Denmark'),(308,'Djibouti'),(309,'Dominica'),(310,'Dominican Republic'),(311,'Ecuador'),(312,'Egypt'),(313,'El Salvador'),(314,'Equatorial Guinea'),(315,'Eritrea'),(316,'Estonia'),(317,'Ethiopia'),(318,'Falkland Islands (Malvinas)'),(319,'Faroe Islands'),(320,'Fiji'),(321,'Finland'),(322,'France'),(323,'French Guiana'),(324,'French Polynesia'),(325,'French Southern Territories'),(326,'Gabon'),(327,'Gambia'),(328,'Georgia'),(329,'Germany'),(330,'Ghana'),(331,'Gibraltar'),(332,'Greece'),(333,'Greenland'),(334,'Grenada'),(335,'Guadeloupe'),(336,'Guam'),(337,'Guatemala'),(338,'Guernsey'),(339,'Guinea'),(340,'Guinea-Bissau'),(341,'Guyana'),(342,'Haiti'),(343,'Heard Island and Mcdonald Islands'),(344,'Holy See (Vatican City State)'),(345,'Honduras'),(346,'Hong Kong'),(347,'Hungary'),(348,'Iceland'),(349,'India'),(350,'Indonesia'),(351,'Iran, Islamic Republic Of'),(352,'Iraq'),(353,'Ireland'),(354,'Isle of Man'),(355,'Israel'),(356,'Italy'),(357,'Jamaica'),(358,'Japan'),(359,'Jersey'),(360,'Jordan'),(361,'Kazakhstan'),(362,'Kenya'),(363,'Kiribati'),(364,'Korea, Democratic People\'s Republic of'),(365,'Korea, Republic of'),(366,'Kuwait'),(367,'Kyrgyzstan'),(368,'Lao People\'s Democratic Republic'),(369,'Latvia'),(370,'Lebanon'),(371,'Lesotho'),(372,'Liberia'),(373,'Libyan Arab Jamahiriya'),(374,'Liechtenstein'),(375,'Lithuania'),(376,'Luxembourg'),(377,'Macao'),(378,'Macedonia, The Former Yugoslav Republic of'),(379,'Madagascar'),(380,'Malawi'),(381,'Malaysia'),(382,'Maldives'),(383,'Mali'),(384,'Malta'),(385,'Marshall Islands'),(386,'Martinique'),(387,'Mauritania'),(388,'Mauritius'),(389,'Mayotte'),(390,'Mexico'),(391,'Micronesia, Federated States of'),(392,'Moldova, Republic of'),(393,'Monaco'),(394,'Mongolia'),(395,'Montenegro'),(396,'Montserrat'),(397,'Morocco'),(398,'Mozambique'),(399,'Myanmar'),(400,'Namibia'),(401,'Nauru'),(402,'Nepal'),(403,'Netherlands'),(404,'Netherlands Antilles'),(405,'New Caledonia'),(406,'New Zealand'),(407,'Nicaragua'),(408,'Niger'),(409,'Nigeria'),(410,'Niue'),(411,'Norfolk Island'),(412,'Northern Mariana Islands'),(413,'Norway'),(414,'Oman'),(415,'Pakistan'),(416,'Palau'),(417,'Palestinian Territory, Occupied'),(418,'Panama'),(419,'Papua New Guinea'),(420,'Paraguay'),(421,'Peru'),(422,'Philippines'),(423,'Pitcairn'),(424,'Poland'),(425,'Portugal'),(426,'Puerto Rico'),(427,'Qatar'),(428,'Reunion'),(429,'Romania'),(430,'Russian Federation'),(431,'RWANDA'),(432,'Saint Helena'),(433,'Saint Kitts and Nevis'),(434,'Saint Lucia'),(435,'Saint Pierre and Miquelon'),(436,'Saint Vincent and the Grenadines'),(437,'Samoa'),(438,'San Marino'),(439,'Sao Tome and Principe'),(440,'Saudi Arabia'),(441,'Senegal'),(442,'Serbia'),(443,'Seychelles'),(444,'Sierra Leone'),(445,'Singapore'),(446,'Slovakia'),(447,'Slovenia'),(448,'Solomon Islands'),(449,'Somalia'),(450,'South Africa'),(451,'South Georgia and the South Sandwich Islands'),(452,'Spain'),(453,'Sri Lanka'),(454,'Sudan'),(455,'Suriname'),(456,'Svalbard and Jan Mayen'),(457,'Swaziland'),(458,'Sweden'),(459,'Switzerland'),(460,'Syrian Arab Republic'),(461,'Taiwan, Province of China'),(462,'Tajikistan'),(463,'Tanzania, United Republic of'),(464,'Thailand'),(465,'Timor-Leste'),(466,'Togo'),(467,'Tokelau'),(468,'Tonga'),(469,'Trinidad and Tobago'),(470,'Tunisia'),(471,'Turkey'),(472,'Turkmenistan'),(473,'Turks and Caicos Islands'),(474,'Tuvalu'),(475,'Uganda'),(476,'Ukraine'),(477,'United Arab Emirates'),(478,'United Kingdom'),(479,'United States'),(480,'United States Minor Outlying Islands'),(481,'Uruguay'),(482,'Uzbekistan'),(483,'Vanuatu'),(484,'Venezuela'),(485,'Viet Nam'),(486,'Virgin Islands, British'),(487,'Virgin Islands, U.S.'),(488,'Wallis and Futuna'),(489,'Western Sahara'),(490,'Yemen'),(491,'Zambia'),(492,'Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trip_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trip_id_idx` (`trip_id`),
  CONSTRAINT `fk_trip_id` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason_id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `from_country` int NOT NULL,
  `to_country` int NOT NULL,
  `departure` datetime NOT NULL,
  `arrival` datetime NOT NULL,
  `created_by` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reason_id_idx` (`reason_id`),
  KEY `fk_status_id_idx` (`status_id`),
  KEY `fk_created_by_idx` (`created_by`),
  KEY `fk_from_country_idx` (`from_country`),
  KEY `fk_to_country_idx` (`to_country`),
  CONSTRAINT `fk_created_by` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_from_country` FOREIGN KEY (`from_country`) REFERENCES `country` (`id`),
  CONSTRAINT `fk_reason_id` FOREIGN KEY (`reason_id`) REFERENCES `trip_reason` (`id`),
  CONSTRAINT `fk_status_id` FOREIGN KEY (`status_id`) REFERENCES `trip_status` (`id`),
  CONSTRAINT `fk_to_country` FOREIGN KEY (`to_country`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_reason`
--

DROP TABLE IF EXISTS `trip_reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_reason` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_reason`
--

LOCK TABLES `trip_reason` WRITE;
/*!40000 ALTER TABLE `trip_reason` DISABLE KEYS */;
INSERT INTO `trip_reason` VALUES (1,'Meeting'),(2,'Training'),(3,'Project'),(4,'Workshop'),(5,'Event'),(6,'Other');
/*!40000 ALTER TABLE `trip_reason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip_status`
--

DROP TABLE IF EXISTS `trip_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip_status`
--

LOCK TABLES `trip_status` WRITE;
/*!40000 ALTER TABLE `trip_status` DISABLE KEYS */;
INSERT INTO `trip_status` VALUES (1,'CREATED'),(2,'WAITING_FOR_APPROVAL'),(3,'APPROVED');
/*!40000 ALTER TABLE `trip_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_approved` bit(1) NOT NULL DEFAULT b'0',
  `is_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@gmail.com','$2a$10$LnHHvtLPL9RVGA2UuqAWQORAg9/2UajDn.736ArHPzP5F9vien5lW','2022-09-27 08:06:06','2022-09-27 18:34:34',_binary '',_binary ''),(2,'user1','user1@gmail.com','$2a$10$.sT6yeZyTXSNXxM1sTCHfuikK/2BYN8zqtXmXJD1YPX5x5YH35Ifu','2022-09-27 17:12:22','2022-09-27 18:34:34',_binary '\0',_binary ''),(3,'user2','user2@gmail.com','$2a$10$QgzbgNmZw8JCMHXja3jfpen3ReiZQ5axFBpr05EPcCMzM2o4Xt8Yu','2022-09-27 17:37:57','2022-09-27 18:34:34',_binary '\0',_binary ''),(4,'user3','user3@gmail.com','$2a$10$sL9OBOkcSUdXCz2bdwUKaeU8Wmmj6lFIehAXT2gFsvGRAtz7Bm3H2','2022-09-27 17:53:30','2022-09-27 18:34:34',_binary '\0',_binary ''),(5,'user4','user4@gmail.com','$2a$10$xmrWgImkaMEwJ1CJ1bfcQeqFmQZrwagUV4MxLeVUqglrMLIF1jy3m','2022-09-27 17:54:48','2022-09-27 18:34:34',_binary '\0',_binary ''),(6,'user5','user5@gmail.com','$2a$10$sShLvt9amB8GROk0CkVP4.UDXK7gHUlAOhSwmY90x.jThsyHZ36mG','2022-09-27 20:53:37','2022-09-27 20:53:37',_binary '\0',_binary ''),(7,'user6','user6@gmail.com','$2a$10$vOE74cvOUBDn.zcvmVLWd.7tTvvcYOl2KfiN3UVwOMy0mdLlTNSvO','2022-09-27 22:02:52','2022-09-27 22:02:52',_binary '\0',_binary ''),(8,'user7','user7@gmail.com','$2a$10$swSlN6gUW4FuWQy1c.it/O2MbE3NahbxdzXu0Q9jsUj9ILKWawsdy','2022-09-27 22:41:50','2022-09-28 00:57:45',_binary '\0',_binary '\0'),(9,'user8','user8@gmail.com','$2a$10$maMYgRP/6FeyqqpjHleAaeFyK7kXfYFqC.wiA7LTR1WSpgDN5Kyre','2022-09-28 00:53:23','2022-09-28 00:53:23',_binary '\0',_binary ''),(10,'user9','user9@gmail.com','$2a$10$q11eBgzfNyYgAoPxprI4J.hfTceF5GSNxCgUzkqvIBjymB8BIrEoW','2022-09-28 00:54:07','2022-09-28 00:54:07',_binary '\0',_binary ''),(11,'user10','user10@gmail.com','$2a$10$o4DyrPo.F5teK23Mx4XJwu5RxqdhBNn/g7Y6f8ICd4IaWOmR9FKvq','2022-09-28 00:54:31','2022-09-28 08:03:30',_binary '\0',_binary ''),(12,'user11','user11@gmail.com','$2a$10$CcblXgPPsnRCvBGa1L3uoeKXcYW6Rz1QaWxFsrc8AArgOKcl0ydnS','2022-09-28 08:38:12','2022-09-28 08:38:12',_binary '\0',_binary '');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role_id_idx` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(9,1),(10,1),(11,1),(12,1),(1,2),(8,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 10:41:35
