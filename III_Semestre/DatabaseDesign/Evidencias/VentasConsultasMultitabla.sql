DROP DATABASE IF EXISTS ventas;
CREATE DATABASE ventas CHARACTER SET utf8mb4;
USE ventas;
CREATE TABLE cliente (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 apellido1 VARCHAR(100) NOT NULL,
 apellido2 VARCHAR(100),
 ciudad VARCHAR(100),
 categoría INT UNSIGNED
);
CREATE TABLE comercial (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 apellido1 VARCHAR(100) NOT NULL,
 apellido2 VARCHAR(100),
 comisión FLOAT
);
CREATE TABLE pedido (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 total DOUBLE NOT NULL,
 fecha DATE,
 id_cliente INT UNSIGNED NOT NULL,
 id_comercial INT UNSIGNED NOT NULL,
 FOREIGN KEY (id_cliente) REFERENCES cliente(id),
 FOREIGN KEY (id_comercial) REFERENCES comercial(id)
);
INSERT INTO cliente VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);
INSERT INTO cliente VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);
INSERT INTO cliente VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);
INSERT INTO cliente VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300);
INSERT INTO cliente VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);
INSERT INTO cliente VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);
INSERT INTO cliente VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);
INSERT INTO cliente VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);
INSERT INTO cliente VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);
INSERT INTO cliente VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);

INSERT INTO comercial VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);
INSERT INTO comercial VALUES(2, 'Juan', 'Gómez', 'López', 0.13);
INSERT INTO comercial VALUES(3, 'Diego','Flores', 'Salas', 0.11);
INSERT INTO comercial VALUES(4, 'Marta','Herrera', 'Gil', 0.14);
INSERT INTO comercial VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);
INSERT INTO comercial VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);
INSERT INTO comercial VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);
INSERT INTO comercial VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);


INSERT INTO pedido VALUES(1, 150.5, '2017-10-05', 5, 2);
INSERT INTO pedido VALUES(2, 270.65, '2016-09-10', 1, 5);
INSERT INTO pedido VALUES(3, 65.26, '2017-10-05', 2, 1);
INSERT INTO pedido VALUES(4, 110.5, '2016-08-17', 8, 3);
INSERT INTO pedido VALUES(5, 948.5, '2017-09-10', 5, 2);
INSERT INTO pedido VALUES(6, 2400.6, '2016-07-27', 7, 1);
INSERT INTO pedido VALUES(7, 5760, '2015-09-10', 2, 1);
INSERT INTO pedido VALUES(8, 1983.43, '2017-10-10', 4, 6);
INSERT INTO pedido VALUES(9, 2480.4, '2016-10-10', 8, 3);
INSERT INTO pedido VALUES(10, 250.45, '2015-06-27', 8, 2);
INSERT INTO pedido VALUES(11, 75.29, '2016-08-17', 3, 7);
INSERT INTO pedido VALUES(12, 3045.6, '2017-04-25', 2, 1);
INSERT INTO pedido VALUES(13, 545.75, '2019-01-25', 6, 1);
INSERT INTO pedido VALUES(14, 145.82, '2017-02-02', 6, 1);
INSERT INTO pedido VALUES(15, 370.85, '2019-03-11', 1, 5);
INSERT INTO pedido VALUES(16, 2389.23, '2019-03-11', 1, 5);

-- Consultas sobre una tabla

/* 1. Devuelve un listado con todos los pedidos que se han realizado. Los pedidos
 * deben estar ordenados por la fecha de realización, mostrando en primer
 * lugar los pedidos más recientes.
*/
SELECT * FROM pedido ORDER BY fecha DESC;

/* 2. Devuelve todos los datos de los dos pedidos de mayor valor */
SELECT * FROM pedido ORDER BY total DESC LIMIT 2;

/* 3. Devuelve un listado con los identificadores de los clientes que han realizado
 * algún pedido. Tenga en cuenta que no debe mostrar identificadores que estén
 * repetidos.
*/
SELECT DISTINCT(id_cliente) FROM pedido;

/* 4. Devuelve un listado de todos los pedidos que se realizaron durante el año
 * 2017, cuya cantidad total sea superior a 500€.
*/
SELECT * FROM pedido WHERE YEAR(fecha) = 2017 AND total > 500;


/* 5. Devuelve un listado con el nombre y los apellidos de los comerciales que
 * tienen una comisión entre 0.05 y 0.11.
*/
SELECT nombre, apellido1, apellido2 FROM comercial WHERE comisión BETWEEN 0.05 AND 0.11;

/* 6. Devuelve el valor de la comisión de mayor valor que existe en la
 * tabla comercial.
*/
SELECT MAX(comisión) FROM comercial;

/* 7. Devuelve el identificador, nombre y primer apellido de aquellos clientes cuyo
 * segundo apellido no es NULL. El listado deberá estar ordenado
 * alfabéticamente por apellidos y nombre.
*/
SELECT id, nombre, apellido1 FROM cliente WHERE apellido2 IS NOT NULL ORDER BY apellido1, nombre;

/* 8. Devuelve un listado de los nombres de los clientes que empiezan por A y terminan por n,
 * así como los nombres que empiezan por P, ordenados alfabéticamente.
*/
SELECT nombre FROM cliente WHERE (nombre LIKE 'A%n' OR nombre LIKE 'P%') ORDER BY nombre;

/* 9.Devuelve un listado de los nombres de los clientes que no empiezan por A,
 * ordenados alfabéticamente.
*/
SELECT nombre FROM cliente WHERE nombre NOT LIKE 'A%' ORDER BY nombre;

/* 10. Devuelve un listado con los nombres de los comerciales que terminan
 * por 'el' o 'o'. Tenga en cuenta que se deberán eliminar los nombres repetidos.
*/
SELECT DISTINCT nombre FROM comercial WHERE nombre LIKE '%el' OR nombre LIKE '%o';


-- Consultas multitabla (Composición interna)

/* 1. Devuelve un listado con el identificador, nombre y los apellidos de todos los
 * clientes que han realizado algún pedido. El listado debe estar ordenado
 * alfabéticamente y se deben eliminar los elementos repetidos
*/
SELECT DISTINCT c.id, c.nombre, c.apellido1, c.apellido2
FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.apellido1, c.apellido2, c.nombre;

/* 2. Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente,
 * mostrando todos los datos de los pedidos y del cliente, ordenados alfabéticamente
 * por el cliente
*/
SELECT 
	c.id AS cliente_id,
	c.nombre AS cliente_nombre,
	c.apellido1 AS cliente_apellido1,
	c.apellido2 AS cliente_apellido2,
	p.*
FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.apellido1, c.apellido2, c.nombre;

/* 3. Devuelve un listado que muestre todos los pedidos en los que ha
 * participado un comercial. El resultado debe mostrar todos los datos de los
 * pedidos y de los comerciales. El listado debe mostrar los datos de los
 * comerciales ordenados alfabéticamente
*/
SELECT 
	com.id AS comercial_id,
	com.nombre AS comercial_nombre,
	com.apellido1 AS comercial_apellido1,
	com.apellido2 AS comercial_apellido2,
	p.id AS producto_id,
	p.total AS producto_total,
	p.fecha AS producto_fecha,
	p.id_cliente
FROM comercial com
INNER JOIN pedido p ON com.id = p.id_comercial
ORDER BY com.apellido1, com.apellido2, com.nombre;

/* 4. Devuelve un listado que muestre todos los clientes, con todos los
 * pedidos que han realizado y los datos de los comerciales asociados a cada pedido
*/
SELECT
	c.id AS cliente_id,
	c.nombre AS cliente_nombre,
	c.apellido1 AS cliente_apellido1,
	c.apellido2 AS cliente_apellido2,
	p.id AS producto_id,
	p.total AS producto_total,
	p.fecha AS producto_fecha,
	com.id AS comercial_id,
	CONCAT(com.nombre, com.apellido1, COALESCE(com.apellido2, '')) AS comercial_nombre,
	com.comisión AS comercial_comision
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
LEFT JOIN comercial com ON p.id_comercial = com.id;

/* 5. Devuelve un listado de todos los clientes que realizaron un pedido durante
 * el año 2017, cuya cantidad esté entre 300 € y 1000 €.
*/
SELECT c.*
FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente
WHERE YEAR(p.fecha) = 2017 AND p.total BETWEEN 300 AND 1000;

/* 6. Devuelve el nombre y los apellidos de todos los comerciales que ha
 * participado en algún pedido realizado por María Santana Moreno
*/
SELECT DISTINCT com.nombre, com.apellido1, com.apellido2
FROM comercial com
INNER JOIN pedido p ON com.id = p.id_comercial
INNER JOIN cliente c ON p.id_cliente = c.id
WHERE c.nombre = 'María' AND c.apellido1 = 'Santana' AND c.apellido2 = 'Moreno';

/* 7. Devuelve el nombre de todos los clientes que han realizado algún pedido
 * con el comercial Daniel Sáez Vega.
*/
SELECT DISTINCT c.nombre
FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente
INNER JOIN comercial com ON p.id_comercial = com.id
WHERE com.nombre = 'Daniel' AND com.apellido1 = 'Sáez' AND com.apellido2 = 'Vega';

-- Consultas multitabla (Composición externa)

/* 1. Devuelve un listado con todos los clientes junto con los datos de los
 * pedidos que han realizado. Este listado también debe incluir los clientes que
 * no han realizado ningún pedido. El listado debe estar ordenado
 * alfabéticamente por el primer apellido, segundo apellido y nombre de los
 * clientes.
*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2, p.*
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
ORDER BY c.apellido1, c.apellido2, c.nombre;

/* 2. Devuelve un listado con todos los comerciales junto con los datos de los
 * pedidos que han realizado. Este listado también debe incluir los comerciales
 * que no han realizado ningún pedido. El listado debe estar ordenado
 * alfabéticamente por el primer apellido, segundo apellido y nombre de los
 * comerciales
*/
SELECT com.id, com.nombre, com.apellido1, com.apellido2, p.*
FROM comercial com
LEFT JOIN pedido p ON com.id = p.id_comercial
ORDER BY com.apellido1, com.apellido2, com.nombre;

/* 3. Devuelve un listado que solamente muestre los clientes que no han
 * realizado ningún pedido
*/
SELECT c.id, c.nombre, c.apellido1, c.apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id IS NULL;


/* 4. Devuelve un listado que solamente muestre los comerciales que no han
 * realizado ningún pedido.
*/
SELECT com.id, com.nombre, com.apellido1, com.apellido2
FROM comercial com
LEFT JOIN pedido p ON com.id = p.id_comercial
WHERE p.id IS NULL;


/* 5. Devuelve un listado con los clientes que no han realizado ningún pedido y
 * de los comerciales que no han participado en ningún pedido. Ordene el
 * listado alfabéticamente por los apellidos y el nombre. En en listado deberá
 * diferenciar de algún modo los clientes y los comerciales.
*/
SELECT 'Cliente' AS tipo, c.id, c.nombre, c.apellido1, c.apellido2
FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente
WHERE p.id IS NULL
UNION ALL
SELECT 'Comercial' AS tipo, com.id, com.nombre, com.apellido1, com.apellido2
FROM comercial com
LEFT JOIN pedido p ON com.id = p.id_comercial
WHERE p.id IS NULL
ORDER BY apellido1, apellido2, nombre;


/* 6. ¿Se podrían realizar las consultas anteriores con NATURAL LEFT JOIN o NATURAL
 * RIGHT JOIN? Justifique su respuesta
*/

/* No se pueden realizar las consultas anteriores con NATURAL LEFT JOIN o NATURAL
 * RIGHT JOIN, ya que estas cláusulas se utilizan para realizar la unión de tablas
 * basándose en columnas con el mismo nombre y no permiten el control total sobre qué
 * columnas se deben unir y en qué condiciones. Por lo tanto, las consultas anteriores
 * requieren el uso de cláusulas JOIN explícitas para lograr el resultado deseado.
*/


-- Subconsultas con operadores básicos de comparación:

/* 1. Devuelve un listado con todos los pedidos que ha realizado Adela Sala
 * Díaz. (Sin utilizar INNER JOIN).
*/
SELECT * 
FROM pedido 
WHERE id_cliente = (
	SELECT id 
	FROM cliente
	WHERE nombre = 'Adela' 
		AND apellido1 = 'Salas'
		AND apellido2 = 'Díaz'
);

/* 2. Devuelve el número de pedidos en los que ha participado el comercial
 * Daniel Sáez Vega. (Sin utilizar INNER JOIN)
*/
SELECT COUNT(*)
FROM pedido
WHERE id_comercial = (
	SELECT id
	FROM comercial
	WHERE nombre = 'Daniel'
		AND apellido1 = 'Sáez'
		AND apellido2 = 'Vega'
);

/* 3. Devuelve los datos del cliente que realizó el pedido más caro en el año
 * 2019. (Sin utilizar INNER JOIN)
*/
SELECT *
FROM cliente
WHERE id = (
	SELECT id_cliente
	FROM pedido
	WHERE fecha BETWEEN '2019-01-01' AND '2019-12-31'
	ORDER BY total DESC LIMIT 1
);


/* 4. Devuelve la fecha y la cantidad del pedido de menor valor realizado por el
 * cliente Pepe Ruiz Santana
*/
SELECT fecha, total
FROM pedido
WHERE id_cliente = (
	SELECT id
	FROM cliente
	WHERE nombre = 'Pepe'
		AND apellido1 = 'Ruiz'
		AND apellido2 = 'Santana'
)
ORDER BY total ASC
LIMIT 1;

/* 5. Devuelve un listado con los datos de los clientes y los pedidos, de todos los
 * clientes que han realizado un pedido durante el año 2017 con un valor
 * mayor o igual al valor medio de los pedidos realizados durante ese mismo
 * año
*/
SELECT c.*, p.*
FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente
WHERE YEAR(p.fecha) = 2017
	AND p.total >= (
		SELECT AVG(total)
		FROM pedido
		WHERE YEAR(fecha) = 2017
);