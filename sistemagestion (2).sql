-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 26-11-2023 a las 05:44:47
-- Versión del servidor: 8.0.21
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemagestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `Cliente_ID` int NOT NULL AUTO_INCREMENT,
  `razonS` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `cuit` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `TipoServicio` int DEFAULT NULL,
  PRIMARY KEY (`Cliente_ID`),
  KEY `TipoServicio` (`TipoServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Cliente_ID`, `razonS`, `cuit`, `TipoServicio`) VALUES
(1, 'fghgfh', 'fghfg', 1),
(2, 'dfgdfgdgdf', 'dfgdg', 1),
(3, 'Sebastian Kang', '312312321', 1),
(4, 'dfg', 'dfg1', 1),
(5, 'dfgdf', 'dfgdg', 1),
(6, 'ssdfs', 'sdfds', 1),
(7, 'asdasd', 'asdasd', 1),
(8, 'sermentana srl', '12324234', 1),
(9, 'dfgd', 'dfgd', 1),
(10, 'asdasd', '303asdaasd', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes_tiposervicio`
--

DROP TABLE IF EXISTS `clientes_tiposervicio`;
CREATE TABLE IF NOT EXISTS `clientes_tiposervicio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_ID` int DEFAULT NULL,
  `servicio_ID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_ID` (`cliente_ID`),
  KEY `servicio_ID` (`servicio_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidadestecnicas`
--

DROP TABLE IF EXISTS `especialidadestecnicas`;
CREATE TABLE IF NOT EXISTS `especialidadestecnicas` (
  `Especial_ID` int NOT NULL AUTO_INCREMENT,
  `Especial` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Especial_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `especialidadestecnicas`
--

INSERT INTO `especialidadestecnicas` (`Especial_ID`, `Especial`) VALUES
(1, 'SoporteSAP'),
(2, 'Soporte PC'),
(3, NULL),
(4, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentes`
--

DROP TABLE IF EXISTS `incidentes`;
CREATE TABLE IF NOT EXISTS `incidentes` (
  `Incidente_ID` int NOT NULL AUTO_INCREMENT,
  `Cliente_ID` int DEFAULT NULL,
  `Servicio_ID` int DEFAULT NULL,
  `Descripcion` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `esComplejo` tinyint(1) DEFAULT NULL,
  `TipoProblema_ID` int DEFAULT NULL,
  `Estado` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `FechaResolucion` date DEFAULT NULL,
  `Solucion_ID` int DEFAULT NULL,
  `Tecnico_ID` int DEFAULT NULL,
  PRIMARY KEY (`Incidente_ID`),
  KEY `Solucion_ID` (`Solucion_ID`),
  KEY `Tecnico_ID` (`Tecnico_ID`),
  KEY `Cliente_ID` (`Cliente_ID`),
  KEY `TipoProblema_ID` (`TipoProblema_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solucion`
--

DROP TABLE IF EXISTS `solucion`;
CREATE TABLE IF NOT EXISTS `solucion` (
  `Solucion_ID` int NOT NULL AUTO_INCREMENT,
  `solucion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Solucion_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos`
--

DROP TABLE IF EXISTS `tecnicos`;
CREATE TABLE IF NOT EXISTS `tecnicos` (
  `Tecnico_ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `Especialidad` int DEFAULT NULL,
  `Mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Tecnico_ID`),
  KEY `Especialidad` (`Especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tecnicos`
--

INSERT INTO `tecnicos` (`Tecnico_ID`, `Nombre`, `Especialidad`, `Mail`) VALUES
(1, 'Salvador Grifasi', 1, 'asdadadad@gmail.com'),
(2, 'jorge Edgardo', 1, ''),
(3, 'Marcos Benassi', 3, 'asdasd@gmail.com'),
(4, 'alejandro', 2, '115154545');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos_especialidades`
--

DROP TABLE IF EXISTS `tecnicos_especialidades`;
CREATE TABLE IF NOT EXISTS `tecnicos_especialidades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tecnico_ID` int DEFAULT NULL,
  `especial_ID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tecnico_ID` (`tecnico_ID`),
  KEY `especial_ID` (`especial_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproblema`
--

DROP TABLE IF EXISTS `tipoproblema`;
CREATE TABLE IF NOT EXISTS `tipoproblema` (
  `Problema_ID` int NOT NULL AUTO_INCREMENT,
  `TipoProblema` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `TiempoRespuestaEstimado` int DEFAULT NULL,
  PRIMARY KEY (`Problema_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposervicio`
--

DROP TABLE IF EXISTS `tiposervicio`;
CREATE TABLE IF NOT EXISTS `tiposervicio` (
  `Servicio_ID` int NOT NULL AUTO_INCREMENT,
  `TipoServ` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Servicio_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tiposervicio`
--

INSERT INTO `tiposervicio` (`Servicio_ID`, `TipoServ`) VALUES
(1, 'Soporte SAP'),
(2, 'Soporte SAP');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`TipoServicio`) REFERENCES `tiposervicio` (`Servicio_ID`);

--
-- Filtros para la tabla `clientes_tiposervicio`
--
ALTER TABLE `clientes_tiposervicio`
  ADD CONSTRAINT `clientes_tiposervicio_ibfk_1` FOREIGN KEY (`cliente_ID`) REFERENCES `clientes` (`Cliente_ID`),
  ADD CONSTRAINT `clientes_tiposervicio_ibfk_2` FOREIGN KEY (`servicio_ID`) REFERENCES `tiposervicio` (`Servicio_ID`);

--
-- Filtros para la tabla `incidentes`
--
ALTER TABLE `incidentes`
  ADD CONSTRAINT `incidentes_ibfk_1` FOREIGN KEY (`Solucion_ID`) REFERENCES `solucion` (`Solucion_ID`),
  ADD CONSTRAINT `incidentes_ibfk_2` FOREIGN KEY (`Tecnico_ID`) REFERENCES `tecnicos` (`Tecnico_ID`),
  ADD CONSTRAINT `incidentes_ibfk_3` FOREIGN KEY (`Cliente_ID`) REFERENCES `clientes` (`Cliente_ID`),
  ADD CONSTRAINT `incidentes_ibfk_4` FOREIGN KEY (`TipoProblema_ID`) REFERENCES `tipoproblema` (`Problema_ID`);

--
-- Filtros para la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  ADD CONSTRAINT `tecnicos_ibfk_1` FOREIGN KEY (`Especialidad`) REFERENCES `especialidadestecnicas` (`Especial_ID`);

--
-- Filtros para la tabla `tecnicos_especialidades`
--
ALTER TABLE `tecnicos_especialidades`
  ADD CONSTRAINT `tecnicos_especialidades_ibfk_1` FOREIGN KEY (`tecnico_ID`) REFERENCES `tecnicos` (`Tecnico_ID`),
  ADD CONSTRAINT `tecnicos_especialidades_ibfk_2` FOREIGN KEY (`especial_ID`) REFERENCES `especialidadestecnicas` (`Especial_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
