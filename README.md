# Aura de Cristal - Backend

Este es el backend de **Aura de Cristal**, una aplicación diseñada para gestionar el alquiler de vajillas y otros productos relacionados, ofreciendo funcionalidades completas para la administración de usuarios, productos, reservas y más.

## Tecnologías

- **Lenguaje**: Java  
- **Framework**: Spring Boot  
- **Base de datos**: MySQL  
- **Autenticación**: JSON Web Token (JWT)  
- **Despliegue**: [Railway](https://railway.app)  
- **Almacenamiento de imágenes**: AWS S3  

## Características

1. **Gestión de productos**:  
   - CRUD para productos.  
   - Asociar productos a características, categorías y temáticas.  

2. **Gestión de reservas**:  
   - CRUD completo para manejar reservas de vajillas.  
   - Asignación de reservas a usuarios específicos.  

3. **Gestión de usuarios**:  
   - CRUD para usuarios.  
   - Registro e inicio de sesión con autenticación basada en JWT.  

4. **Relaciones**:  
   - Organización de productos según características, categorías y temáticas para una mejor administración.  

5. **Almacenamiento de imágenes**:  
   - Las imágenes mostradas en el frontend están almacenadas en un bucket de Amazon S3 para un acceso rápido y seguro.  

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) o superior.  
- [MySQL](https://www.mysql.com/) para la base de datos.  
- [Maven](https://maven.apache.org/) para la gestión de dependencias.  
- Una cuenta de AWS con un bucket S3 configurado (para el manejo de imágenes).  

## Instalación

1. Clona este repositorio:  
   git clone https://github.com/lissque/auradecristal_backend.git
   cd auradecristal_backend

2. Configura la base de datos:  
   Crea una base de datos MySQL y toma nota de las credenciales.

3. Configura las variables de entorno:  
   En el archivo properties configura todas las variables de entorno necesarias para el funcionamiento correcto del proyecto.

4. Construye y ejecuta el proyecto:  
   mvn clean install
   mvn spring-boot:run

## Uso

### Endpoints principales

1. **Usuarios**  
   - POST `/auth/register`: Registro de usuarios.  
   - POST `/auth/login`: Inicio de sesión.  
   - CRUD completo para usuarios.  

2. **Productos**  
   - CRUD completo para productos.  
   - Asociar productos a características, categorías y temáticas.  

3. **Reservas**  
   - CRUD completo para gestionar reservas de vajillas.  
   - Asignar reservas a usuarios.  

4. **Imágenes**  
   - Las imágenes asociadas a productos y reservas son cargadas en AWS S3.  
   - El frontend genera las URL necesarias para su acceso allí, en la base de datos se guardan estas urls asignadas a productos.  

## Despliegue

Este proyecto está desplegado en [Railway](https://railway.app). Si deseas realizar un despliegue por tu cuenta:

1. Sube el proyecto a Railway o una plataforma de tu elección.  
2. Configura las variables de entorno en el panel de la plataforma.  
3. Configura un bucket S3 de AWS con las políticas adecuadas para almacenar y acceder a imágenes.  

## Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas, mejoras o encuentras algún problema, no dudes en abrir un issue o enviar un pull request.


Proyecto desarrollado para la materia de **Proyecto Integrador** para Digital House.
