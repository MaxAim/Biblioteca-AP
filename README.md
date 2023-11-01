# Biblioteca AP

## Descripción
Este proyecto es una aplicación web para gestionar una biblioteca. Permite registrar, consultar, modificar y eliminar libros, autores y editoriales.

## Tecnologías

- Spring Boot 3.1.5
- Spring Web
- Postgres Driver
- Lombok

## Requisitos

- Java 17
- Gradle

## Instalación

1. Clonar el repositorio: `git clone https://github.com/MaxAim/Biblioteca-AP.git`
2. Crear una base de datos Postgres llamada `biblioteca`
3. Modificar el archivo `application.properties` con las credenciales de la base de datos
4. Iniciar la aplicación
5. Acceder a la aplicación en `http://localhost:8080`



## Endpoints

| Endpoint                      | Metodo      | Descripción                                                    | Body                       |
|-------------------------------|-------------|----------------------------------------------------------------|----------------------------|
|                               |
| `/libros/findAll`             | GET         | Lista todos los libros.                                        |                            |
| `/libros/find/{id}`           | GET         | Permite obtener un libro específico por su identificador.      |                            |
| `/libros/save`                | POST        | Registra un nuevo libro.                                       | `Ver ejemplo 1`            |
| `/libros/update/{id}`         | PUT         | Actualiza un libro ya existente.                               | `Ver ejemplo 1`            |
| `/libros/delete/{id}`         | DELETE      | Elimina de forma permanente un libro.                          |                            |
| `/libros/alta/id}`            | Put         | Restaura o eliminado de forma logica un libro.                 |                            | 
|                               |
| `/autores/findAll`            | GET         | Lista de todos los autores.                                    |                            |
| `/autores/find/{id}`          | GET         | Permite obtener un autor específico por su identificador.      |                            |
| `/autores/save`               | POST        | Registra un nuevo autor.                                       | `Ver ejemplo 2`            |
| `/autores/update/{id}`        | PUT         | Renombra un autor ya existente.                                | `Ver ejemplo 2`            |
| `/autores/delete/{id}`        | DELETE      | Elimina de forma permanente un autor.                          |                            |
| `/autores/alta/{id}`          | PUT         | Restaura o eliminado de forma logica un autor.                 |                            |
|                               |
| `/editoriales/findAll`        | GET         | Lista de todas las editoriales.                                |                            |
| `/editoriales/find/{id}`      | GET         | Permite obtener una editorial específica por su identificador. |                            |
| `/editoriales/save`           | POST        | Registra una nueva editorial.                                  | `Ver ejemplo 3`            |
| `/editoriales/update/{id}`    | PUT         | Renombra una editorial ya existente.                           | `Ver ejemplo 3`            |
| `/editoriales/delete/id}`     | DELETE      | Elimina de forma permanente una editorial.                     |                            |
| `/editoriales/alta/{id}`      | PUT         | Restaura o eliminado de forma logica una editorial.            |                            | 

Coleccion de postman adjuntada en el repositorio

| Ejemplo 1 |
|-------------|
```
BODY:
{
    "autor":{
        "id": 1
        },
    "id": 2,
    "isbn": 1234567899,
    "alta": false,
    "titulo": "placeholder_titulo_2",
    "anio": 2000,
    "ejemplares": 10,
    "ejemplaresPrestados": 3,
    "ejemplaresRestantes": 7,
    "editorial": {
        "id": 1
    }
}
```
| Ejemplo 2 |
|--------------|
```
BODY:
{
    "id": 1,
    "nombre": "placeholder_autor_1",
    "alta": true
}

```
| Ejemplo 3 |
|--------------|
```
BODY:
{
    "id": 1,
    "nombre": "placeholder_editorial_1",
    "alta": true
}

```
