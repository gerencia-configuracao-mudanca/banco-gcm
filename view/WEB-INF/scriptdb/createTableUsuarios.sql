CREATE TABLE usuarios     (
     id_usuario int AUTO_INCREMENT not null UNIQUE,
     nome varchar(30),
     senha varchar(30),
     PRIMARY KEY (nome)
     );