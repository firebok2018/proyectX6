CREATE DATABASE bd_agenda

USE bd_agenda

CREATE TABLE tb_agenda (
  idagenda int(11) NOT NULL AUTO_INCREMENT,
  apellidos varchar(45) DEFAULT NULL,
  nombres varchar(45) DEFAULT NULL,
  direccion varchar(45) DEFAULT NULL,
  edad int(11) DEFAULT NULL,
  fechadenacimiento date,
  PRIMARY KEY (idagenda)
) 

SELECT * FROM tb_agenda

insert into tb_agenda values(null,'Gonzales','Patricia','Av. Independencia',33, '2017/05/05');
insert into tb_agenda values(null,'Salas','Dominic','Av. Goyeneche',38, '2018/03/01');
insert into tb_agenda values(null,'Holguin','Rachel','Calle Moquegua',43, '2018/10/08');
insert into tb_agenda values(null,'Gonzales','Sergio','Urb. Bancarios',50, '2017/03/05');
insert into tb_agenda values(null,'Alcazar','Manuel','Calle Tucuman',25, '2018/08/03');