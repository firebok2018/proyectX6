USE DEK_ELECTRIC;

-- CONSULTAS

-- CLIENTE

-- USP CLIENTE POR RUC O DNI
DROP PROCEDURE IF EXISTS USP_CONSULTA_CLIENTE_POR_RDN;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_CLIENTE_POR_RDN(RDN varchar(11))
BEGIN
	select * from tb_cliente C
	where C.rdn_cli like concat('%',RDN,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_CLIENTE_POR_RDN('7');

-- USP CLIENTE POR RAZÓN SOCIAL O NOMBRE
DROP PROCEDURE IF EXISTS USP_CONSULTA_CLIENTE_POR_RSN;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_CLIENTE_POR_RSN(RSN varchar(60))
BEGIN
	select * from tb_cliente C
	where C.rsn_cli like concat('%',RSN,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_CLIENTE_POR_RSN('ESCO');


-- PROVEEDOR

-- USP PROVEEDOR POR RUC
DROP PROCEDURE IF EXISTS USP_CONSULTA_PROVEEDOR_POR_RUC;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PROVEEDOR_POR_RUC(RUC varchar(11))
BEGIN
	select * from tb_proveedor P
	where P.ruc_prv like concat('%',RUC,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PROVEEDOR_POR_RUC('7');

-- USP PROVEEDOR POR RAZÓN SOCIAL
DROP PROCEDURE IF EXISTS USP_CONSULTA_PROVEEDOR_POR_RSO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PROVEEDOR_POR_RSO(RSO varchar(60))
BEGIN
	select * from tb_proveedor p 
	where p.rso_prv like concat('%',RSO,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PROVEEDOR_POR_RSO('I');

-- USP PROVEEDORES POR MARCA
DROP PROCEDURE IF EXISTS USP_CONSULTA_PROVEEDORES_POR_MARCA;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PROVEEDORES_POR_MARCA(DES VARCHAR(40))
BEGIN
	SELECT PR.* FROM tb_abastecimiento A
    INNER JOIN tb_proveedor PR ON A.cod_prv=PR.cod_prv
	INNER JOIN tb_producto PD ON A.cod_pro=PD.cod_pro
	INNER JOIN tb_marca M ON PD.cod_mar=M.cod_mar
	WHERE M.des_mar LIKE concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PROVEEDORES_POR_MARCA('I');


-- CUENTA BANCARIA

-- USP CUENTA BANCARIA POR RUC DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_CUENTA_BANCARIA_POR_RUC;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_CUENTA_BANCARIA_POR_RUC(RUC varchar(11))
BEGIN
	select C.* from tb_cuenta C
    inner join tb_proveedor P on C.cod_prv=P.cod_prv
	where P.ruc_prv like concat('%',RUC,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_CUENTA_BANCARIA_POR_RUC('7');

-- USP USP CUENTA BANCARIA POR RAZÓN SOCIAL DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_CUENTA_BANCARIA_POR_RSP;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_CUENTA_BANCARIA_POR_RSP(RSO varchar(60))
BEGIN
	select C.* from tb_cuenta C
    inner join tb_proveedor P on C.cod_prv=P.cod_prv
	where P.rso_prv like concat('%',RSO,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_CUENTA_BANCARIA_POR_RSP('D');


-- TRANSPORTISTA

-- USP TRANSPORTISTA POR RUC
DROP PROCEDURE IF EXISTS USP_CONSULTA_TRANSPORTISTA_POR_RUC;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_TRANSPORTISTA_POR_RUC(RUC varchar(11))
BEGIN
	select * from tb_transportista T
	where T.ruc_tra like concat('%',RUC,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_TRANSPORTISTA_POR_RUC('7');

-- USP TRANSPORTISTA POR RAZÓN SOCIAL
DROP PROCEDURE IF EXISTS USP_CONSULTA_TRANSPORTISTA_POR_RSO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_TRANSPORTISTA_POR_RSO(RSO varchar(60))
BEGIN
	select * from tb_transportista T 
	where T.rso_tra like concat('%',RSO,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_TRANSPORTISTA_POR_RSO('I');


-- PRODUCTO

-- USP PRODUCTO POR CÓDIGO
DROP PROCEDURE IF EXISTS USP_CONSULTA_PRODUCTO_POR_CODIGO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PRODUCTO_POR_CODIGO(COD int)
BEGIN
	select * from tb_producto P
	where P.cod_pro=COD;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PRODUCTO_POR_CODIGO(1);

-- USP PRODUCTO POR NOMBRE
DROP PROCEDURE IF EXISTS USP_CONSULTA_PRODUCTO_POR_NOMBRE;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PRODUCTO_POR_NOMBRE(DES varchar(50))
BEGIN
	select * from tb_producto P 
	where P.des_pro like concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PRODUCTO_POR_NOMBRE('CABLE');

-- USP PRODUCTO POR CATEGORÍA
DROP PROCEDURE IF EXISTS USP_CONSULTA_PRODUCTO_POR_CATEGORIA;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_PRODUCTO_POR_CATEGORIA(DES varchar(50))
BEGIN
	select P.* from tb_producto P
    inner join tb_categoria C on C.cod_cat=P.cod_cat
	where C.des_cat like concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_PRODUCTO_POR_CATEGORIA('inter');


-- VENTA

-- USP VENTA DE PRODUCTO POR MARCA
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_PRODUCTO_POR_MARCA;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_PRODUCTO_POR_MARCA(DES varchar(40))
BEGIN
	select M.des_mar, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' from tb_detalle_venta DV
    inner join tb_producto P on DV.cod_pro=P.cod_pro
    inner join tb_marca M on P.cod_mar=M.cod_mar
	where M.des_mar like concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_PRODUCTO_POR_MARCA('tizi');

-- USP VENTA DE PRODUCTO POR NOMBRE
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_PRODUCTO_POR_NOMBRE;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_PRODUCTO_POR_NOMBRE(DES varchar(50))
BEGIN
	select P.des_pro, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' from tb_detalle_venta DV
    inner join tb_producto P on DV.cod_pro=P.cod_pro    
	where P.des_pro like concat('%',DES,'%')
    group by P.des_pro;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_PRODUCTO_POR_NOMBRE('CABLE');

-- USP VENTA DE PRODUCTO POR RANGO DE FECHAS
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_POR_RANGO_FECHAS;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_POR_RANGO_FECHAS(INI date, FIN date)
BEGIN
	select V.num_ven, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' 
    from tb_venta V
    inner join tb_detalle_venta DV on V.num_ven=DV.num_ven
    inner join tb_producto P on DV.cod_pro=P.cod_pro    
	where V.fec_ven between INI and FIN
    group by V.num_ven;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_POR_RANGO_FECHAS('2000-04-10','2018-05-10');


-- USP VENTA POR NÚMERO
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_POR_NUMERO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_POR_NUMERO(NUM int)
BEGIN
	select V.num_ven, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' 
    from tb_venta V
    inner join tb_detalle_venta DV on V.num_ven=DV.num_ven
    inner join tb_producto P on DV.cod_pro=P.cod_pro    
    where V.num_ven=NUM
    group by V.num_ven;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_POR_NUMERO(1);

-- USP VENTA POR NOMBRE DE EMPLEADO
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_POR_EMPLEADO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_POR_EMPLEADO(APE varchar(30))
BEGIN
	select V.num_ven, E.ape_emp, E.nom_emp, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' 
    from tb_venta V
    inner join tb_detalle_venta DV on V.num_ven=DV.num_ven
    inner join tb_producto P on DV.cod_pro=P.cod_pro
    inner join tb_empleado E on V.cod_emp=E.cod_emp
	where E.ape_emp like concat('%',APE,'%')
    group by V.num_ven, E.ape_emp, E.nom_emp;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_POR_EMPLEADO('a');

-- USP VENTA POR ESTADO
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_POR_ESTADO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_POR_ESTADO(EST char(1))
BEGIN
	select V.num_ven, V.est_ven, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' 
    from tb_venta V
    inner join tb_detalle_venta DV on V.num_ven=DV.num_ven
    inner join tb_producto P on DV.cod_pro=P.cod_pro    
	where V.est_ven=EST
    group by V.num_ven, V.est_ven;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_POR_ESTADO('0');

-- USP VENTA POR NOMBRE DE CLIENTE
DROP PROCEDURE IF EXISTS USP_CONSULTA_VENTA_POR_CLIENTE;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_VENTA_POR_CLIENTE(RSN varchar(60))
BEGIN
	select V.num_ven, C.rsn_cli, sum(DV.can_ven) AS 'Cantidad', sum(DV.can_ven*P.pre_pro) AS 'Total' 
    from tb_venta V
    inner join tb_detalle_venta DV on V.num_ven=DV.num_ven
    inner join tb_producto P on DV.cod_pro=P.cod_pro
    inner join tb_cliente C on V.cod_cli=C.cod_cli
	where C.rsn_cli like concat('%',RSN,'%')
    group by V.num_ven, C.rsn_cli;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_VENTA_POR_CLIENTE('I');


-- ORDEN DE COMPRA

-- USP ORDEN DE COMPRA POR RUC DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_ORDEN_COMPRA_POR_RUC;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ORDEN_COMPRA_POR_RUC(RUC varchar(11))
BEGIN
	select OC.num_oco, OC.fec_oco, P.ruc_prv, P.rso_prv from tb_orden_compra OC
    inner join tb_proveedor P on OC.cod_prv=P.cod_prv
	where P.ruc_prv like concat('%',RUC,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ORDEN_COMPRA_POR_RUC('7');

-- USP ORDEN DE COMPRA POR RAZÓN SOCIAL DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_ORDEN_COMPRA_POR_RSO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ORDEN_COMPRA_POR_RSO(RSO varchar(60))
BEGIN
	select OC.num_oco, OC.fec_oco, P.ruc_prv, P.rso_prv from tb_orden_compra OC
    inner join tb_proveedor P on OC.cod_prv=P.cod_prv
	where P.rso_prv like concat('%',RSO,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ORDEN_COMPRA_POR_RSO('a');

-- USP ORDEN DE COMPRA POR NOMBRE DE PRODUCTO
DROP PROCEDURE IF EXISTS USP_CONSULTA_ORDEN_COMPRA_POR_PRODUCTO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ORDEN_COMPRA_POR_PRODUCTO(DES varchar(50))
BEGIN
	select OC.num_oco, OC.fec_oco, P.des_pro, DC.can_ped
    from tb_orden_compra OC
    inner join tb_detalle_compra DC on OC.num_oco=DC.num_oco
    inner join tb_producto P on DC.cod_pro=P.cod_pro
	where P.des_pro like concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ORDEN_COMPRA_POR_PRODUCTO('a');

-- USP ORDEN DE COMPRA POR NÚMERO DE O.C.
DROP PROCEDURE IF EXISTS USP_CONSULTA_ORDEN_COMPRA_POR_NUMERO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ORDEN_COMPRA_POR_NUMERO(NUM int)
BEGIN
	select * from tb_orden_compra OC    
	where OC.num_oco=NUM;
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ORDEN_COMPRA_POR_NUMERO(2);


-- ABASTECIMIENTO

-- USP ABASTECIMIENTO POR RUC DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_ABASTECIMIENTO_POR_RUC;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ABASTECIMIENTO_POR_RUC(RUC varchar(11))
BEGIN
	select PV.ruc_prv, PV.rso_prv, PD.des_pro, A.pre_aba from tb_abastecimiento A
    inner join tb_proveedor PV on A.cod_prv=PV.cod_prv
    inner join tb_producto PD on A.cod_pro=PD.cod_pro
	where PV.ruc_prv like concat('%',RUC,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ABASTECIMIENTO_POR_RUC('7');

-- USP ABASTECIMIENTO POR RAZÓN SOCIAL DE PROVEEDOR
DROP PROCEDURE IF EXISTS USP_CONSULTA_ABASTECIMIENTO_POR_RSO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ABASTECIMIENTO_POR_RSO(RSO varchar(60))
BEGIN
	select PV.ruc_prv, PV.rso_prv, PD.des_pro, A.pre_aba from tb_abastecimiento A
    inner join tb_proveedor PV on A.cod_prv=PV.cod_prv
    inner join tb_producto PD on A.cod_pro=PD.cod_pro
	where PV.rso_prv like concat('%',RSO,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ABASTECIMIENTO_POR_RSO('A');

-- USP ABASTECIMIENTO POR NOMBRE DE PRODUCTO
DROP PROCEDURE IF EXISTS USP_CONSULTA_ABASTECIMIENTO_POR_PRODUCTO;
DELIMITER $$
CREATE PROCEDURE USP_CONSULTA_ABASTECIMIENTO_POR_PRODUCTO(DES varchar(50))
BEGIN
	select PV.ruc_prv, PV.rso_prv, PD.des_pro, A.pre_aba from tb_abastecimiento A
    inner join tb_proveedor PV on A.cod_prv=PV.cod_prv
    inner join tb_producto PD on A.cod_pro=PD.cod_pro
	where PD.des_pro like concat('%',DES,'%');
END $$
DELIMITER ;
-- PROBAR CONSULTA
CALL USP_CONSULTA_ABASTECIMIENTO_POR_PRODUCTO('A');

-- USP VALIDACIÓN DE ACCESO
DROP PROCEDURE IF EXISTS USP_VALIDAR_ACCESO;
DELIMiTER $$
CREATE PROCEDURE USP_VALIDAR_ACCESO(LOG varchar(8), PAS varchar(8))
BEGIN
select E.ape_emp, E.nom_emp, U.log_usu from tb_usuario U
inner join tb_empleado E on U.cod_emp=E.cod_emp
where U.log_usu = LOG and U.pas_usu = PAS;
END $$
DELIMiTER ;

CALL USP_VALIDAR_ACCESO ('diego','diego');
