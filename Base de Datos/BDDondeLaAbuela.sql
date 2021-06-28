create database restaurante;
use restaurante;

create table comuna(
  codComuna INT(5) NOT NULL AUTO_INCREMENT,
  nombreCom VARCHAR(20) NOT NULL,
  PRIMARY KEY (codComuna)
);

create table cliente(
  rutCli varchar(10) NOT NULL,
  claveCli VARCHAR(20) NOT NULL,
  nombreCli VARCHAR(20) NOT NULL,
  apellidoPaternoCli VARCHAR(20) NOT NULL,
  apellidoMaternoCli VARCHAR(20) NOT NULL,
  direccionCli VARCHAR(25) NOT NULL,
  numeracionCli INT(5) NOT NULL,
  telefonoCli INT(10) NOT NULL,
  comuna_codComuna INT(10) NOT NULL,
  PRIMARY KEY (rutCli),
  INDEX `fk_cliente_comuna1_idx` (comuna_codComuna),
  CONSTRAINT `fk_cliente_comuna1`
    FOREIGN KEY (comuna_codComuna) REFERENCES comuna (codComuna)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE plato(
  codPla INT(5)NOT NULL AUTO_INCREMENT,
  nombrePla VARCHAR(30) NOT NULL,
  precioPla INT(7) NOT NULL,
  PRIMARY KEY (codPla)
);

CREATE TABLE bebida(
  codBe INT(5) NOT NULL AUTO_INCREMENT,
  nombreBe VARCHAR(30) NOT NULL,
  precioBe INT(7) NOT NULL,
  PRIMARY KEY (codBe)
  );

CREATE TABLE pedido(
  codigoPe INT(5) NOT NULL AUTO_INCREMENT,
  despachoPe boolean NOT NULL,
  totalPe INT(10) NOT NULL,
  fechaHoraPe DATETIME NOT NULL,
  plato_codPla INT(5) NOT NULL,
  bebida_codBe INT(5) NOT NULL,
  cliente_rutCli VARCHAR(10) NOT NULL,
  PRIMARY KEY (codigoPe),
  INDEX `fk_pedido_plato1_idx` (plato_codPla),
  INDEX `fk_pedido_bebida1_idx` (bebida_codBe),
  INDEX `fk_pedido_cliente1_idx` (cliente_rutCli),
  CONSTRAINT `fk_pedido_plato1`
    FOREIGN KEY (plato_codPla)
    REFERENCES plato (codPla)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_bebida1`
    FOREIGN KEY (bebida_codBe)
    REFERENCES bebida (codBe)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (cliente_rutCli)
    REFERENCES cliente (rutCli)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



    INSERT INTO plato (codPla,nombrePla,precioPla) VALUES
    (1, 'Arroz con pollo',  3200),
    (2, 'Cazuela de vacuno',  3500),
    (3, 'Lentejas con longaniza', 3000),
    (4, 'Porotos con riendas', 2000);
    
    INSERT INTO bebida (codBe,nombreBe,precioBe) VALUES
    (1, 'Mineral',  700),
    (2, 'Jugo',  800),
    (3, 'Malteada', 1000);
    
   
	INSERT INTO comuna (codComuna,nombreCom) VALUES
    (1,'Cerrillos'),
    (2,'Conchali'),
    (3,'Huechuraba'),
    (4,'Independencia'),
    (5,'La Cisterna'),
    (6,'La Florida'),
    (7,'La Pintana'),
    (8,'La Reina'),
    (9,'Lo Prado'),
    (10,'Maipú'),
    (11,'Providencia');
   
    
    INSERT INTO cliente(rutCli,claveCli,nombreCli,apellidoPaternoCli,apellidoMaternoCli,direccionCli,numeracionCli,telefonoCli,comuna_codComuna) VALUES
    ('18840347-6','123','Antonio','Olguín','Fernández','Trizzano',2122,98767544,1),
    ('19326088-8','123','Juan','Román','Durán','La Pinta',2134,97645632,5);
    
	INSERT INTO pedido(codigoPe,despachoPe,totalPe,fechaHoraPe,plato_codPla,bebida_codBe,cliente_rutCli) VALUES
    (1,true,4000,'2016-02-20 20:00:02',1,2,'18840347-6');