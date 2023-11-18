-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-11-2023 a las 03:10:54
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
  `Cliente_ID` int NOT NULL,
  `razonS` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cuit` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TipoServicio` int DEFAULT NULL,
  PRIMARY KEY (`Cliente_ID`),
  KEY `TipoServicio` (`TipoServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Cliente_ID`, `razonS`, `cuit`, `TipoServicio`) VALUES
(1, 'Pedro Dias S.R.L.', '30445777120', 1),
(2, 'Arcos Dorados S.A.', '30647478881', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidadestecnicas`
--

DROP TABLE IF EXISTS `especialidadestecnicas`;
CREATE TABLE IF NOT EXISTS `especialidadestecnicas` (
  `Especial_ID` int NOT NULL,
  `Especial` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Especial_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `especialidadestecnicas`
--

INSERT INTO `especialidadestecnicas` (`Especial_ID`, `Especial`) VALUES
(1, 'Especialidad Mantenimiento SAP'),
(2, 'Especialidad Mantenimiento Tango'),
(3, 'Especialidad Mantenimiento servidores'),
(4, 'Especialidad Mantenimiento Windows'),
(5, 'Especialidad Mantenimiento Mac Os'),
(6, 'Especialidad Mantenimiento Linux');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidentes`
--

DROP TABLE IF EXISTS `incidentes`;
CREATE TABLE IF NOT EXISTS `incidentes` (
  `Incidente_ID` int NOT NULL,
  `Cliente_ID` int DEFAULT NULL,
  `Servicio_ID` int DEFAULT NULL,
  `Descripcion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `esComplejo` tinyint(1) DEFAULT NULL,
  `TipoProblema_ID` int DEFAULT NULL,
  `Estado` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
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

--
-- Volcado de datos para la tabla `incidentes`
--

INSERT INTO `incidentes` (`Incidente_ID`, `Cliente_ID`, `Servicio_ID`, `Descripcion`, `esComplejo`, `TipoProblema_ID`, `Estado`, `FechaCreacion`, `FechaResolucion`, `Solucion_ID`, `Tecnico_ID`) VALUES
(1, 2, 1, 'No inicia el Sap', 1, 1, 'Resuelto', '2023-11-01', '2023-11-02', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solucion`
--

DROP TABLE IF EXISTS `solucion`;
CREATE TABLE IF NOT EXISTS `solucion` (
  `Solucion_ID` int NOT NULL,
  `solucion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DescrpSolucion` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`Solucion_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `solucion`
--

INSERT INTO `solucion` (`Solucion_ID`, `solucion`, `DescrpSolucion`) VALUES
(1, 'Solucion de prueba', 'Resuelto ok');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos`
--

DROP TABLE IF EXISTS `tecnicos`;
CREATE TABLE IF NOT EXISTS `tecnicos` (
  `Tecnico_ID` int NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Especialidad` int DEFAULT NULL,
  `Mail` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Tel` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Tecnico_ID`),
  KEY `Especialidad` (`Especialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tecnicos`
--

INSERT INTO `tecnicos` (`Tecnico_ID`, `Nombre`, `Especialidad`, `Mail`, `Tel`) VALUES
(1, 'Marcos Benassi', 1, 'marcos@gmail.com', '111111111'),
(2, 'Luciano Olmedo', 6, 'Luciano@gmail.com', '1111111111'),
(3, 'Matias Gil', 4, 'Matias@gmail.com', '111111111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproblema`
--

DROP TABLE IF EXISTS `tipoproblema`;
CREATE TABLE IF NOT EXISTS `tipoproblema` (
  `Problema_ID` int NOT NULL,
  `TipoProblema` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TiempoRespuestaEstimado` int DEFAULT NULL,
  PRIMARY KEY (`Problema_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipoproblema`
--

INSERT INTO `tipoproblema` (`Problema_ID`, `TipoProblema`, `TiempoRespuestaEstimado`) VALUES
(1, 'Caida general del Programa', 200),
(2, 'Caida de la Base de Datos(BBDD)', 300),
(3, 'Problema de hardware', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposervicioid`
--

DROP TABLE IF EXISTS `tiposervicioid`;
CREATE TABLE IF NOT EXISTS `tiposervicioid` (
  `Servicio_ID` int NOT NULL,
  `TipoServ` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`Servicio_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tiposervicioid`
--

INSERT INTO `tiposervicioid` (`Servicio_ID`, `TipoServ`) VALUES
(1, 'SoporteSap'),
(2, 'soporteTango'),
(3, 'SoporteServidores'),
(4, 'SoporteWindows'),
(5, 'SoporteMacOs'),
(6, 'SoporteLinux');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`TipoServicio`) REFERENCES `tiposervicioid` (`Servicio_ID`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
