# 🚀 API REST para Sistema de Tickets (Java & JAX-RS)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JAX-RS](https://img.shields.io/badge/JAX--RS-orange?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> API REST desarrollada en Java para la gestión de usuarios de un sistema de soporte técnico. El proyecto sirve como backend para manejar la autenticación y consulta de usuarios.

## 📜 Sobre el Proyecto

Este proyecto fue desarrollado como una práctica académica para implementar un servicio backend utilizando Java. La aplicación sigue una arquitectura en capas para separar las responsabilidades:

* **Capa de Modelo:** Define las entidades de datos (ej. `Usuario`).
* **Capa de Controlador/Servicio:** Maneja la lógica de negocio y la comunicación con la base de datos a través de JDBC.
* **Capa REST (Recursos):** Expone los servicios a través de endpoints HTTP, utilizando JAX-RS para la especificación de la API y Gson para la serialización/deserialización de JSON.

### Estado del Proyecto
Actualmente, el proyecto es una prueba de concepto funcional que implementa por completo el módulo de `Usuario`. Los módulos para `Ticket` y `Categoria` fueron planeados pero no se encuentran implementados.

<br>

## 🛠️ Construido Con

* [Java (JDK 11+)](https://www.oracle.com/java/technologies/downloads/)
* [JAX-RS (Jakarta RESTful Web Services)](https://projects.eclipse.org/projects/ee4j.jaxrs) - Para la creación de los servicios web REST.
* [Gson](https://github.com/google/gson) - Para manejar la conversión de objetos Java a JSON.
* [MySQL](https://www.mysql.com/) - Como sistema de gestión de base de datos.
* [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) - Para la conectividad con la base de datos.
* [Apache Maven](https://maven.apache.org/) - Para la gestión de dependencias y construcción del proyecto.

<br>

## 🚀 Empezando

Para ejecutar este proyecto en tu entorno local, sigue estos pasos.

### Prerrequisitos

* JDK 11 o superior.
* Apache Maven.
* Un servidor de MySQL en ejecución.
* Un servidor de aplicaciones Java como [Apache Tomcat](https://tomcat.apache.org/) o [Payara](https://www.payara.fish/).

### Instalación

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)
    ```
2.  **Configura la Base de Datos:**
    * Crea una base de datos en MySQL. Puedes llamarla `tickets_db`.
    * Ejecuta el siguiente script SQL para crear la tabla `usuario`:
        ```sql
        CREATE TABLE usuario (
            idUsuario INT PRIMARY KEY AUTO_INCREMENT,
            username VARCHAR(255) NOT NULL UNIQUE,
            password VARCHAR(255) NOT NULL,
            token VARCHAR(255),
            lastConnection DATETIME
        );
        ```
3.  **Configura la Conexión:**
    * Dentro del código fuente, localiza la clase que maneja la conexión a la base de datos (`org.lasalle.services.controller.ConnectionMysql`).
    * Asegúrate de que las credenciales (URL, usuario, contraseña) coincidan con tu configuración local de MySQL.

4.  **Construye el Proyecto con Maven:**
    * Abre una terminal en la raíz del proyecto y ejecuta:
        ```bash
        mvn clean install
        ```
    * Esto generará un archivo `.war` en la carpeta `target/`.

5.  **Despliega la Aplicación:**
    * Toma el archivo `.war` generado y despliégalo en tu servidor de aplicaciones (ej. cópialo a la carpeta `webapps` de Tomcat).

<br>

## Usage (Uso)

Una vez desplegada, la API expondrá los siguientes endpoints. La URL base será algo como `http://localhost:8080/nombre-del-war/api/`.

### Módulo de Usuario

**1. Login de Usuario**
* **Método:** `POST`
* **Endpoint:** `/usuario/login`
* **Parámetros (form-data):** `user` (String), `password` (String)
* **Respuesta Exitosa (200 OK):** `("idUsuario" = "1")`
* **Respuesta de Falla (401 Unauthorized):** Sin cuerpo.
* **Ejemplo con cURL:**
    ```bash
    curl -X POST -d "user=testuser&password=123" http://localhost:8080/tu-proyecto/api/usuario/login
    ```

**2. Obtener Todos los Usuarios**
* **Método:** `GET`
* **Endpoint:** `/usuario/getAll`
* **Respuesta Exitosa (200 OK):** Un JSON con la lista de todos los usuarios.
* **Ejemplo con cURL:**
    ```bash
    curl http://localhost:8080/tu-proyecto/api/usuario/getAll
    ```

**3. Obtener un Usuario**
* **Método:** `GET`
* **Endpoint:** `/usuario/getOne`
* **Parámetros (query):** `username` (String), `password` (String)
* **Respuesta Exitosa (200 OK):** El ID del usuario en formato JSON.
* **Ejemplo con cURL:**
    ```bash
    curl "http://localhost:8080/tu-proyecto/api/usuario/getOne?username=testuser&password=123"
    ```

<br>

## 📬 Contacto

Tu Nombre – tu.email@ejemplo.com

Link del Proyecto: [https://github.com/tu-usuario/tu-repositorio](https://github.com/tu-usuario/tu-repositorio)
