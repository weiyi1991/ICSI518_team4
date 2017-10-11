# Team


Product table

CREATE TABLE `teamdb`.`product` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(45) NOT NULL,
  `productDescription` MEDIUMTEXT NOT NULL,
  `productPrice` DECIMAL(2) NOT NULL,
  `productSeller` VARCHAR(45) NOT NULL,
  `productCategory` VARCHAR(45) NOT NULL,
  `productAddress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productId`));
