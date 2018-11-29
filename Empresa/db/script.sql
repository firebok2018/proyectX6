drop database  if exists Empresa; 

create database Empresa;

use Empresa;


create table tipoUsuario(
id_tipo int(11) primary key,
nomTipo varchar(45)
);


create table Usuarios(
idUser char(5) primary key ,
Usuario char(5) Unique,
pwdUser varchar(45),
Correo varchar(45),
nomUser varchar(45),
apeUser varchar(60),
last_Sesion varchar(30),
time_SignIn varchar(30),
id_tipo int(11) ,
idCon boolean,
idAct boolean,
idCons boolean,
foreign key (id_tipo) references tipoUsuario(id_tipo)
);




create table TipoMesa(
idTipo int(11) primary key,
nomTipo varchar(40)
);
create table NumMesa(
idMesa char(5) not null,
numMesa int(11) primary key,
numSillas int(11) default 4,
estado int(11),
foreign key (estado) references TipoMesa(idTipo)
);

create table TipoProductos(
idTipo_Pro int(11) primary key,
nomTip_pro varchar(45)
);
create table Productos(
CodPro char(5) primary key ,
nomPro varchar(45),
idTipo_Pro int(11),
stock int(11),
precio double,
foreign key(idTipo_Pro) references TipoProductos(idTipo_Pro)
);
create table menu(
idMenu int(11) primary key,
nomMenu varchar(45),
foreign key (idMenu) references TipoProductos(idTipo_Pro)
);
create table Bebidas(
idBebida int(11) primary key,
nomBebida varchar(45),
foreign key (idBebida) references TipoProductos(idTipo_Pro)
);
create table Extras(
idExtras int(11) primary key,
nomExtras varchar(45),
foreign key (idExtras) references TipoProductos(idTipo_Pro)
);
create table Clientes(
CodCli char(5) primary key,
dniCli int(8),
nomCli varchar(45),
apeCli varchar(65),
telefono int(9),
numMesa int(11),
estado  int(11),
foreign key (numMesa) references NumMesa(numMesa),
foreign key (estado) references TipoMesa(idTipo)
);

create table Platillos(
numVenta char(5) primary key,
nomCli char(5),
nomX varchar(80),
tipo varchar(30),
descripcion varchar(100),
cant int(11) default 1,
nomV char(5),
foreign key (nomCli) references Clientes(CodCli),
foreign key (nomV) references Usuarios(Usuario)
);

#drop table TipoMesa;
#drop table nummesa;
#drop table Productos;
#drop table Clientes;
#drop table Platillos;
#drop table Usuarios;

select*from tipoUsuario;
select*from Usuarios;
select*from NumMesa;
select*from TipoMesa;
select*from TipoProductos;
select*from Productos;
select*from Clientes;
select*from platillos;



#select*from tb_Usuario where Usuario = ? and pwdUser= ?
#drop database tb_Usuario

#por defecto

insert into tipoUsuario values(0,'Usuario');
insert into tipoUsuario values(1,'Administrador');

insert into TipoMesa values(0,'libre');
insert into TipoMesa values(1,'Disponible');
insert into TipoMesa values(2,'Completo');

insert into TipoProductos values(0,'Menú');
insert into TipoProductos values(1,'Bebidas');
insert into TipoProductos values(2,'Extras');




#CRUD DE LA TABLA TIPOS USUARIOS
delimiter $$
drop procedure if exists add_User $$
create procedure add_User(codUsr char(5),Usr char(5),pwd varchar(5000),email varchar(45),
nom varchar(45),ape varchar(60),ls varchar(30),tm varchar(30),prv int(2),c boolean,a boolean,cn boolean)
begin
	INSERT INTO Usuarios values(codUsr,Usr,sha1(pwd),email,nom,ape,ls,tm,prv,c,a,cn);
end $$
delimiter ;
#call add_User('U0005','WIFKD','sad','Correo@gamil.com','Wil klinghton','Incacutipa flores',curdate(),curtime(),0,0,0,0);

delimiter $$
drop procedure if exists update_User $$
create procedure update_User(cUsr char(5),Usr char(5),pwd varchar(5000),email varchar(45),
nom varchar(45),ape varchar(60),ls varchar(30),tm varchar(30),prv int(2),c boolean,a boolean,cn boolean)
begin
	update usuarios set idUser=cUsr,Usuario=Usr,pwdUser=sha1(pwd),Correo=email,
    nomUser=nom,apeUser=ape,last_Sesion=ls,time_SignIn=tm,id_tipo=prv,idCon=c,idAct=a,idCons=cn where idUser=cUsr;
end $$
delimiter ;
call update_User('U0001','WIFKG','sad','Correo@gamil.com','Wil klinghton','Incacutipa flores',curdate(),curtime(),0,0,0,0);

delimiter $$
drop procedure if exists delete_user $$
create procedure delete_user(xuser char(5))
begin
	delete from usuarios where idUser=xuser;
end $$
delimiter ;
call delete_user('U0006');


delimiter $$
drop procedure if exists ls_user $$
create procedure ls_user()
begin
SELECT*FROM usuarios;
end $$
delimiter ;
CALL LS_USER();

#CRUD DE LA TABLA NUMMESA
select*from NumMesa;
delimiter $$
DROP PROCEDURE IF EXISTs ls_mesa $$
create procedure ls_mesa()
begin
	select*from NumMesa;
end $$
delimiter ;
call ls_mesa();

DELIMITER $$
DROP PROCEDURE IF EXISTs add_mesa $$
CREATE PROCEDURE add_mesa(cod char(5),num int(11),sillas INT(11),estado int(11))
begin
	INSERT INTO NumMesa VALUES(cod,num,sillas,estado);
end $$
delimiter ;

delimiter $$
DROP PROCEDURE IF EXISTs update_mesa $$
create procedure update_mesa(c char(5),n int(11),s INT(11),e int(11))
begin
	update NumMesa set idMesa=c,numMesa=n,numSillas=s,estado=e where numMesa=n;
end $$
delimiter ;
call update_mesa('M0005',5,8,2);

delimiter $$
drop procedure if exists delete_mesa $$
create procedure delete_mesa(num int(11))
begin
	delete from NumMesa where numMesa=num;
end $$
delimiter ;
call delete_mesa(10);

DELIMITER $$
DROP PROCEDURE IF EXISTs num_mesa $$
create procedure num_mesa(num int(11))
begin
	select (numSillas) from NumMesa where numMesa=num;
end $$
delimiter ;

#call num_mesa (1);

#CRUD DEL LA TABLA PRODUCTOS
select*from productos;
delimiter $$
DROP PROCEDURE IF EXISTs add_producto $$
create procedure add_producto(cod char(5),nom varchar(45),tipo int(11),stock int(11),precio double)
begin
	insert into productos  values (cod,nom,tipo,stock,precio);
end $$
delimiter ;
#call add_producto('P0001','ceviche',1,2,5.0);

delimiter $$
DROP PROCEDURE IF EXISTs update_producto $$
create procedure update_producto(c char(5),n varchar(45),t int(11),s int(11),p double)
begin
	update productos set CodPro=c,nomPro=n,idTipo_pro=t,stock=s,precio=p where CodPro=c;
end $$
delimiter ;
#call update_producto('P0001','ceviche de tiburon',2,2,20);

delimiter $$
DROP PROCEDURE IF EXISTs delete_producto $$
create procedure delete_producto(cod char(5))
begin
	delete from productos where CodPro=cod;
end $$
delimiter ;
#call delete_producto('P0002');

delimiter $$
DROP PROCEDURE IF EXISTs ls_productos $$
create procedure ls_productos()
begin
	select*from productos;
end $$
delimiter ;
call ls_productos();


delimiter $$
DROP PROCEDURE IF EXISTs ls_TipoPro $$
create procedure ls_TipoPro()
begin
	select*from TipoProductos;
end $$
delimiter ;
call ls_TipoPro();



delimiter $$
DROP PROCEDURE IF EXISTs ls_MTipoPro $$
create procedure ls_MTipoPro(tip int(1))
begin
	select*from Productos where idTipo_Pro=tip;
end $$
delimiter ;
call ls_MTipoPro(0);

delimiter $$
DROP PROCEDURE IF EXISTs ls_BTipoPro $$
create procedure ls_BTipoPro(tip int(1))
begin
	select*from Productos where idTipo_Pro=tip;
end $$
delimiter ;
call ls_BTipoPro(1);
delimiter $$
DROP PROCEDURE IF EXISTs ls_ETipoPro $$
create procedure ls_ETipoPro(tip int(1))
begin
	select*from Productos where idTipo_Pro=tip;
end $$
delimiter ;
call ls_ETipoPro(2);

#CRUD DE LA TABLA CLIENTES

select*from Clientes;
delimiter $$
DROP PROCEDURE IF EXISTs add_cliente $$
create procedure add_cliente(cod char(5),dni int(8),nom varchar(45),apell varchar(65),fono int(9),mesa int(11) ,est int(11))
begin
	insert into Clientes values(cod,dni,nom,apell,fono,mesa,est);
end $$
delimiter ;
#call add_cliente('C0002',12345678,'my name','aplees comps',123456789,5,2);

delimiter $$
DROP PROCEDURE IF EXISTs update_cliente $$
create procedure update_cliente(c char(5),d int(8),n varchar(45),a varchar(65),f int(9),m int(11) ,e int(11))
begin
	update Clientes set CodCli=c,dniCli=d,nomCli=n,apeCli=a,telefono=f,numMesa=m,estado=e where CodCli=c;
end $$
delimiter ;
#call update_cliente('C0002',12345678,'my namesssssss','aplees cssomps',123456789,5,1);
delimiter $$
DROP PROCEDURE IF EXISTs delete_cliente $$
create procedure delete_cliente(cod char(5))
begin
	delete from Clientes where CodCli=cod;
end $$
delimiter ;  
#call delete_cliente('C0002');

delimiter $$
DROP PROCEDURE IF EXISTs ls_Cliente $$
create procedure ls_Cliente()
begin
	select*from Clientes;
end $$
delimiter ;
call ls_Cliente();


select*from usuarios;
#drop procedure  add_cliente;
#call add_cliente('Cl111',12345678,'nombre cli','apellido cli',123456789,1,2);

#CRUD DE LA TABLA USUARIOS
delimiter $$
DROP PROCEDURE IF EXISTs add_usuario $$
create procedure add_usuario(usr char(5),pw varchar(45),email varchar(50),nom varchar(45),ape varchar(60), d varchar(30),t varchar(30), priv int(11))
begin
	insert into usuarios values(null,usr,pw,email,nom,ape,d,t,priv);
end $$
delimiter ;
#call add_usuario('UCLI','password()','correo@gmail.com','wil klinghton','incautipa flores','23/11/2018 s','8:18 pm',1);

/*
delimiter $$
CREATE TRIGGER trigger_name BEFORE INSERT ON tabla_productos FOR EACH ROW
BEGIN
  DECLARE next_id INT(11);

  SET next_id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='tabla_productos');
  SET NEW.codigo_secundario = CONCAT('P', LPAD(next_id, 8, '0'));
END $$
delimiter ;
*/
#CRUD VENTAS




select*from platillos;
delimiter $$
DROP PROCEDURE IF EXISTs add_Platillos $$
create procedure add_Platillos(nVen char(5),nomc char(5),x varchar(80),tipo varchar(30),des varchar(100),cant int(11),usrV char(5))
begin
	insert into platillos values(nVen,nomc,x,tipo,des,cant,usrV);
end $$
delimiter ;
#call add_Platillos('V0001','C0001','Extras','nombre apellido','dss',4,'U0001');
#call add_Platillos('V0002','C0001','nombre apellido','Extras','dss',4,'U0001');

delimiter $$
DROP PROCEDURE IF EXISTs update_Venta $$
create procedure update_Venta(nV char(5),n char(5),x varchar(80),t varchar(30),d varchar(100),c int(11),u char(5))
begin
	update platillos set numVenta=nV,nomcli=n,nomX=x,tipo=t,descripcion=d,cant=c,nomV=u where nomV=u and numVenta=nV;
	#insert into platillos values(nV,n,x,t,o,c,u);
end $$
delimiter ;

#call update_Venta('V0005','C0001','Menu','arroz conpato','bebidasdas',4,'U0001');

delimiter $$
drop procedure if exists delete_venta $$
create procedure delete_venta(nv char(5),u char(5))
begin 
	delete from platillos where numVenta=nv and nomV=u;
end $$
delimiter ;
call delete_venta('V0004','U0001');

delimiter $$
drop procedure if exists ls_venta $$
create procedure ls_venta()
begin 
 select*from platillos;
end $$
delimiter ;
call ls_venta();
