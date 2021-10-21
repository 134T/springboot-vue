-- MySQL dump 10.13  Distrib 5.7.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travels
-- ------------------------------------------------------
-- Server version	5.7.32

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
-- Table structure for table `attractions`
--

DROP TABLE IF EXISTS `attractions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attractions` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `picpath` varchar(80) DEFAULT NULL,
  `hottime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hotticket` double(7,2) DEFAULT NULL,
  `dimticket` double(7,2) DEFAULT NULL,
  `placedes` varchar(300) DEFAULT NULL,
  `proviceid` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `proviceid` (`proviceid`),
  CONSTRAINT `attractions_ibfk_1` FOREIGN KEY (`proviceid`) REFERENCES `provice` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attractions`
--

LOCK TABLES `attractions` WRITE;
/*!40000 ALTER TABLE `attractions` DISABLE KEYS */;
INSERT INTO `attractions` (`id`, `name`, `picpath`, `hottime`, `hotticket`, `dimticket`, `placedes`, `proviceid`) VALUES (1,'天安门','tianam.jpg','2021-10-10 07:51:32',500.00,300.00,'天安门，坐落在中华人民共和国首都北京市的中心、故宫的南端，与天安门广场以及人民英雄纪念碑、毛主席纪念堂、人民大会堂、中国国家博物馆隔长安街相望，占地面积4800平方米，以杰出的建筑艺术和特殊的政治地位为世人所瞩目。',1),(5,'明十三陵','ming.jpg','2021-10-11 05:08:03',1230.00,12.00,'十三陵是明朝十三代皇帝及皇后之陵墓的简称',1),(6,'北京奥林匹克公园','39510.jpg','2020-11-10 08:00:00',233.00,22.00,'北京奥林匹克公园位于北京市朝阳区，地处北京城中轴线北端，北至清河南岸，南至北土城路，东至安立路和北辰东路',1),(7,'八达岭长城','2186.jpg','2021-10-04 08:00:00',33333.00,1233.00,'八达岭长城座落于北京市延庆区境内，蜿蜒腾跃于燕山山脉的崇山峻岭，是万里长城千百座名关险隘中，历史最为悠久',1),(8,'清明上河园','2313.jpg','2021-09-28 08:00:00',1223.00,22.00,' 《清明上河图》是著名画家张择端杰作。画中的主题是北宋时期东京汴河两岸及城内外的民俗风情。一部《东京梦华录》和一幅《清明上河图》可以互相印证，被称为了解北宋东京（开封）的钥匙。',3),(9,'嵩山少林景区','2306.jpg','2021-10-04 08:00:00',1223.00,222.00,'嵩山位于河南省登封县境内，地处中原，故称中岳，分太室、少室二山，各36峰，主峰海拔1492米。',3),(11,'八里沟景区','7a8a.jpg','2021-10-11 08:04:17',1233.00,333.00,'里沟景区位于河南省新乡市西北50公里处，总面积28平公里，属典型的南太行风光，是国家级4A级景区、国家地质公园、自然猕猴保护区、河南省著名风景区、河南省十佳景区。',3),(13,'新安龙潭大峡谷','2305.jpg','2021-10-05 08:00:00',1233.00,333.00,'龙潭大峡谷景区位于洛阳市新安县北部,距洛阳60公里,郑州180公里,连霍高速、310国道、陇海铁路横穿县境,位置优越,交通便利。',3),(18,'北京世园会','0hsadh.jpg','2021-10-05 08:00:00',12333.00,333.00,'2019年中国北京世界园艺博览会（简称2019北京世园会或北京世园会），是经国际园艺生产者协会批准，由中国政府主办、北京市承办的最高级别的世界园艺博览会，',1);
/*!40000 ALTER TABLE `attractions` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `provice`
--

DROP TABLE IF EXISTS `provice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `tags` varchar(50) DEFAULT NULL,
  `placecounts` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provice`
--

LOCK TABLES `provice` WRITE;
/*!40000 ALTER TABLE `provice` DISABLE KEYS */;
INSERT INTO `provice` (`id`, `name`, `tags`, `placecounts`) VALUES (1,'北京市','首都、天安门',20),(2,'山东省','啤酒节、风筝节',8),(3,'河南省','唐三彩、少林寺，嵩山',14),(4,'辽宁省','沈阳故宫、玄贞观',11),(6,'江西省','井冈山，庐山，东山',18),(9,'江苏省','西湖',12);
/*!40000 ALTER TABLE `provice` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES (1,'孙2','123','33748488@qq.com'),(2,'孙2','13','234556@qq.com'),(3,'12','12','12334@qq.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-21 20:31:55
