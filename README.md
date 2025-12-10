# 🏧 LlorenteNoel-Cajero

[cite_start]Este repositorio aloja el proyecto final **Cajero Automático**, un sistema de software desarrollado en Java que simula la operatividad real de una entidad bancaria automatizada[cite: 1, 11]. [cite_start]El sistema gestiona la interacción segura entre usuarios, tarjetas, cuentas y el propio cajero mediante una conexión a base de datos MySQL[cite: 11, 1131].

## 📋 Descripción del Proyecto

[cite_start]El objetivo principal es replicar la lógica de negocio de un cajero automático, permitiendo la gestión de transacciones financieras y la administración del sistema[cite: 12]. [cite_start]El proyecto implementa una arquitectura que conecta una interfaz gráfica (GUI) con una base de datos relacional para asegurar la persistencia de los datos[cite: 14].

[cite_start]Incluye validaciones de seguridad, cifrado de credenciales y diferenciación de roles (Usuario vs. Administrador)[cite: 31, 428].

## ✨ Características y Funcionalidades

El sistema divide las operaciones según el rol del usuario logueado:

### 👤 Usuario Corriente (Cliente)
[cite_start]Acceso mediante autenticación con DNI y PIN de tarjeta[cite: 458].
* [cite_start]**Ingresar Dinero:** Depósito de fondos con validación de entrada[cite: 63, 64].
* [cite_start]**Retirar Dinero:** Extracción de efectivo controlando el límite (máx. 500€) y el saldo disponible[cite: 60, 61, 362].
* [cite_start]**Consultar Saldo:** Visualización en tiempo real del dinero en cuenta[cite: 70].
* [cite_start]**Historial de Movimientos:** Tabla detallada con fecha, hora, tipo de operación y cantidad[cite: 69, 476].
* [cite_start]**Cambio de PIN:** Funcionalidad para actualizar la clave de seguridad de la tarjeta[cite: 66, 371].

### 🛠️ Usuario Administrador
[cite_start]Acceso privilegiado para la gestión integral del banco[cite: 31, 300].
* [cite_start]**Gestión de Usuarios:** Crear, modificar, eliminar y buscar usuarios (filtro por DNI, nombre, etc.)[cite: 31, 494].
* [cite_start]**Gestión de Tarjetas:** Administración de tarjetas, asignación de PIN y fechas de caducidad[cite: 31, 504].
* [cite_start]**Gestión de Cuentas:** Administración de cuentas bancarias y vinculación con tarjetas[cite: 31, 515].
* [cite_start]**Gestión del Cajero:** Visualización y recarga del saldo físico disponible en la máquina[cite: 31, 534].

## 🛠️ Tecnologías Utilizadas

* [cite_start]**Lenguaje:** Java[cite: 11].
* [cite_start]**Interfaz Gráfica:** Java Swing (Ventanas, Botones, JTable)[cite: 461, 478].
* [cite_start]**Base de Datos:** MySQL (Motor InnoDB)[cite: 1131, 1134].
* [cite_start]**Diseño:** MySQL Workbench para el modelado Entidad-Relación[cite: 1131].
* [cite_start]**Seguridad:** Algoritmo de encriptación AES para los pines[cite: 1147].

## 🚀 Instalación y Configuración

### 1. Requisitos Previos
* Java Development Kit (JDK) instalado.
* Servidor MySQL en ejecución.
* Un entorno de desarrollo (IDE) como IntelliJ, Eclipse o NetBeans.

### 2. Configuración de la Base de Datos
El proyecto requiere una base de datos llamada `cajero`. [cite_start]Ejecuta el siguiente script SQL (extraído de la documentación) para crear las tablas e insertar datos de prueba[cite: 1133, 1134, 1145]:

```sql
CREATE SCHEMA IF NOT EXISTS `cajero`;
USE `cajero`;

-- Tabla Cajero
CREATE TABLE IF NOT EXISTS `cajero` (
  `id` INT NOT NULL,
  `saldo` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`));

-- Tabla Usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `apellidos` VARCHAR(40) NOT NULL,
  `fecha_nac` DATE NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `direccion` VARCHAR(30) NOT NULL,
  `tipo_usuario` INT NOT NULL,
  PRIMARY KEY (`dni`));

-- Tabla Tarjeta
CREATE TABLE IF NOT EXISTS `tarjeta` (
  `id` VARCHAR(17) NOT NULL,
  `pin` TEXT NOT NULL,
  `cvv` VARCHAR(4) NOT NULL,
  `fecha_caducidad` DATE NOT NULL,
  `dni_usuario` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dni_usuario`) REFERENCES `usuario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE);

-- Tabla Cuenta
CREATE TABLE IF NOT EXISTS `cuenta` (
  `id` VARCHAR(21) NOT NULL,
  `nombre` VARCHAR(20) NOT NULL,
  `saldo` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`));

-- (Resto de tablas relacionales: tarjeta_cuenta, operacion, historial_cuenta según documentación)

[cite_start]-- DATOS DE PRUEBA [cite: 1145, 1147]
INSERT INTO CAJERO VALUES(1, 10000);
INSERT INTO OPERACION VALUES(1, "Ingresar Saldo"), (2, "Retirar Saldo");
-- Usuario Admin (tipo 2) y Normal (tipo 1)
INSERT INTO USUARIO VALUES("Y1234567K", "Noel", "Llorente", '2004-02-01', "123456789", "Calle López", 1);
INSERT INTO USUARIO VALUES("L12345678", "Pepe", "Ramírez", '1990-01-05', "333444555", "Calle Perez", 2);
-- Tarjetas (PIN '1234' encriptado)
INSERT INTO TARJETA VALUES("123456789", HEX(AES_ENCRYPT("1234", "admin")), "512", '2025-04-05', "123456788");
