CREATE TABLE conta
(

id_conta int,
ag int not null,
cc varchar(30),
valor float not null,
bonus float,
PRIMARY KEY (cc),
FOREIGN KEY (id_conta) REFERENCES usuarios(id_usuario)
);