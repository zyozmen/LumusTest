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
- `mvn clean verify`: corre las pruebas automatizadas
- `mvn -Dtest=SecurityTestSuite test`: para correr la suite de automatizacion

El reporte Serenity se genera en `target/site/serenity/index.html`.


## Estructura

- `src/test/java/.../userinterfaces`: Targets de la UI
- `src/test/java/.../tasks`: acciones Screenplay
- `src/test/java/.../questions`: consultas y verificaciones
- `src/test/java/.../tests/<grupo>`: clases de prueba por pantalla
- `src/test/java/.../runners`: suites JUnit por grupo funcional


## Algoritmos

- `src/test/java/.../algorithms`: paquete de algoritmos solicitados
- `src/test/java/.../algorithms/HistogramMain`: Clase principal para correr el algoritmo de ordenamiento
- `src/test/java/.../algorithms/WorldCounterPersonal`: Clase que contiene la logica para el ordenamiento
- `java -cp target/test-classes com.sdet.test.algorithms.HistogramMain`: comando para ejecutar la clase main

La idea general es:

contar cada palabra
agrupar palabras por frecuencia
ordenar las frecuencias de mayor a menor con TreeMap

## Valor computacional
1) Constructor WordCounterPersonal(String input)

n = tamaño total del texto
k = número de palabras distintas

entonces: 

input.toCharArray().length → O(𝑛)
input.split(" ") → O(n)
iterar sobre las palabras para contar → O(n)
llamar a sortMap(wCounter)
Entonces el constructor queda en:

O(n)+O(sortMap)

2) sortMap(Map<String, Integer> wCounter)

recorrer cada entrada del mapa de conteo: O(k)
para cada palabra, hacer:
ordered.getOrDefault(...) O(k)
ordered.put(...)O(k)


luego recorrer ordered.entrySet() para construir el resultado final: O(k)
Por lo tanto, la parte de ordenamiento con TreeMap es: O(k log k)
porque un árbol binario ordenado mantiene el orden por clave.

Entonces la complejidad total de la clase queda:
O(n + k log k )
y como k ≤ n, en el peor caso se puede expresar como:
O(n log n)
