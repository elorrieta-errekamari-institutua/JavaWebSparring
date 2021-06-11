CREATE DATABASE  IF NOT EXISTS `elorrieta` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `elorrieta`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: elorrieta
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (78,'P2A013'),(79,'P4A105'),(76,'P4A109'),(77,'Taller');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cualificacion` varchar(256) NOT NULL,
  `codigo_uc` varchar(45) NOT NULL,
  `competencia` varchar(256) NOT NULL,
  `codigo_aaff` varchar(45) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `horas_curso` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cursos_UNIQUE` (`nombre`,`codigo_aaff`,`codigo_uc`)
) ENGINE=InnoDB AUTO_INCREMENT=419 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (403,'FME032_2 MECANIZADO POR ARRANQUE DE VIRUTA','UC0089_2\nUC0091_2\nUC0090_2','Determinar los procesos de mecanizado por arranque de viruta\nPreparar máquinas y sistemas para proceder al mecanizado por arranque de viruta\nMecanizar los productos por arranque de viruta','FMEH0109','MECANIZADO POR ARRANQUE DE VIRUTA',540),(404,'AUTODESK INVENTOR I','','','FMEM001PO','AUTODESK INVENTOR I',60),(405,'NX10.0. DISEÑO MECANICO 3D','FMEE0033OH','','FMEE0033OH','NX10.0. DISEÑO MECANICO 3D',80),(406,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0887','Montaje y mantenimiento de instalaciones eléctricas de interior',90),(407,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0884','Montaje de instalaciones eléctricas de enlace en edificios',60),(408,'PROGRAMACIÓN Y MECANIZADO CON CNC HEIDENHAIN','FMEH0056OH','','FMEH0056OH','PROGRAMACIÓN Y MECANIZADO CON CNC HEIDENHAIN',80),(409,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0886','Prevención de riesgos laborales y medioambientales en montaje y mantenimiento de instal. eléctricas',30),(410,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0496','Corte y mecanizado de tuberías',60),(411,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0495','Trazado de desarrollo en tuberías',40),(412,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0494','Interpretación de planos en la fabricación de tuberías',50),(413,'PROGRAMACIÓN Y EJECUCIÓN EN TORNO CNC FANUC','FMEH0029HV','','FMEH0029HV','PROGRAMACIÓN Y EJECUCIÓN EN TORNO CNC FANUC',70),(414,'PROGRAMACIÓN CON LENGUAJES ORIENTADOS A OBJETOS Y BASES DE DATOS RELACIONALES','IFCD0112','','Parcial: MF0227_3','PROGRAMACIÓN CON LENGUAJES ORIENTADOS A OBJETOS Y BASES DE DATOS RELACIONALES',250),(415,'MONTAJE Y MANTENIMIENTO DE INSTALACIONES FRIGORÍFICAS','IMAR0108','','IMAR0108','MONTAJE Y MANTENIMIENTO DE INSTALACIONES FRIGORÍFICAS',420),(416,'PLANIFICACIÓN, GESTIÓN Y REALIZACIÓN DEL MANTENIMIENTO Y SUPERVISIÓN DEL MONTAJE INSTALAC FRIGOR','IMAR0309','','IMAR0309','PLANIFICACIÓN, GESTIÓN Y REALIZACIÓN DEL MANTENIMIENTO Y SUPERVISIÓN DEL MONTAJE INSTALAC FRIGOR',460),(417,'MECANIZADO POR ARRANQUE DE VIRUTA','FMEH0109','','FMEH0109','MECANIZADO POR ARRANQUE DE VIRUTA',540);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edicion`
--

DROP TABLE IF EXISTS `edicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edicion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo_lanbide` varchar(45) NOT NULL,
  `id_curso` int NOT NULL,
  `id_horario` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_lanbide_UNIQUE` (`codigo_lanbide`),
  KEY `id_curso_FK_idx` (`id_curso`),
  KEY `id_horario_FK_idx` (`id_horario`),
  CONSTRAINT `id_curso_FK` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `id_horario_FK` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicion`
--

LOCK TABLES `edicion` WRITE;
/*!40000 ALTER TABLE `edicion` DISABLE KEYS */;
INSERT INTO `edicion` VALUES (263,'20485154',403,317,'2020-12-11','2021-06-02'),(264,'OC20483858',404,318,'2020-11-26','2021-01-14'),(265,'OC20483857',405,319,'2021-03-08','2021-05-05'),(266,'OC20483827',406,320,'2021-09-23','2021-11-16'),(267,'OC21480168',407,321,'2021-03-09','2021-04-27'),(268,'OC21480160',408,322,'2021-11-15','2021-12-22'),(269,'OC21480159',409,323,'2021-05-10','2021-05-24'),(270,'OC21480157',410,324,'2021-05-24','2021-06-22'),(271,'OC21480156',411,325,'2021-05-03','2021-05-20'),(272,'OC21480155',412,326,'2021-03-22','2021-04-29'),(273,'OC21480153',413,327,'2021-05-06','2021-06-16'),(274,'21480155',414,328,'2021-04-13','2021-06-15'),(275,'21480150',415,329,'1900-04-06','2022-01-12'),(276,'21480147',416,330,'1900-04-11','2022-02-07'),(277,'21480146',417,331,'1900-04-13','2022-03-14'),(278,'18480251',409,332,'2021-05-10','2021-05-24');
/*!40000 ALTER TABLE `edicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edicion_aulas`
--

DROP TABLE IF EXISTS `edicion_aulas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edicion_aulas` (
  `id_aula` int NOT NULL,
  `id_edicion` int NOT NULL,
  KEY `id_aula_FK_idx` (`id_aula`),
  KEY `id_edicion_FK_idx` (`id_edicion`),
  CONSTRAINT `id_aula_FK` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `id_edicion_FK` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicion_aulas`
--

LOCK TABLES `edicion_aulas` WRITE;
/*!40000 ALTER TABLE `edicion_aulas` DISABLE KEYS */;
INSERT INTO `edicion_aulas` VALUES (76,263),(77,263),(78,264),(79,272);
/*!40000 ALTER TABLE `edicion_aulas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formador`
--

DROP TABLE IF EXISTS `formador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formador` (
  `id_participante` int NOT NULL,
  `id_edicion` int NOT NULL,
  `horas_impartidas` int NOT NULL,
  KEY `id_edicion_formador_FK_idx` (`id_edicion`),
  KEY `id_usuario_FK_idx` (`id_participante`),
  CONSTRAINT `id_edicion_formador_FK` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id`),
  CONSTRAINT `id_usuario_FK` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formador`
--

LOCK TABLES `formador` WRITE;
/*!40000 ALTER TABLE `formador` DISABLE KEYS */;
/*!40000 ALTER TABLE `formador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lunes_inicio` time DEFAULT NULL,
  `lunes_fin` time DEFAULT NULL,
  `martes_inicio` time DEFAULT NULL,
  `martes_fin` time DEFAULT NULL,
  `miercoles_inicio` time DEFAULT NULL,
  `miercoles_fin` time DEFAULT NULL,
  `jueves_inicio` time DEFAULT NULL,
  `jueves_fin` time DEFAULT NULL,
  `viernes_inicio` time DEFAULT NULL,
  `viernes_fin` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (317,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00'),(318,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00'),(319,'18:00:00','21:30:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00'),(320,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00'),(321,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00'),(322,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00'),(323,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00'),(324,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00'),(325,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00'),(326,'18:00:00','21:10:00','18:00:00','21:10:00','18:00:00','21:10:00','18:00:00','21:10:00','00:00:00','00:00:00'),(327,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00'),(328,'08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00'),(329,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00'),(330,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00'),(331,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00'),(332,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `codigo_postal` int NOT NULL,
  `municipio` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `erte` tinyint NOT NULL,
  `situacion_laboral` enum('Desempleado','En activo') NOT NULL,
  `situacion_administrativa` enum('Alta','Baja') NOT NULL,
  `titulacion` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (28,'JONANDER GONZA JITXO','30695460M','637737111','1977-03-29','CL NAVARRO VILLOSLADA 13   3 IZ',48015,'BILBAO','BIZKAIA',0,'Desempleado','Alta','DIPLOMATURA en turismo'),(29,'ROBER NEGRO BENGANITO','22756709A','691061777','1994-10-30','AV DE LA LIBERTAD 34   5 B',48901,'BARAKALDO','BIZKAIA',0,'Desempleado','Baja','BACHILLER cualquier especialidad'),(37,'SERGIO MANZANA CAMARERO','45893200N','664663333','1996-09-01','PZ CIUDAD DE LA HABANA 4   3 D',48510,'VALLE DE TRAPAGA-TRAPAGARAN','BIZKAIA',0,'Desempleado','Alta','GRADO en Relaciones Internacionales\nBACHILLER cualquier especialidad'),(39,'MIKEL OJANGUREN ZAMACONA','22737917W','620665266','1977-11-14','GR LOIZAGA 0005   7 B',48903,'BARAKALDO','BIZKAIA',0,'Desempleado','Alta','BACHILLER cualquier especialidad'),(40,'UNAI PEINE CALVO','16075263B','679565555','1981-09-12','CL TELLETXE 1C   1 IZ',48990,'GETXO','BIZKAIA',0,'Desempleado','Alta','TÉCNICO SUPERIOR en Automatización y Robótica Industrial'),(41,'IBON JUANTOMAS GARCIA','78927833K','637757777','1986-08-21','CL JUAN DE GARDEAZABAL 0001  D 11 A',48004,'BILBAO','BIZKAIA',0,'Desempleado','Alta','TÉCNICO en Sistemas Microinformáticos y Redes\nGraduado en ESO'),(42,'IKER ZABALA EGINO','16076926H','664850111','1981-03-01','CL IBAIBIDE 0011    ',48930,'GETXO','BIZKAIA',0,'Desempleado','Alta','INGENIERO TÉCNICO en informática de gestión'),(43,'IVAN DOLORES FUERTES','79182409X','659520555','1999-01-14','CL LLANO 71   02 IZ',48903,'BARAKALDO','BIZKAIA',0,'Desempleado','Baja','Graduado en ESO\nTÉCNICO en Instalaciones Eléctricas y Automáticas'),(44,'JULEN SANCHO ASCUAS','78938427N','653704222','1988-06-04','CL MITXELENA 1   4 C',48950,'ERANDIO','BIZKAIA',0,'Desempleado','Alta',''),(45,'RAUL VITORIA LADRILLO','22757127F','672613000','1990-11-11','CL LARREA 0001   3 A',48901,'BARAKALDO','BIZKAIA',0,'Desempleado','Alta','');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante_edicion`
--

DROP TABLE IF EXISTS `participante_edicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante_edicion` (
  `id_participante` int NOT NULL,
  `id_edicion` int NOT NULL,
  KEY `id_participante_FK_idx` (`id_participante`),
  KEY `id_edicion_FK_idx` (`id_edicion`),
  CONSTRAINT `id_edicion_particioante_FK` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id`),
  CONSTRAINT `id_participante_FK` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante_edicion`
--

LOCK TABLES `participante_edicion` WRITE;
/*!40000 ALTER TABLE `participante_edicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `participante_edicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Admin'),(3,'Formador'),(4,'Participante'),(2,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `pass` varchar(128) NOT NULL,
  `email` varchar(45) NOT NULL,
  `avatar` blob,
  `rol_usuario` int NOT NULL,
  `particpante` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `participante_FK_idx` (`particpante`),
  KEY `rol_usuario_FK_idx` (`rol_usuario`),
  CONSTRAINT `participante_FK` FOREIGN KEY (`particpante`) REFERENCES `participante` (`id`),
  CONSTRAINT `rol_usuario_FK` FOREIGN KEY (`rol_usuario`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (14,'admin','21232f297a57a5a743894a0e4a801fc3','admin@admin.com',NULL,1,NULL),(15,'user','ee11cbb19052e40b07aac0ca060c23ee','user@user.com',NULL,2,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_ediciones`
--

DROP TABLE IF EXISTS `v_ediciones`;
/*!50001 DROP VIEW IF EXISTS `v_ediciones`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_ediciones` AS SELECT 
 1 AS `id_edicion`,
 1 AS `codigo_lanbide`,
 1 AS `id_curso`,
 1 AS `cualificacion`,
 1 AS `codigo_uc`,
 1 AS `competencia`,
 1 AS `codigo_aaff`,
 1 AS `nombre_curso`,
 1 AS `horas_curso`,
 1 AS `id_horario`,
 1 AS `lunes_inicio`,
 1 AS `lunes_fin`,
 1 AS `martes_inicio`,
 1 AS `martes_fin`,
 1 AS `miercoles_inicio`,
 1 AS `miercoles_fin`,
 1 AS `jueves_inicio`,
 1 AS `jueves_fin`,
 1 AS `viernes_inicio`,
 1 AS `viernes_fin`,
 1 AS `fecha_inicio`,
 1 AS `fecha_fin`,
 1 AS `id_aula`,
 1 AS `nombre_aula`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_ediciones`
--

/*!50001 DROP VIEW IF EXISTS `v_ediciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_ediciones` AS select `e`.`id` AS `id_edicion`,`e`.`codigo_lanbide` AS `codigo_lanbide`,`e`.`id_curso` AS `id_curso`,`c`.`cualificacion` AS `cualificacion`,`c`.`codigo_uc` AS `codigo_uc`,`c`.`competencia` AS `competencia`,`c`.`codigo_aaff` AS `codigo_aaff`,`c`.`nombre` AS `nombre_curso`,`c`.`horas_curso` AS `horas_curso`,`e`.`id_horario` AS `id_horario`,`h`.`lunes_inicio` AS `lunes_inicio`,`h`.`lunes_fin` AS `lunes_fin`,`h`.`martes_inicio` AS `martes_inicio`,`h`.`martes_fin` AS `martes_fin`,`h`.`miercoles_inicio` AS `miercoles_inicio`,`h`.`miercoles_fin` AS `miercoles_fin`,`h`.`jueves_inicio` AS `jueves_inicio`,`h`.`jueves_fin` AS `jueves_fin`,`h`.`viernes_inicio` AS `viernes_inicio`,`h`.`viernes_fin` AS `viernes_fin`,`e`.`fecha_inicio` AS `fecha_inicio`,`e`.`fecha_fin` AS `fecha_fin`,`ea`.`id_aula` AS `id_aula`,`a`.`nombre` AS `nombre_aula` from ((((`edicion` `e` join `curso` `c` on((`e`.`id_curso` = `c`.`id`))) join `horario` `h` on((`e`.`id_horario` = `h`.`id`))) left join `edicion_aulas` `ea` on((`e`.`id` = `ea`.`id_edicion`))) left join `aula` `a` on((`ea`.`id_aula` = `a`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-11  9:37:01
