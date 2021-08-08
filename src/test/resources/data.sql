INSERT INTO cargo (id_cargo, nombre) VALUES (1, 'Asesor de ventas');
INSERT INTO cargo (id_cargo, nombre) VALUES (2, 'Administrador');
INSERT INTO cargo (id_cargo, nombre) VALUES (3, 'Soporte');

INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (1, 'Luis Graciano', 19, 3, TO_DATE('01/01/2020', 'DD/MM/YYYY'));
INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (2, 'Usuario Prueba 1', 20, 2, TO_DATE('01/01/2020', 'DD/MM/YYYY'));
INSERT INTO usuario (id_usuario, nombre, edad, id_cargo, fecha_ingreso_empresa) VALUES (3, 'Usuario Prueba 2', 39, 1, TO_DATE('01/01/2020', 'DD/MM/YYYY'));

COMMIT;