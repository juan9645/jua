-----------------------
-- Generacion de tablas
-----------------------

CREATE TABLE Cliente(
    dni CHAR(8),
    nombres VARCHAR(50),
    apellidos VARCHAR(50),
    telefono VARCHAR(20),
    PRIMARY KEY (dni)
);

CREATE TABLE Cabecera_pedido(
    id_pedido NUMERIC(4),
    fecha_pedido VARCHAR(10),
    fecha_entrega VARCHAR(10),
    direccion_entrega VARCHAR(100),
    dni CHAR(8),
    PRIMARY KEY (id_pedido),
    FOREIGN KEY (dni) REFERENCES Cliente(dni)
);

CREATE TABLE Categoria(
    id_categoria NUMERIC(4),
    nombre VARCHAR(30),
    descripcion VARCHAR(100),
    PRIMARY KEY (id_categoria)
);

CREATE TABLE Producto(
    id_producto NUMERIC(4),
    nombre VARCHAR(50),
    descripcion VARCHAR(100),
    precio NUMERIC(7,2),
    stock NUMERIC(5),
    id_categoria NUMERIC(4),
    PRIMARY KEY (id_producto),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id_categoria)
);

CREATE TABLE Detalle_pedido(
    id_detalle NUMERIC(4),
    cantidad NUMERIC(4),
    estado CHAR(1),
    id_pedido NUMERIC(4),
    id_producto NUMERIC(4),
    PRIMARY KEY (id_detalle),
    FOREIGN KEY (id_pedido) REFERENCES Cabecera_pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

-------------------------
-- Insercion de registros
-------------------------

INSERT INTO Cliente VALUES
('74537241', 'Pedro', 'Fernandez García', '978546123'),
('71254863', 'Martin', 'Calle Sanchez', '945876321'),
('84571236', 'Manolo', 'Jimenez Tirado', '986532741');

INSERT INTO Categoria VALUES
(1, 'Medicamentos', 'Todo tipo de medicamentos'),
(2, 'Perfumerías', 'Gran variedad de perfumes'),
(3, 'Aseo personal', 'Diversidad de productos de asea personal');

INSERT INTO Producto VALUES
(1, 'Paracetamol', 'Tableta de 10 pastillas de 50mg', 3.00, 120, 1),
(2, 'Amoxicilina', 'Tableta de 8 pastillas de 10mg', 5.00, 80, 1),
(3, 'Fragantti vainilla', 'Colonia frasco 500mL', 9.90, 50, 2),
(4, 'Heno de pravia', 'Agua de colonia frasco 250mL', 14.90, 50, 2),
(5, 'Vitis medio', 'Cepillo dental', 1.00, 150, 3),
(6, 'Rexona Men Xtracool', 'Antitranspirante', 9.90, 70, 3);

INSERT INTO Cabecera_pedido VALUES
(1, '08-03-2021', '10-03-2021', 'Av. Brasil 4332', '74537241'),
(2, '02-04-2021', '06-04-2021', 'Av. Tomas Valle 1234','71254863'),
(3, '09-02-2021', '15-02-2021', 'Av. Universitaria 4321','84571236');

INSERT INTO Detalle_pedido VALUES
(1, 2, 'S', 1, 1),
(2, 2, 'P', 1, 1),
(3, 2, 'E', 1, 1),
(4, 1, 'S', 2, 4),
(5, 1, 'P', 2, 4),
(6, 1, 'E', 2, 4),
(7, 1, 'S', 3, 6),
(8, 1, 'P', 3, 6),
(9, 1, 'E', 3, 6);