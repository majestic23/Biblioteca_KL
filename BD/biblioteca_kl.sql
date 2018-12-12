-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema biblioteca_kl
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca_kl
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca_kl` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca_kl` ;

-- -----------------------------------------------------
-- Table `biblioteca_kl`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`categoria` (
  `idcategoria` INT NOT NULL,
  `nombre_categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_kl`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`libro` (
  `idlibro` INT NOT NULL,
  `nombre_libro` VARCHAR(45) NOT NULL,
  `categoria_idcategoria` INT NOT NULL,
  PRIMARY KEY (`idlibro`),
  INDEX `fk_libro_categoria_idx` (`categoria_idcategoria` ASC),
  CONSTRAINT `fk_libro_categoria`
    FOREIGN KEY (`categoria_idcategoria`)
    REFERENCES `biblioteca_kl`.`categoria` (`idcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_kl`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`usuario` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`username`));


-- -----------------------------------------------------
-- Table `biblioteca_kl`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`cliente` (
  `idcliente` INT NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `usuario_username` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_username` ASC),
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_username`)
    REFERENCES `biblioteca_kl`.`usuario` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_kl`.`reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`reservacion` (
  `idreservacion` INT NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NULL,
  `libro_idlibro` INT NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idreservacion`),
  INDEX `fk_reservacion_libro1_idx` (`libro_idlibro` ASC),
  INDEX `fk_reservacion_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_reservacion_libro1`
    FOREIGN KEY (`libro_idlibro`)
    REFERENCES `biblioteca_kl`.`libro` (`idlibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservacion_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `biblioteca_kl`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_kl`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_kl`.`Trabajador` (
  `idTrabajador` INT NOT NULL,
  `nombre_trabajador` VARCHAR(45) NOT NULL,
  `dni_trabajador` INT NOT NULL,
  `usuario_username` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`idTrabajador`),
  INDEX `fk_Trabajador_usuario1_idx` (`usuario_username` ASC),
  CONSTRAINT `fk_Trabajador_usuario1`
    FOREIGN KEY (`usuario_username`)
    REFERENCES `biblioteca_kl`.`usuario` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
