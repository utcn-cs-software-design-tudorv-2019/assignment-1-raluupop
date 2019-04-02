DROP DATABASE `assigment1`;
CREATE DATABASE IF NOT EXISTS `assigment1`;
USE `assigment1`;

CREATE TABLE IF NOT EXISTS `assigment1`.`Teacher` (
  `idTeacher` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(20) NULL,
  `pnc` VARCHAR(13) NULL,
  `address` VARCHAR(200) NULL,
  `email` VARCHAR(30) NULL,
  `course` VARCHAR(30) NULL,
  PRIMARY KEY (`idTeacher`));

CREATE TABLE IF NOT EXISTS `assigment1`.`Student` (
  `idStudent` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(20) NULL,
  `pnc` VARCHAR(13) NULL,
  `address` VARCHAR(200) NULL,
  `email` VARCHAR(30) NULL,
  `group` VARCHAR(45) NULL,
  PRIMARY KEY (`idStudent`));

CREATE TABLE IF NOT EXISTS `assigment1`.`Course` (
  `idCourse` INT NOT NULL AUTO_INCREMENT,
  `idTeacher` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `points` INT NULL,
  PRIMARY KEY (`idCourse`),
  CONSTRAINT `key1`
    FOREIGN KEY (`idTeacher`)
    REFERENCES `assigment1`.`Teacher` (`idTeacher`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `assigment1`.`Enrollment` (
  `idEnrollment` INT NOT NULL AUTO_INCREMENT,
  `idStudent` INT NOT NULL,
  `idCourse` INT NOT NULL,
  `startDate` DATE NULL,
  `grade` INT NULL,
  PRIMARY KEY (`idEnrollment`),
  CONSTRAINT `key2`
    FOREIGN KEY (`idStudent`)
    REFERENCES `assigment1`.`Student` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `key3`
    FOREIGN KEY (`idCourse`)
    REFERENCES `assigment1`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);