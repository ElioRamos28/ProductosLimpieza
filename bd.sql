--ORACLE
CREATE USER USUARIO IDENTIFIED BY admin;
GRANT ALL PRIVILEGES TO  USUARIO;
--MYSQL
CREATE DATABASE TIENDA;
USE TIENDA;

--TABLA CATEGOR?A 
CREATE TABLE categoria(
id_categoria int primary key,
nombre_categoria varchar(50)
);

-- TABLA PRODUCTO
CREATE TABLE PRODUCTO(
id_producto int primary key,
nombre_producto varchar(75),
precio_producto int,
descripcion_producto varchar(200),
id_categoria int,
foreign key (id_categoria) references categoria(id_categoria)
);

CREATE SEQUENCE CATEGORIA_SEC
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE PRODUCTO_SEC
 START WITH     1
 INCREMENT BY   1;

INSERT INTO categoria(id_categoria, nombre_categoria)VALUES (CATEGORIA_SEC.NEXTVAL, 'Detergente líquido');
INSERT INTO categoria(id_categoria, nombre_categoria)VALUES (CATEGORIA_SEC.NEXTVAL, 'Detergente en polvo');
INSERT INTO producto(id_producto,nombre_producto, precio_producto, descripcion_producto, id_categoria) VALUES (PRODUCTO_SEC.NEXTVAL,'Omo', 3500, 'Quita manchas', 1);
INSERT INTO producto(id_producto,nombre_producto, precio_producto, descripcion_producto, id_categoria) VALUES (PRODUCTO_SEC.NEXTVAL,'Ariel', 4400, 'Quita manchas', 2);

SELECT * FROM PRODUCTO;
SELECT * FROM CATEGORIA;

DROP TABLE PRODUCTO;
DROP TABLE CATEGORIA;

DROP SEQUENCE CATEGORIA_SEC;
DROP SEQUENCE PRODUCTO_SEC;

SELECT * FROM producto WHERE id_producto=1;
SELECT MAX(id_producto) AS max_id FROM producto;

SELECT * FROM PRODUCTO PRO INNER JOIN CATEGORIA CAT ON CAT.ID_CATEGORIA = PRO.ID_CATEGORIA;