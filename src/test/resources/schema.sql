DROP TABLE IF EXISTS mercancia;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS cargo;

DROP SEQUENCE IF EXISTS seq_mercancia;

CREATE TABLE cargo (
	id_cargo INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	CONSTRAINT pk_cargo PRIMARY KEY (id_cargo)
);

CREATE TABLE usuario (
	id_usuario INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	edad INT NOT NULL,
	id_cargo INT NOT NULL,
	fecha_ingreso_empresa DATE NOT NULL DEFAULT CURRENT_DATE,
	fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
	CONSTRAINT fk_cargo_usario FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo)
);

CREATE SEQUENCE seq_mercancia
	MINVALUE 1
	START WITH 1
	INCREMENT BY 1
	NO CYCLE;

CREATE TABLE mercancia (
	id_mercancia INT NOT NULL DEFAULT nextval('seq_mercancia'::regclass),
	id_usuario_registra INT NOT NULL,
	nombre_producto VARCHAR(100) NOT NULL,
	cantidad INT NOT NULL,
	fecha_ingreso TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT pk_mercancia PRIMARY KEY (id_mercancia),
	CONSTRAINT fk_usuario_mercancia FOREIGN KEY (id_usuario_registra) REFERENCES usuario (id_usuario),
	CONSTRAINT chk_cantidad_mercancia CHECK (cantidad > 0),
	CONSTRAINT chk_fecha_ingreso_mercancia CHECK (fecha_ingreso < CURRENT_TIMESTAMP)
);
