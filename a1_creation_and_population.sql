use a1;
CREATE TABLE Clientt (
  `id_client` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `identity_card_number` int(11) NOT NULL,
  `personal_numerical_code` varchar(15) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id_client`));
CREATE TABLE Account (
  `id_account` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `identification_number` int(11) NOT NULL,
  `type` varchar(15) NOT NULL,
  `amount_of_money` int(15) NOT NULL,
  `date_of_creation` date not null,
  `id_client` int(11) unsigned NOT NULL, 
  PRIMARY KEY (`id_account`),
  FOREIGN KEY (`id_client`) REFERENCES clientt(`id_client`));
CREATE TABLE User (
  `id_user` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_user`));
  CREATE TABLE UserRole (
  `id_role` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  `id_user` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id_role`),
  FOREIGN KEY (`id_user`) REFERENCES User (`id_user`));
  INSERT INTO Clientt(id_client,name,identity_card_number,personal_numerical_code,address)
  VALUES('1','Florin Radu','346622','1950304124568','str Ciocarliei nr 6'),
		 ('2','Alina Raluca','234312','2980912568124','str Papura nr 99'),
         ('3','Cioci Mircea','458790','1901203567312','str Ghencea nr 44'),
		 ('4','Pop Ionela','451233','2940507125788','str Campina nr 51');
  INSERT INTO account(id_account,identification_number,type,amount_of_money,date_of_creation,id_client)
  VALUES('1','78905320','saving','2900','2017-02-15','3'),
		 ('2','65466660','spending','10000','2017-03-03','2'),
         ('3','10202000','spending','3400','2017-01-20','1'),
		 ('4','56329389','saving','800','2017-01-01','4');
  INSERT INTO user(id_user,username,password)
  VALUES('1','alintomos','abecedar'),
		 ('2','mihneavlad','seful'),
         ('3','lauramarc','floaredetei');
  INSERT INTO userrole(id_role,type,id_user)
  VALUES('1','employee','3'),
		 ('2','admin','2'),
         ('3','employee','1');
               