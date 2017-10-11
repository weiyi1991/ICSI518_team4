<<<<<<< HEAD
# Team Project

### Instructions
1. Clone source code to your local disk.
2. Load JSP project to Eclipse.[Reference](https://ssodelta.wordpress.com/2014/05/06/how-to-connect-eclipse-to-github/)
3. Create tables using the `ecommerce.sql` for >MySQL3.5
=======
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
>>>>>>> 76f446dfd4533d4fc26eeab9a66d4df791aad640
