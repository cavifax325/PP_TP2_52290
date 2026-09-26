# Trabajo Práctico 2 - Paradigmas de Programación

**Universidad Tecnológica Nacional - Facultad Regional Mendoza (UTN FRM)**  
**Unidad 2:** Organización, reutilización y recursos avanzados en Programación Orientada a Objetos (Java).

## 📄 Descripción del Proyecto

Este proyecto es la continuación del sistema de gestión de Eventos Universitarios. En esta etapa (TP2), el sistema se ha modularizado y escalado para incorporar características avanzadas de la Programación Orientada a Objetos en Java. 

El objetivo principal es dotar al sistema de tolerancia a fallos, persistencia de datos, polimorfismo mediante interfaces, uso de tipos genéricos (generics y wildcards) y ejecución concurrente de procesos mediante hilos (threads).

## 🚀 Funcionalidades Implementadas

El desarrollo se divide en 4 ejercicios principales, cumpliendo con los siguientes requerimientos:

### Ejercicio 1: Excepciones y Persistencia
* Implementación de la excepción personalizada `CupoExcedidoException` para el control de inscripciones a actividades.
* Manejo robusto de excepciones (bloques `try-catch-finally`) en la clase principal `App`.
* Persistencia de objetos (guardado y recuperación del `EventoUniversitario`) utilizando Serialización y Deserialización, con control de fallos detallado.

### Ejercicio 2: Interfaces y Polimorfismo
* Incorporación de la interfaz `Certificable` para definir qué actividades emiten certificados.
* Creación de un nuevo tipo de actividad (`Curso`).
* Generación polimórfica de certificados exclusivos para `Taller` y `Curso` (las charlas no son certificables).

### Ejercicio 3: Tipos Genéricos y Wildcards
* Uso de métodos parametrizados acotados (`<T extends Actividad>`) para filtrar actividades por su tipo concreto de clase (`Charla`, `Taller`, `Curso`) devolviendo listas fuertemente tipadas.
* Uso de wildcards (`List<? extends Actividad>`) para el cálculo de costo de materiales, flexibilizando la aceptación de cualquier colección que derive de `Actividad`.

### Ejercicio 4: Clases Anidadas y Concurrencia (Hilos)
* Implementación de `TicketDeAcceso` como una **clase anidada** dentro de `Inscripcion`, reflejando una fuerte dependencia contextual (un ticket solo existe si hay una inscripción confirmada).
* Creación del hilo `EnvioTicketsThread` en un paquete separado, encargado de despachar tickets de forma **concurrente**.
* Demostración de dos flujos de ejecución en la consola: el hilo principal mostrando datos del evento mientras el hilo secundario procesa el envío de tickets simultáneamente.

## 🏗️ Estructura del Proyecto

El código está organizado en los siguientes paquetes para garantizar un alto nivel de encapsulamiento:

* `modelo`: Contiene las clases principales (`EventoUniversitario`, `Sala`, `Estudiante`, `Inscripcion`).
* `actividades`: Jerarquía de actividades (`Actividad`, `Charla`, `Taller`, `Curso`).
* `excepciones`: Excepciones personalizadas (`CupoExcedidoException`).
* `certificacion`: Interfaces y lógica de certificados (`Certificable`).
* `hilos`: Clases encargadas de la concurrencia (`EnvioTicketsThread`).

## 🛠️ Requisitos Previos

* **Java Development Kit (JDK):** Versión 11 o superior.
* **IDE:** IntelliJ IDEA (recomendado por la cátedra).
* **Git:** Para clonar y versionar el repositorio.

## ⚙️ Instalación y Ejecución

1. Clonar el repositorio en tu máquina local:
   ```bash
   git clone [https://github.com/cavifax325/PP_TP2_52290](https://github.com/cavifax325/PP_TP2_52290)
