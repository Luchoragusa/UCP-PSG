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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arma`
--

LOCK TABLES `arma` WRITE;
/*!40000 ALTER TABLE `arma` DISABLE KEYS */;
INSERT INTO `arma` VALUES (1,'Pistola','Combate'),(2,'SubFusil','SMG'),(3,'Fusil','AK-47');
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
  PRIMARY KEY (`idIntegramte`),
  CONSTRAINT `id_Integrantehr` FOREIGN KEY (`idIntegramte`) REFERENCES `integrante` (`idIntegrante`)
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
  `usuario` varchar(45) NOT NULL,
  `pw` varchar(45) NOT NULL,
  PRIMARY KEY (`idIntegrante`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrante`
--

LOCK TABLES `integrante` WRITE;
/*!40000 ALTER TABLE `integrante` DISABLE KEYS */;
INSERT INTO `integrante` VALUES (1,'Juan','Pucheta','steam:123','558091838259724309','jpucheta','jp123'),(2,'Camilo','Pereyra','steam:321','404471332991008768','cpereyra','cp123'),(3,'Luciano','Ragusa','steam:890','328247693724090369','lragusa','lr123');
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
  PRIMARY KEY (`idIntegrante`,`fecha_recompensa`),
  KEY `id_Medalla_idx` (`idMedalla`),
  CONSTRAINT `id_Integr` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`),
  CONSTRAINT `id_Medalla` FOREIGN KEY (`idMedalla`) REFERENCES `medalla` (`idMedalla`)
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medalla`
--

LOCK TABLES `medalla` WRITE;
/*!40000 ALTER TABLE `medalla` DISABLE KEYS */;
INSERT INTO `medalla` VALUES (1,'TopHoras-High1','Semanal'),(2,'TopHoras-High2','Semanal'),(3,'TopHoras-Low1','Semanal'),(4,'TopHoras-Low2','Semanal'),(5,'TopHoras-Low3','Semanal'),(6,'Central','Mensual'),(7,'Tiro','Mensual'),(8,'Companero','Mensual');
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
  `fecha_desde` date NOT NULL,
  PRIMARY KEY (`fecha_desde`),
  KEY `id_Rango_idx` (`idRango`),
  KEY `id_Integranterb_idx` (`idIntegrante`),
  CONSTRAINT `id_int` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`),
  CONSTRAINT `id_Ran` FOREIGN KEY (`idRango`) REFERENCES `rango` (`idRango`)
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
  `idRanSub` int NOT NULL AUTO_INCREMENT,
  `idSub` int NOT NULL,
  `nombreRangoSub` varchar(45) NOT NULL,
  PRIMARY KEY (`idRanSub`),
  KEY `id_Sub_idx` (`idSub`),
  CONSTRAINT `id_Sub` FOREIGN KEY (`idSub`) REFERENCES `subdivision` (`idSub`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ran_subdivision`
--

LOCK TABLES `ran_subdivision` WRITE;
/*!40000 ALTER TABLE `ran_subdivision` DISABLE KEYS */;
INSERT INTO `ran_subdivision` VALUES (1,2,'Cadete'),(2,1,'Capitan de la Brigada'),(3,2,'Encargado de Infante'),(4,3,'Encargado de U.A'),(5,2,'Encargado de U.I'),(6,1,'Encargado de U.R.A'),(7,1,'Guardia'),(8,2,'Infante Supreme'),(9,3,'Piloto Avanzado'),(10,3,'Piloto Experto'),(11,3,'Piloto Instructor'),(12,3,'Piloto Novato'),(13,1,'Recluta'),(14,2,'Recluta'),(15,2,'Sargento'),(16,1,'Sub-Capitan'),(17,2,'Supervisor'),(18,1,'Teniente');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rango`
--

LOCK TABLES `rango` WRITE;
/*!40000 ALTER TABLE `rango` DISABLE KEYS */;
INSERT INTO `rango` VALUES (1,'Aprendiz'),(2,'Empleado'),(3,'Experimentado'),(4,'Vigilante'),(5,'Supervisor'),(6,'Agente'),(7,'Controlista del Cuerpo'),(8,'Maestro del Cuerpo'),(9,'Sub Encargado del Cuerpo'),(10,'Encargado del Cuerpo'),(11,'Auxiliar del Cuerpo'),(12,'Instructor del Cuerpo'),(13,'Sub Jefe del Cuerpo'),(14,'Jefe del Cuerpo'),(15,'Gerente del Cuerpo'),(16,'Interventor');
/*!40000 ALTER TABLE `rango` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ransub_integrante`
--

DROP TABLE IF EXISTS `ransub_integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ransub_integrante` (
  `idIntegramte` int NOT NULL,
  `fecha_desde` date NOT NULL,
  `idRangoSub` int NOT NULL,
  PRIMARY KEY (`fecha_desde`,`idIntegramte`,`idRangoSub`),
  KEY `id_Integranters_idx` (`idIntegramte`),
  KEY `id_RangSub_idx` (`idRangoSub`),
  CONSTRAINT `id_Integranters` FOREIGN KEY (`idIntegramte`) REFERENCES `integrante` (`idIntegrante`),
  CONSTRAINT `id_RangSub` FOREIGN KEY (`idRangoSub`) REFERENCES `ran_subdivision` (`idRanSub`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ransub_integrante`
--

LOCK TABLES `ransub_integrante` WRITE;
/*!40000 ALTER TABLE `ransub_integrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `ransub_integrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `robo`
--

DROP TABLE IF EXISTS `robo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `robo` (
  `idLugarRobo` int NOT NULL AUTO_INCREMENT,
  `nomRobo` varchar(45) NOT NULL,
  `lugarRobo` varchar(45) DEFAULT NULL,
  `maxIntegrantes` int NOT NULL,
  `minIntegrantes` int NOT NULL,
  PRIMARY KEY (`idLugarRobo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `robo`
--

LOCK TABLES `robo` WRITE;
/*!40000 ALTER TABLE `robo` DISABLE KEYS */;
INSERT INTO `robo` VALUES (1,'Yate',NULL,6,4),(2,'Life Invader',NULL,5,4),(3,'Humane',NULL,10,8),(4,'Cerveceria','Salita medica',3,2),(5,'Cerveceria','Vespucci',3,2),(6,'Cerveceria','Costa',3,2),(7,'Cerveceria','Atras de Comisaria',3,2);
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
  PRIMARY KEY (`idIntegrante`,`fecha_robo`,`hora_robo`),
  KEY `id_LugarRobo_idx` (`idLugarRobo`),
  CONSTRAINT `id_Integranterb` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`),
  CONSTRAINT `id_LugarRobo` FOREIGN KEY (`idLugarRobo`) REFERENCES `robo` (`idLugarRobo`)
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
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Admin'),(2,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_integrante`
--

DROP TABLE IF EXISTS `rol_integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_integrante` (
  `idRol` int NOT NULL,
  `idIntegrante` int NOT NULL,
  PRIMARY KEY (`idRol`,`idIntegrante`),
  KEY `id_Integrante_idx` (`idIntegrante`),
  CONSTRAINT `id_Integrante` FOREIGN KEY (`idIntegrante`) REFERENCES `integrante` (`idIntegrante`),
  CONSTRAINT `id_Rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_integrante`
--

LOCK TABLES `rol_integrante` WRITE;
/*!40000 ALTER TABLE `rol_integrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_integrante` ENABLE KEYS */;
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
  PRIMARY KEY (`fecha`,`idArma`),
  KEY `id_Arma_idx` (`idArma`),
  CONSTRAINT `id_Arma` FOREIGN KEY (`idArma`) REFERENCES `arma` (`idArma`)
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdivision`
--

LOCK TABLES `subdivision` WRITE;
/*!40000 ALTER TABLE `subdivision` DISABLE KEYS */;
INSERT INTO `subdivision` VALUES (1,'Unidad de rapida accion','U.R.A'),(2,'Unidad de infanteria','U.I'),(3,'Unidad aerea','U.A');
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

-- Dump completed on 2021-07-23 17:06:12
