CREATE TABLE if not exists `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `apellido` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `telefono` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;



INSERT INTO persona(nombre, apellido,email, telefono) 
VALUES ('Antonio', 'Perez', 'aperez@mail.com', '1234-5678');


INSERT INTO persona(nombre, apellido,email, telefono) 
VALUES ('Pancha', 'Diaz', 'pdiaz@mail.com', '928-23-45-67');
