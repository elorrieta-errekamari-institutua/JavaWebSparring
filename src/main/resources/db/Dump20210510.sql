CREATE DATABASE  IF NOT EXISTS `elorrieta` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `elorrieta`;
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
  `codigo_lanbide` varchar(45) NOT NULL,
  `codificacion` varchar(256) NOT NULL,
  `codigo_uc` varchar(45) NOT NULL,
  `competencia` varchar(256) NOT NULL,
  `codigo_aaff` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `horas_curso` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
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
  `id_curso` int NOT NULL,
  `id_horario` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_curso_FK_idx` (`id_curso`),
  KEY `id_horario_FK_idx` (`id_horario`),
  CONSTRAINT `id_curso_FK` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `id_horario_FK` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicion`
--

LOCK TABLES `edicion` WRITE;
/*!40000 ALTER TABLE `edicion` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
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
  `titulacion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Wanda','3WiXc6G','wanda_fake_admin@gmail.com',NULL,1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 11:11:02
