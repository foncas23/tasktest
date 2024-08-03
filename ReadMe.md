# [ES] Test Fintonic API

## Descripción

La **Test Fintonic API** permite la gestión de tareas, incluyendo la creación y la recuperación de una lista de tareas. Esta API está diseñada para ser simple y eficaz, facilitando la integración con aplicaciones que requieren manejo de tareas.

## Versión

- **Versión de la API:** 1.0.0


## Configuración del proyecto
- **Puerto por defecto:** 8080
  - **Base de datos:** Se ha creado un base de datos Oracle embebida en el proyecto la cual genera un la tabla `TASK` con los siguientes campos:
    ```sql
    CREATE TABLE TASK(
    ID            INT AUTO_INCREMENT  NOT NULL PRIMARY KEY,
    TITLE         VARCHAR(255)        NOT NULL,
    DESCRIPTION   VARCHAR(255)        NOT NULL,
    START_DATE    DATE                NOT NULL,
    PRIORITY      INT                 NOT NULL);

  - **Base de datos:** Se ha creado un script SQL para insertar unas tareas para tener información a la hora de arrancar:
    ```sql
    INSERT INTO TASK (TITLE, DESCRIPTION, START_DATE, PRIORITY) VALUES 
    ('Title: Task 1', 'Description of Task 1', '2020-12-31', 3),
    ('Title: Task 2', 'Description of Task 3', '2020-06-14', 1),
    ('Title: Task 3', 'Description of Task 3', '2020-06-15', 4),
    ('Title: Task 4', 'Description of Task 4', '2020-12-31', 8);

## Endpoints

### 1 Crear una Tarea

- **Ruta:** `localhost:8080/task/createTask`
- **Método:** `POST`
- **Descripción:** Crea una nueva tarea y la almacena en la base de datos.
- **Tags:** `task`

### Solicitud

- **Tipo de contenido:** `application/json`
- **Cuerpo de la solicitud:** Un objeto `Task` que debe ser añadido. Debe cumplir con el siguiente esquema:

  ```json
  {
    "id": 1,
    "title": "Title of task",
    "description": "Description of task",
    "startDate": "2020-06-15",
    "priority": 1
  }
## 2 Obtener Lista de Tareas

- **Ruta:** `localhost:8080/task/listTask`
- **Método:** `GET`
- **Descripción:** Recupera una lista de todas las tareas disponibles en la base de datos.
- **Tags:** `task`

### Parámetros de Solicitud

Este endpoint no requiere parámetros adicionales en la solicitud ya que devuelve todas las tareas almacenadas en la BBDD

#### Objeto Json de Respuesta esperado:
- **Tipo de contenido:** `application/json`
- **Cuerpo de la solicitud:** Devovlerá un lista de `Task` a continuación se muestra un ejemplo:

  ```json
  [
    {
        "id": 1,
        "title": "Title: Task 1",
        "description": "Description of Task 1",
        "startDate": "2020-12-31",
        "priority": 3
    },
    {
        "id": 2,
        "title": "Title: Task 2",
        "description": "Description of Task 3",
        "startDate": "2020-06-14",
        "priority": 1
    },
    {
        "id": 3,
        "title": "Title: Task 3",
        "description": "Description of Task 3",
        "startDate": "2020-06-15",
        "priority": 4
    },
    {
        "id": 4,
        "title": "Title: Task 4",
        "description": "Description of Task 4",
        "startDate": "2020-12-31",
        "priority": 8
    },
    {
        "id": 5,
        "title": "Task creada desde postman",
        "description": "Complete the OpenAPI documentation",
        "startDate": "2024-08-01",
        "priority": 2
    }
  ]

## Información de Contacto

Para cualquier consulta, soporte o retroalimentación sobre la **Test Fintonic API**, por favor contáctanos a través de los siguientes medios:

- **Correo Electrónico:** alfonsocarballalgraupera@gmail.com
- **Teléfono:** +34 666 39 09 29
- **Repositorio en GitHub:** [https://github.com/foncas23/tasktest](https://github.com/foncas23/tasktest)
- **Reportar Problemas:** [https://github.com/foncas23/tasktest/issues](https://github.com/foncas23/tasktest/issues)

No dudes en ponerte en contacto con nosotros para obtener asistencia o para reportar cualquier problema que encuentres. Agradecemos tus comentarios y haremos todo lo posible para resolver tus inquietudes.


# [EN] Test Fintonic API

## Description

The **Test Fintonic API** provides task management capabilities, including creating and retrieving a list of tasks. This API is designed to be simple and effective, facilitating integration with applications that require task handling.

## Version

- **API Version:** 1.0.0

## Project Configuration
- **Default Port:** 8080
  - **Database:** An embedded Oracle database has been created in the project, which generates the `TASK` table with the following fields:
    ```sql
    CREATE TABLE TASK(
    ID            INT AUTO_INCREMENT  NOT NULL PRIMARY KEY,
    TITLE         VARCHAR(255)        NOT NULL,
    DESCRIPTION   VARCHAR(255)        NOT NULL,
    START_DATE    DATE                NOT NULL,
    PRIORITY      INT                 NOT NULL);

  - **Database:** A SQL script has been created to insert some tasks to have data when starting up:
    ```sql
    INSERT INTO TASK (TITLE, DESCRIPTION, START_DATE, PRIORITY) VALUES 
    ('Title: Task 1', 'Description of Task 1', '2020-12-31', 3),
    ('Title: Task 2', 'Description of Task 3', '2020-06-14', 1),
    ('Title: Task 3', 'Description of Task 3', '2020-06-15', 4),
    ('Title: Task 4', 'Description of Task 4', '2020-12-31', 8);

## Endpoints

### 1. Create a Task

- **Endpoint:** `localhost:8080/task/createTask`
- **Method:** `POST`
- **Description:** Creates a new task and stores it in the database.
- **Tags:** `task`

#### Request

- **Content-Type:** `application/json`
- **Request Body:** A `Task` object that needs to be added. It should conform to the following schema:

  ```json
  {
    "id": 1,
    "title": "Title of task",
    "description": "Description of task",
    "startDate": "2020-06-15",
    "priority": 1
  }

## 2. Get List of Tasks

- **Endpoint:** `localhost:8080/task/listTask`
- **Method:** `GET`
- **Description:** Retrieves a list of all tasks available in the database.
- **Tags:** `task`

### Request Parameters

This endpoint does not require additional parameters as it returns all tasks stored in the database.

#### Expected JSON Response:
- **Content-Type:** `application/json`
- **Response Body:** Will return a list of `Task`. Here is an example:
    ```json
  [
    {
        "id": 1,
        "title": "Title: Task 1",
        "description": "Description of Task 1",
        "startDate": "2020-12-31",
        "priority": 3
    },
    {
        "id": 2,
        "title": "Title: Task 2",
        "description": "Description of Task 3",
        "startDate": "2020-06-14",
        "priority": 1
    },
    {
        "id": 3,
        "title": "Title: Task 3",
        "description": "Description of Task 3",
        "startDate": "2020-06-15",
        "priority": 4
    },
    {
        "id": 4,
        "title": "Title: Task 4",
        "description": "Description of Task 4",
        "startDate": "2020-12-31",
        "priority": 8
    },
    {
        "id": 5,
        "title": "Task creada desde postman",
        "description": "Complete the OpenAPI documentation",
        "startDate": "2024-08-01",
        "priority": 2
    }
  ]
## Contact Information

For any inquiries, support, or feedback regarding the **Test Fintonic API**, please contact us through the following channels:

- **Email:** alfonsocarballalgraupera@gmail.com
- **Phone:** +34 666 39 09 29
- **GitHub Repository:** [https://github.com/foncas23/tasktest](https://github.com/foncas23/tasktest)
- **Report Issues:** [https://github.com/foncas23/tasktest/issues](https://github.com/foncas23/tasktest/issues)

Feel free to reach out for assistance or to report any issues you encounter. We appreciate your feedback and will do our best to address your concerns.
