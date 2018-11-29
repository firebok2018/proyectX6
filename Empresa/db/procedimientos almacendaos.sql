//Sentencias DDL
create database Agenda;
use Agenda;
create table Agenda.contactos(nombre varchar(45),telefono varchar(12),email varchar(50),id_contacto int primary key)TYPE=MyISAM; //se puede usar también InnoDB
 
//Sentencias DML
insert into Agenda.contactos values ('Almino','7221312567','gato.balin@yahoo.com.mx',1),('Anita','7227843213','anitayanoesanita@yahoo.com.mx',2);
select *from Agenda.contactos;
update Agenda.contactos set nombre='AlmaGato',telefono='7221312456' where id_contacto=1;
delete *from Agenda.contactos where nombre='Anita';
 
 
//Insertar
DELIMITER $$
DROP PROCEDURE IF EXIST `agenda`.`Insertar`$$
CREATE PROCEDURE `agenda`.`Insertar`(in nombre varchar(45), telefono varchar(12), email varchar(50), id_contacto int primary key)
BEGIN
/*DECLARE nombre varchar(45)*/
INSERT INTO contactos VALUES (nombre,telefono,email,id_contacto);
END $$
DELIMITER ;
 
//Borrar
DELIMITER $$
DROP PROCEDURE IF EXIST `agenda`.`Borrar`$$
CREATE PROCEDURE `agenda`.`Borrar`(in ident integer)
BEGIN
   DELETE FROM contactos id_contacto=ident;
END $$
DELIMITER ;
 
//Actualizar
DELIMITER $$
DROP PROCEDURE IF EXIST `agenda`.`Actualizar`$$
CREATE PROCEDURE `agenda`.`Actualizar`(in ident integer,ntelefono varchar(12))
BEGIN
UPDATE contactos SET telefono=ntelefono WHERE id_contacto=ident;
END $$
DELIMITER ;
 
//Para invocar
CALL Insertar('Fernando Carraro Aguirre','7221312686','carraro.fernando@gmail.com',1);
select *from Agenda.contactos;
 
CALL Borrar(1);
select *from Agenda.contactos;
 
CALL Actualizar(1,'7221312453');
select *from Agenda.contactos;
 
//más ejemplos
DELIMITER $$
DROP PROCEDURE IF EXIST `agenda`.`tipoUsuarios`$$
CREATE PROCEDURE `agenda`.`tipoUsuarios`(in no_cta integer)
BEGIN
DECLARE tipoUsuario char(15);
 
 IF no_cta=17 THEN
   SET tipoUsuario='Admin';
 ELSE
    SET tipoUsuario='Invitado';
 END IF;
 
INSERT INTO usuarios(tipoUsuario);
END $$
DELIMITER ;
 
//Invocar
CALL tipoUsuarios(12);//resultado='Invitado'
CALL tipoUsuarios(17);//resultado='Admin'