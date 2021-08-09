INSERT INTO cargo (id_cargo, nombre) VALUES (1, 'Asesor de ventas');
INSERT INTO cargo (id_cargo, nombre) VALUES (2, 'Administrador');
INSERT INTO cargo (id_cargo, nombre) VALUES (3, 'Soporte');

INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (1, 'Luis Graciano', 19, 3, TO_DATE('01/01/2020', 'DD/MM/YYYY'));
INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (2, 'Usuario Prueba 1', 20, 2, TO_DATE('01/01/2020', 'DD/MM/YYYY'));
INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (3, 'Usuario Prueba 2', 39, 1, TO_DATE('01/01/2020', 'DD/MM/YYYY'));

INSERT INTO mercancia (id_mercancia, nombre_producto, id_usuario_registra, cantidad, fecha_ingreso) VALUES (nextval('seq_mercancia') , 'Producto 1', 1, 43, TO_DATE('01/08/2020', 'DD/MM/YYYY'));
INSERT INTO mercancia (id_mercancia, nombre_producto, id_usuario_registra, cantidad, fecha_ingreso) VALUES (nextval('seq_mercancia') , 'Producto 2', 1, 43, TO_DATE('02/08/2020', 'DD/MM/YYYY'));
INSERT INTO mercancia (id_mercancia, nombre_producto, id_usuario_registra, cantidad, fecha_ingreso) VALUES (nextval('seq_mercancia') , 'Producto 3', 2, 43, TO_DATE('01/08/2020', 'DD/MM/YYYY'));
INSERT INTO mercancia (id_mercancia, nombre_producto, id_usuario_registra, cantidad, fecha_ingreso) VALUES (nextval('seq_mercancia') , 'Producto 4', 3, 43, TO_DATE('01/08/2020', 'DD/MM/YYYY'));

COMMIT;