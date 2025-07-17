# 📒 Agenda de Contactos en Java
Una aplicación de consola en Java que permite gestionar una agenda de contactos: agregar, buscar, eliminar y mostrar personas por nombre, apellidos o numero de teléfono.

## 🚀 Tecnologías utilizadas
  -Java POJO.
  -POO.
  -Patrón de capas: Model, Repository, Service, Controller.
  -Entrada/salida por consola.
  -Estructura de datos: List, Optional.
  -Git para control de versiones.
  
## 📈 Estado del proyecto
   -✅ Primera versión funcional terminada
    -🔧Cosas a añadir a la aplicación:
        -Persistencia de datos con base de datos relacional.
        -Version con Spring boot y API REST.
        -Interfaz gráfica o cliente web.
        -Pruebas unitarias con JUnit.

## 🎯 Objetivos del proyecto
  -Este proyecto tiene como objetivo reforzar fundamentos de java (POJO) aplicar buenas prácticas de organización del código, trabajar con estructuras de datos y preparar la integración de técnologias como Spring y base de datos reales.

## 📁 Estructura actual del proyecto
      src/
    ├── model/        → Clases de datos (InfoContacto)
    ├── repository/   → Interfaces y lógica de almacenamiento en memoria
    ├── service/      → Lógica de negocio (búsqueda, validación, etc.)
    ├── controller/   → Puente con la futura capa de presentación
    └── Agenda.java   → Interfaz de consola para el usuario
