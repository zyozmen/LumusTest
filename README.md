# LumusTest
SDET Test es un proyecto creado con el fin de satisfacer la prueba tecnica proporcionada por Lumus.
aqui encontraran toda la informacion requerida para correr el proyecto, su stac tecnologico y demas temas de 
documentacion que tendra el proyecto


## Stack tecnológico

- Java 17+
- Maven 3.9+
- Serenity BDD 4.2.34 con JUnit 5
- Screenplay Pattern
- JUnit Jupiter 5.13.0 y JUnit Platform 1.13.0
- Selenium WebDriver con Google Chrome

## Comandos Maven
- mvn clean test: corre las pruebas automatizadas
- mvn -Dtest=SecurityTestSuite test: para correr la suite de automatizacion

El reporte Serenity se genera en `target/site/serenity/index.html`.


## Estructura

- `src/test/java/.../userinterfaces`: Targets de la UI
- `src/test/java/.../tasks`: acciones Screenplay
- `src/test/java/.../questions`: consultas y verificaciones
- `src/test/java/.../tests/<grupo>`: clases de prueba por pantalla
- `src/test/java/.../runners`: suites JUnit por grupo funcional