# MotoManager 

Sistema integral para la gestión de inventarios, ventas y servicios en talleres de motocicletas. 
Este proyecto nace como una solución real para digitalizar el flujo de caja y stock de repuestos.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot (Data JPA, Web)
* **Base de Datos:** MySQL (Diseñada en MySQL Workbench)
* **Interfaz de Usuario:** JavaFX
* **Arquitectura:** Layered Architecture (Controller-Service-Repository)
* **Gestión de Proyecto:** GitHub Projects (Metodología Ágil/Sprints)

## Arquitectura del Sistema

El proyecto sigue una arquitectura de capas para garantizar la escalabilidad y el mantenimiento:

1. **Controllers:** Manejo de las peticiones de la interfaz JavaFX.
2. **Services:** Lógica de negocio (Cálculo de deudas, validación de stock).
3. **Repositories:** Comunicación directa con la base de datos MySQL.
4. **Entities:** Mapeo de las tablas de la base de datos a objetos Java (MTV).

## Requisitos del Negocio (MVP)

* [x] Registro de Facturas por Compra.
* [x] Reporte de Venta Diaria y Mensual.
* [x] Inventario dinámico con descarga automática.
* [x] Alertas de Stock Mínimo (Stop de artículos).
* [x] Gestión de Cuentas por Cobrar (Clientes pendientes).

## Autor
* **Humberto Covilla** - *Estudiante de Ingeniería en Desarrollo de Software* - Jala University.
