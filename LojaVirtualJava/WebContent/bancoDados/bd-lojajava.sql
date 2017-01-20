-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd_lojavirtual
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_lojavirtual
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_lojavirtual` DEFAULT CHARACTER SET utf8 ;
USE `bd_lojavirtual` ;

-- -----------------------------------------------------
-- Table `bd_lojavirtual`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lojavirtual`.`pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME(6) NOT NULL,
  `cliente` VARCHAR(255) NOT NULL,
  `cliente_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idPedido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_lojavirtual`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lojavirtual`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_lojavirtual`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lojavirtual`.`produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  `preco` DECIMAL(6,2) NOT NULL,
  `foto` VARCHAR(255) NULL,
  `Categoria_idCategoria` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_Produto_Categoria_idx` (`Categoria_idCategoria` ASC),
  CONSTRAINT `fk_Produto_Categoria`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `bd_lojavirtual`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_lojavirtual`.`pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_lojavirtual`.`pedido_produto` (
  `idPedido_produto` INT NOT NULL AUTO_INCREMENT,
  `quantidade_produto` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  `pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idPedido_produto`),
  INDEX `fk_Pedido_produto_Produto1_idx` (`Produto_idProduto` ASC),
  INDEX `fk_pedido_produto_pedido1_idx` (`pedido_idPedido` ASC),
  CONSTRAINT `fk_Pedido_produto_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `bd_lojavirtual`.`produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_produto_pedido1`
    FOREIGN KEY (`pedido_idPedido`)
    REFERENCES `bd_lojavirtual`.`pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
