CREATE TABLE USER  
(  
UID INT NOT NULL auto_increment,  
UNAME VARCHAR(12) NOT NULL unique,    
PASS VARCHAR(12) NOT NULL,  
ROLE VARCHAR(10) NOT NULL,  
STATUS INT NOT NULL DEFAULT 0,
VERIFY INT NOT NULL DEFAULT 0,
PRIMARY KEY(UID)  
); 

CREATE TABLE USER_PROFILE  
(  
UID INT ,  
FNAME VARCHAR(12) NOT NULL,    
LNAME VARCHAR(12) NOT NULL,  
EMAIL VARCHAR(20) NOT NULL, 
Phone VARCHAR(20),
ADDRESS VARCHAR(20), 
PRIMARY KEY (UID),
foreign key (UID) references USER(UID)
);  

CREATE TABLE PRODUCT  
(  
PID INT NOT NULL auto_increment,  
PNAME VARCHAR(30) NOT NULL,    
CATEGORY VARCHAR(12),  
PRICE INT NOT NULL, 
UID INT NOT NULL,
DESP VARCHAR(100) NOT NULL, 
PHOTO mediumblob,
PRIMARY KEY (PID),
foreign key (UID) references USER(UID)
); 

CREATE TABLE COMMENTS
(
CID INT NOT NULL auto_increment,
UID INT NOT NULL,
PID INT NOT NULL,
SID INT NOT NULL,  /*UID of the seller*/
RATES float,
COMM text,
PRIMARY KEY (CID),
foreign key (UID) references USER(UID),
foreign key (SID) references USER(UID),
foreign key (PID) references PRODUCT(PID)
);

CREATE TABLE FEEDBACKS
(
FID INT NOT NULL auto_increment,
UID INT NOT NULL,
PID INT NOT NULL,
SID INT NOT NULL,  /*UID of the seller*/
FEED text,
PRIMARY KEY (FID),
foreign key (UID) references USER(UID),
foreign key (SID) references USER(UID),
foreign key (PID) references PRODUCT(PID)
);
INSERT INTO `ecommerce`.`user` (`UNAME`, `PASS`, `ROLE`) VALUES ('user1', '123', 'Customer');
INSERT INTO `ecommerce`.`user` (`UNAME`, `PASS`, `ROLE`) VALUES ('admin', '123', 'Admin');
