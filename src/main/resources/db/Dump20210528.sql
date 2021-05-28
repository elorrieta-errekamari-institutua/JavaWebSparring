-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elorrieta
-- ------------------------------------------------------
-- Server version	8.0.24

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
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
  UNIQUE KEY `cursos_UNIQUE` (`horas_curso`,`nombre`,`codigo_aaff`,`codigo_uc`,`cualificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (103,'FME032_2 MECANIZADO POR ARRANQUE DE VIRUTA','UC0089_2\nUC0091_2\nUC0090_2','Determinar los procesos de mecanizado por arranque de viruta\nPreparar máquinas y sistemas para proceder al mecanizado por arranque de viruta\nMecanizar los productos por arranque de viruta','FMEH0109','MECANIZADO POR ARRANQUE DE VIRUTA',540),(104,'AUTODESK INVENTOR I','','','FMEM001PO','AUTODESK INVENTOR I',60),(105,'NX10.0. DISEÑO MECANICO 3D','FMEE0033OH','','FMEE0033OH','NX10.0. DISEÑO MECANICO 3D',80),(106,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0887','Montaje y mantenimiento de instalaciones eléctricas de interior',90),(107,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0884','Montaje de instalaciones eléctricas de enlace en edificios',60),(108,'PROGRAMACIÓN Y MECANIZADO CON CNC HEIDENHAIN','FMEH0056OH','','FMEH0056OH','PROGRAMACIÓN Y MECANIZADO CON CNC HEIDENHAIN',80),(109,'ELE257_2 MONTAJE Y MANTENIMIENTO DE INSTALACIONES ELÉCTRICAS DE BAJA TENSIÓN','ELEE0109','MF0821_2 Instalaciones eléctricas en edificios de oficinas, comercios e industrias ','UF0886','Prevención de riesgos laborales y medioambientales en montaje y mantenimiento de instal. eléctricas',30),(110,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0496','Corte y mecanizado de tuberías',60),(111,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0495','Trazado de desarrollo en tuberías',40),(112,'FME351_2 FABRICACIÓN Y MONTAJE DE INSTALACIONES DE TUBERÍA INDUSTRIAL','UC1142_2','Trazar y mecanizar tuberías','UF0494','Interpretación de planos en la fabricación de tuberías',50),(113,'PROGRAMACIÓN Y EJECUCIÓN EN TORNO CNC FANUC','FMEH0029HV','','FMEH0029HV','PROGRAMACIÓN Y EJECUCIÓN EN TORNO CNC FANUC',70),(114,'PROGRAMACIÓN CON LENGUAJES ORIENTADOS A OBJETOS Y BASES DE DATOS RELACIONALES','IFCD0112','','Parcial: MF0227_3','PROGRAMACIÓN CON LENGUAJES ORIENTADOS A OBJETOS Y BASES DE DATOS RELACIONALES',250),(115,'MONTAJE Y MANTENIMIENTO DE INSTALACIONES FRIGORÍFICAS','IMAR0108','','IMAR0108','MONTAJE Y MANTENIMIENTO DE INSTALACIONES FRIGORÍFICAS',420),(116,'PLANIFICACIÓN, GESTIÓN Y REALIZACIÓN DEL MANTENIMIENTO Y SUPERVISIÓN DEL MONTAJE INSTALAC FRIGOR','IMAR0309','','IMAR0309','PLANIFICACIÓN, GESTIÓN Y REALIZACIÓN DEL MANTENIMIENTO Y SUPERVISIÓN DEL MONTAJE INSTALAC FRIGOR',460),(117,'MECANIZADO POR ARRANQUE DE VIRUTA','FMEH0109','','FMEH0109','MECANIZADO POR ARRANQUE DE VIRUTA',540);
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicion`
--

LOCK TABLES `edicion` WRITE;
/*!40000 ALTER TABLE `edicion` DISABLE KEYS */;
INSERT INTO `edicion` VALUES (56,'20485154',103,73,'2020-12-11','2021-06-02'),(57,'OC20483858',104,74,'2020-11-26','2021-01-14'),(58,'OC20483857',105,75,'2021-03-08','2021-05-05'),(59,'OC20483827',106,76,'2021-09-23','2021-11-16'),(60,'OC21480168',107,77,'2021-03-09','2021-04-27'),(61,'OC21480160',108,78,'2021-11-15','2021-12-22'),(62,'OC21480159',109,79,'2021-05-10','2021-05-24'),(63,'OC21480157',110,80,'2021-05-24','2021-06-22'),(64,'OC21480156',111,81,'2021-05-03','2021-05-20'),(65,'OC21480155',112,82,'2021-03-22','2021-04-29'),(66,'OC21480153',113,83,'2021-05-06','2021-06-16'),(67,'21480155',114,84,'2021-04-13','2021-06-15'),(68,'21480150',115,85,'1900-04-06','2022-01-12'),(69,'21480147',116,86,'1900-04-11','2022-02-07'),(70,'21480146',117,87,'1900-04-13','2022-03-14'),(71,'18480251',109,88,'2021-05-10','2021-05-24');
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
  CONSTRAINT `id_aula_FK` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`),
  CONSTRAINT `id_edicion_FK` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicion_aulas`
--

LOCK TABLES `edicion_aulas` WRITE;
/*!40000 ALTER TABLE `edicion_aulas` DISABLE KEYS */;
/*!40000 ALTER TABLE `edicion_aulas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formador`
--

DROP TABLE IF EXISTS `formador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formador` (
  `id_usuario` int NOT NULL,
  `id_edicion` int NOT NULL,
  `horas_impartidas` int NOT NULL,
  KEY `id_usuario_FK_idx` (`id_usuario`),
  KEY `id_edicion_formador_FK_idx` (`id_edicion`),
  CONSTRAINT `id_edicion_formador_FK` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id`),
  CONSTRAINT `id_usuario_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
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
  `sabado_inicio` time DEFAULT NULL,
  `sabado_fin` time DEFAULT NULL,
  `domingo_inicio` time DEFAULT NULL,
  `domingo_fin` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (73,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(74,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(75,'18:00:00','21:30:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(76,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(77,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(78,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(79,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(80,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(81,'18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','18:00:00','21:30:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(82,'18:00:00','21:10:00','18:00:00','21:10:00','18:00:00','21:10:00','18:00:00','21:10:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(83,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(84,'08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00','08:30:00','14:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(85,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(86,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(87,'15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:30:00','21:30:00','15:00:00','18:00:00','00:00:00','00:00:00','00:00:00','00:00:00'),(88,'18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','18:00:00','21:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00','00:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (28,'JONANDER GONZA JITXO','30695460M','637737111','1977-03-29','CL NAVARRO VILLOSLADA 13   3 IZ',48015,'BILBAO','BIZKAIA',0,'Desempleado','Alta','DIPLOMATURA en turismo'),(29,'ROBER NEGRO BENGANITO','22756709A','691061777','1994-10-30','AV DE LA LIBERTAD 34   5 B',48901,'BARAKALDO','BIZKAIA',0,'Desempleado','Baja','BACHILLER cualquier especialidad'),(30,'MIKEL OJANGUREN ZAMACONA','22737917W','620665266','1977-11-14','GR LOIZAGA 0005   7 B',48903,'BARAKALDO','BIZKAIA',0,'Desempleado','Alta','BACHILLER cualquier especialidad'),(31,'UNAI PEINE CALVO','16075263B','679565555','1981-09-12','CL TELLETXE 1C   1 IZ',48990,'GETXO','BIZKAIA',0,'Desempleado','Alta','TÉCNICO SUPERIOR en Automatización y Robótica Industrial'),(32,'IBON JUANTOMAS GARCIA','78927833K','637757777','1986-08-21','CL JUAN DE GARDEAZABAL 0001  D 11 A',48004,'BILBAO','BIZKAIA',0,'Desempleado','Alta','TÉCNICO en Sistemas Microinformáticos y Redes\nGraduado en ESO'),(33,'IKER ZABALA EGINO','16076926H','664850111','1981-03-01','CL IBAIBIDE 0011    ',48930,'GETXO','BIZKAIA',0,'Desempleado','Alta','INGENIERO TÉCNICO en informática de gestión'),(34,'IVAN DOLORES FUERTES','79182409X','659520555','1999-01-14','CL LLANO 71   02 IZ',48903,'BARAKALDO','BIZKAIA',0,'Desempleado','Baja','Graduado en ESO\nTÉCNICO en Instalaciones Eléctricas y Automáticas'),(36,'RAUL VITORIA LADRILLO','22757127F','672613000','1990-11-11','CL LARREA 0001   3 A',48901,'BARAKALDO','BIZKAIA',0,'Desempleado','Alta',''),(39,'SERGIO MANZANA CAMARERO','45893200N','664663333','1996-09-01','PZ CIUDAD DE LA HABANA 4   3 D',48510,'VALLE DE TRAPAGA-TRAPAGARAN','BIZKAIA',0,'Desempleado','Alta','GRADO en Relaciones Internacionales\nBACHILLER cualquier especialidad');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Wanda','3WiXc6G','wanda_fake_admin@gmail.com',NULL,1,NULL),(2,'Paco','pacopepe','metalpaco@gmail.com',NULL,2,NULL),(5,'Rober','Asdfg13!','mikel@gmail.com',NULL,2,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'elorrieta'
--

--
-- Dumping routines for database 'elorrieta'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-28 13:06:56
