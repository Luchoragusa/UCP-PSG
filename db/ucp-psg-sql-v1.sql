-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ucp-psg
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
-- Table structure for table `arma`
--

DROP TABLE IF EXISTS `arma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arma` (
  `idArma` int NOT NULL AUTO_INCREMENT,
  `tipoArma` varchar(45) NOT NULL,
  `nombreArma` varchar(45) NOT NULL,
  PRIMARY KEY (`idArma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arma`
--

LOCK TABLES `arma` WRITE;
/*!40000 ALTER TABLE `arma` DISABLE KEYS */;
/*!40000 ALTER TABLE `arma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horas`
--

DROP TABLE IF EXISTS `horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horas` (
  `idIntegramte` int NOT NULL AUTO_INCREMENT,
  `horaInicio` time NOT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idIntegramte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
/*!40000 ALTER TABLE `horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integrante`
--

DROP TABLE IF EXISTS `integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integrante` (
  `idIntegrante` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `steamHex` varchar(45) NOT NULL,
  `discordId` varchar(45) NOT NULL,
  PRIMARY KEY (`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrante`
--

LOCK TABLES `integrante` WRITE;
/*!40000 ALTER TABLE `integrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `integrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_integrante`
--

DROP TABLE IF EXISTS `med_integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `med_integrante` (
  `idMedalla` int NOT NULL,
  `idIntegrante` int NOT NULL,
  `fecha_recompensa` date NOT NULL,
  `recompensa` varchar(45) NOT NULL,
  PRIMARY KEY (`idIntegrante`,`fecha_recompensa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_integrante`
--

LOCK TABLES `med_integrante` WRITE;
/*!40000 ALTER TABLE `med_integrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `med_integrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medalla`
--

DROP TABLE IF EXISTS `medalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medalla` (
  `idMedalla` int NOT NULL AUTO_INCREMENT,
  `nomMedalla` varchar(45) NOT NULL,
  `tipoMedalla` varchar(45) NOT NULL,
  PRIMARY KEY (`idMedalla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medalla`
--

LOCK TABLES `medalla` WRITE;
/*!40000 ALTER TABLE `medalla` DISABLE KEYS */;
/*!40000 ALTER TABLE `medalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ran_integrante`
--

DROP TABLE IF EXISTS `ran_integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ran_integrante` (
  `idRango` int NOT NULL,
  `idIntegrante` int NOT NULL,
  `fecha_desde` varchar(45) NOT NULL,
  PRIMARY KEY (`fecha_desde`,`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ran_integrante`
--

LOCK TABLES `ran_integrante` WRITE;
/*!40000 ALTER TABLE `ran_integrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `ran_integrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ran_subdivision`
--

DROP TABLE IF EXISTS `ran_subdivision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ran_subdivision` (
  `nombreRangoSub` varchar(45) NOT NULL,
  `idSub` int NOT NULL,
  PRIMARY KEY (`nombreRangoSub`,`idSub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ran_subdivision`
--

LOCK TABLES `ran_subdivision` WRITE;
/*!40000 ALTER TABLE `ran_subdivision` DISABLE KEYS */;
/*!40000 ALTER TABLE `ran_subdivision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rango`
--

DROP TABLE IF EXISTS `rango`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rango` (
  `idRango` int NOT NULL AUTO_INCREMENT,
  `nombRango` varchar(45) NOT NULL,
  PRIMARY KEY (`idRango`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rango`
--

LOCK TABLES `rango` WRITE;
/*!40000 ALTER TABLE `rango` DISABLE KEYS */;
/*!40000 ALTER TABLE `rango` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `robo`
--

DROP TABLE IF EXISTS `robo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `robo` (
  `idLugarRobo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nomRobo` varchar(45) NOT NULL,
  `lugarRobo` varchar(45) NOT NULL,
  PRIMARY KEY (`idLugarRobo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `robo`
--

LOCK TABLES `robo` WRITE;
/*!40000 ALTER TABLE `robo` DISABLE KEYS */;
/*!40000 ALTER TABLE `robo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roboxdia`
--

DROP TABLE IF EXISTS `roboxdia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roboxdia` (
  `idLugarRobo` int NOT NULL,
  `idIntegrante` int NOT NULL,
  `fecha_robo` date NOT NULL,
  `hora_robo` time NOT NULL,
  `resultado` varchar(45) NOT NULL,
  PRIMARY KEY (`idIntegrante`,`fecha_robo`,`hora_robo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roboxdia`
--

LOCK TABLES `roboxdia` WRITE;
/*!40000 ALTER TABLE `roboxdia` DISABLE KEYS */;
/*!40000 ALTER TABLE `roboxdia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sancion`
--

DROP TABLE IF EXISTS `sancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sancion` (
  `motivo` varchar(100) NOT NULL,
  `idIntegrante` int NOT NULL,
  `tipoSancion` varchar(45) NOT NULL,
  PRIMARY KEY (`motivo`,`idIntegrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sancion`
--

LOCK TABLES `sancion` WRITE;
/*!40000 ALTER TABLE `sancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `sancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockarma`
--

DROP TABLE IF EXISTS `stockarma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockarma` (
  `fecha` date NOT NULL,
  `idArma` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idArma`,`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockarma`
--

LOCK TABLES `stockarma` WRITE;
/*!40000 ALTER TABLE `stockarma` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockarma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subdivision`
--

DROP TABLE IF EXISTS `subdivision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subdivision` (
  `idSub` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `nomSubdivision` varchar(45) NOT NULL,
  PRIMARY KEY (`idSub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdivision`
--

LOCK TABLES `subdivision` WRITE;
/*!40000 ALTER TABLE `subdivision` DISABLE KEYS */;
/*!40000 ALTER TABLE `subdivision` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-13 12:31:00
