# Sistema de Control de Acceso a Laboratorio

## Descripción

Este proyecto consiste en el desarrollo de una aplicación en Java con arquitectura por capas que permite gestionar el acceso de usuarios a un laboratorio técnico.

El sistema permite registrar usuarios, controlar entradas y salidas, y generar reportes sobre el uso del laboratorio.

---

## Funcionalidades

- Registro de usuarios (ID, nombre, rol)
- Consulta de usuarios
- Eliminación de usuarios
- Registro de entrada al laboratorio
- Registro de salida del laboratorio
- Historial de accesos por usuario
- Cálculo del tiempo total dentro del laboratorio

---

## Arquitectura del sistema

El proyecto está desarrollado utilizando arquitectura por capas:

- **Entidades** → Representación de datos (Usuario, AccesoLaboratorio)
- **AccesoDatos** → Manejo de archivos (.txt)
- **LogicaNegocio** → Validaciones y reglas del sistema
- **Presentacion** → Interfaz de usuario (menú por consola)

Restricción cumplida:
La capa de presentación no accede directamente a acceso de datos.

---

## Estructura del proyecto

src/
├── Entidades/
├── AccesoDatos/
├── LogicaNegocio/
└── Presentacion/

usuarios.txt
accesos.txt

---

## Persistencia

El sistema utiliza archivos de texto para almacenar la información:

- usuarios.txt
- accesos.txt

No se utilizan bases de datos.

---

## Validaciones implementadas

- No se permiten IDs duplicados
- No se permiten datos incompletos
- No se permite registrar salida sin entrada previa
- No se permite doble entrada sin salida

---

## Tecnologías utilizadas

- Java
- NetBeans IDE 21
- Visual Studio Code
- Git y GitHub Desktop

---

## Ejecución

1. Ejecutar la clase Main.java
2. Utilizar el menú para interactuar con el sistema

---

## Autor

Rhoswen Mora Valverde