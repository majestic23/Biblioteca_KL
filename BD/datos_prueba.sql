-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-12-2018 a las 20:54:10
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca_kl`
--

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`, `nombre_categoria`) VALUES
(10003, 'Ciencia Ficcion'),
(10019, 'Cultura'),
(10026, 'Comedia'),
(10029, 'Educacion'),
(10046, 'Drama'),
(10056, 'Adventura'),
(10074, 'Exotico'),
(10088, 'Terror');

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idlibro`, `nombre_libro`, `stock`, `descripcion`, `categoria_idcategoria`) VALUES
(10020, 'Libro3', 4, NULL, 10003),
(10028, 'Libro5', 1, NULL, 10019),
(10033, 'Libro4', 10, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ', 10019),
(10039, 'Libro8', 1, NULL, 10029),
(10046, 'El Gato Negro', 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 10088),
(10047, 'Libro6', 5, NULL, 10019),
(10053, 'Libro1', 7, NULL, 10003),
(10083, 'El Retrato de Dorian Grey', 7, 'Un joven ...', 10046);


--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`username`, `email`, `password`) VALUES
('16168895', 'kty@biblioteca.com', 'kat1450'),
('17171717', 'k@gmail.com', 'biblioteca'),
('45678125', 'pudrete1@hotmail.com', 'biblioteca'),
('74256015', 'pnicole@gmail.com', 'biblioteca'),
('80808080', 'pablo@gmail.com', 'biblioteca'),
('admin', 'manuel.alejandro', 'admin');

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre_cliente`, `usuario_username`) VALUES
(16168895, 'Kathy Estela', '16168895'),
(17171717, 'Kety Importa', '17171717'),
(45678125, 'Problema1 Pudrete', '45678125'),
(74256015, 'Pyroska Nicole', '74256015'),
(80808080, 'Perez Pablo', '80808080');

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idTrabajador`, `nombre_trabajador`, `dni_trabajador`, `usuario_username`) VALUES
(1, 'Manuel', 71820912, 'admin');


--
-- Volcado de datos para la tabla `reservacion`
--

INSERT INTO `reservacion` (`idreservacion`, `fecha_inicio`, `fecha_fin`, `estado`, `libro_idlibro`, `cliente_idcliente`) VALUES
(10012, '2018-12-07', '2018-12-04', 1, 10020, 45678125),
(10031, '2018-12-04', '2018-12-10', 1, 10053, 74256015),
(10037, '2018-12-07', '2018-12-04', 1, 10020, 45678125),
(10084, '2018-12-10', NULL, 0, 10039, 45678125),
(10085, '2018-12-12', '2018-12-13', 1, 10028, 74256015),
(10086, '2018-11-29', '2018-12-12', 1, 10047, 74256015);



COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
