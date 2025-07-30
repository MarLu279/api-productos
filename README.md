# 🚀 API de Productos con Reseñas - Spring Boot

![Java](https://img.shields.io/badge/Java-21-red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

API RESTful para gestionar productos y reseñas, desarrollada con Spring Boot como parte del desarrollo backend.

## 📦 Funcionalidades Principales
- ✅ CRUD completo de productos y reseñas
- ✨ Gestión de reseñas por producto
- 🔍 Búsqueda por nombre

## 🛠️ Tecnologías
- **Backend**: Java 21, Spring Boot 3.5.4
- **Pruebas**: Postman
- **Build**: Maven

## 🔌 Endpoints

| Método | Ruta                                             | Descripción             |
|--------|--------------------------------------------------|-------------------------|
| POST   | `/api/productos`                                 | Crear producto          |
| GET    | `/api/productos/{id}`                            | Obtener producto por ID |
| PUT    | `/api/productos/{id}`                            | Actualizar producto     |
| DELETE | `/api/productos/{id}`                            | Eliminar producto       |
| POST   | `/api/productos/{productoId}/reseñas`            | Agregar reseña          |
| PUT    | `/api/productos/{productoId}/reseñas/{reseñaId}` | Actualizar reseña       |
| DELETE | `/api/productos/{productoId}/reseñas/{reseñaId}` | Eliminar reseña         |

## 🚀 Cómo Ejecutar
1. Clona el repositorio:
   ```bash
   https://github.com/MarLu279/api-productos.git
2. Ejecuta la aplicación:
    ```bash
   mvn spring-boot:run
3. Prueba los endpoints en Postman o visita:
    ```bash
   http://localhost:8080/api/productos
