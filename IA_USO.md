# IA_USO.md

## Uso de Inteligencia Artificial en el desarrollo

Durante el desarrollo de este proyecto se utilizó inteligencia artificial como herramienta de apoyo para guiar el proceso de construcción del sistema.

El uso de IA se realizó de forma progresiva y por partes, nunca generando el sistema completo en un solo prompt. Se utilizó principalmente para:

- organizar la arquitectura por capas
- generar ejemplos de código base
- definir validaciones del sistema
- orientar el uso de archivos .txt como persistencia
- apoyar en la documentación

El código final fue revisado, adaptado y probado manualmente, asegurando que cumpliera con todos los requisitos del enunciado.

---

## Prompts utilizados y aplicación

### Prompt 1: Estructura del proyecto

> Vamos a desarrollar un sistema en Java llamado "Sistema de Control de Acceso a Laboratorio". Necesito que me ayude a organizar el proyecto utilizando arquitectura por capas (Entidades, AccesoDatos, LogicaNegocio, Presentacion). No quiero que me genere todo el sistema de una vez, solo la estructura y qué debería ir en cada capa.

**Resultado:**
- Definición de las capas del proyecto
- Distribución de responsabilidades

**Ajustes manuales:**
- Se crearon los paquetes manualmente en NetBeans
- Se ajustaron nombres de clases según el problema
- Se organizó el proyecto de forma clara para que coincidiera con lo que pide el curso

---

### Prompt 2: Entidades

> Ahora vamos a trabajar la capa de entidades. Necesito crear las clases Usuario y AccesoLaboratorio en Java. Ayúdeme a definir los atributos necesarios para este sistema, incluyendo ID, nombre, rol, fecha de entrada y salida. No me genere lógica todavía, solo las clases bien estructuradas.

**Resultado:**
- Estructura base de Usuario y AccesoLaboratorio

**Ajustes manuales:**
- Se cambiaron algunos nombres de variables para que fueran más claros
- Se agregó el método toArchivo() para poder guardar en .txt
- Se revisaron los constructores y getters/setters manualmente

---

### Prompt 3: Acceso a datos

> Ahora vamos a trabajar la capa de acceso a datos. Necesito una clase en Java que me permita leer, escribir y agregar datos en archivos .txt. El sistema no puede usar base de datos, así que todo debe manejarse con archivos. Explíqueme cómo hacerlo y ayúdeme con la base de los métodos.

**Resultado:**
- Idea general de la clase AccesoDatos
- Métodos para leer, escribir y agregar líneas

**Ajustes manuales:**
- Se implementó el manejo de archivos inexistentes
- Se adaptó el formato de lectura a lo que ocupaba el sistema
- Se probó manualmente para evitar errores de lectura

---

### Prompt 4: Lógica de usuarios

> Ahora vamos con la lógica de negocio de usuarios. Necesito que el sistema permita registrar usuarios, pero con validaciones: no permitir IDs duplicados, no permitir datos vacíos y validar que el rol sea Estudiante o Docente. Ayúdeme a estructurar esta lógica en Java sin mezclarla con la interfaz.

**Resultado:**
- Definición de validaciones necesarias

**Ajustes manuales:**
- Se integró con el archivo usuarios.txt
- Se creó un método para buscar usuarios por ID
- Se ajustaron los mensajes y condiciones para que funcionaran bien en consola

---

### Prompt 5: Control de accesos

> Ahora vamos con la parte más importante del sistema. Necesito manejar entradas y salidas de usuarios en el laboratorio. El sistema no debe permitir doble entrada sin salida, ni salida sin entrada previa. Ayúdeme a pensar la lógica para esto y cómo implementarlo en Java usando archivos.

**Resultado:**
- Lógica base para control de accesos

**Ajustes manuales:**
- Se recorrió el archivo desde abajo para encontrar la última entrada
- Se adaptó el formato para guardar entrada y salida en la misma línea
- Se hicieron pruebas manuales para validar que no falle

---

### Prompt 6: Cálculo de tiempo

> Ahora quiero calcular cuánto tiempo ha estado un usuario dentro del laboratorio. Necesito sumar todos los tiempos entre entradas y salidas. Ayúdeme a hacerlo en Java usando fechas y horas.

**Resultado:**
- Uso de LocalDateTime y Duration

**Ajustes manuales:**
- Se adaptó el formato de fecha a string
- Se convirtió el resultado a horas y minutos
- Se probó con varios registros para verificar que funcionara bien

---

### Prompt 7: Documentación

> Ahora vamos a hacer la documentación del proyecto. Necesito un README, un CHANGELOG con versiones y una explicación del uso de IA. Ayúdeme con la estructura y contenido base.

**Resultado:**
- Base de README.md, CHANGELOG.md e IA_USO.md

**Ajustes manuales:**
- Se personalizó todo con el nombre del proyecto
- Se ajustó el contenido a los requisitos del examen
- Se corrigieron detalles de formato en Markdown

---

## Conclusión

La inteligencia artificial fue utilizada como herramienta de apoyo durante el desarrollo del proyecto, principalmente para orientar el diseño y la implementación por partes.

El sistema no fue generado automáticamente, sino construido paso a paso, revisando y ajustando cada sección manualmente.

Se logró cumplir con todos los requisitos del enunciado, incluyendo arquitectura por capas, validaciones, persistencia en archivos y documentación.