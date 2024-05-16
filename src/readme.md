# Proyecto de Rutas de Trenes

El Proyecto de Rutas de Trenes implementa un sistema para calcular rutas y distancias en una red ferroviaria local. El sistema permite calcular la distancia de una ruta específica, contar el número de rutas entre dos ciudades con ciertas restricciones y encontrar la ruta más corta entre dos ciudades.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- **src/main/java/com/example/trainroutes**: Contiene el código fuente del proyecto.
    - `Graph.java`: Implementación de un grafo dirigido para representar la red ferroviaria y realizar cálculos relacionados con rutas.
    - `Node.java`: Clase que representa un nodo en el grafo.
    - `TrainRoutes.java`: Clase principal que contiene el método `main` para ejecutar el programa.
    - `strategy`: Paquete que contiene estrategias para el cálculo de rutas.
        - `RouteCalculationStrategy.java`: Interfaz para las estrategias de cálculo de rutas.
        - `ExactStopsStrategy.java`, `MaxStopsStrategy.java`, `MaxDistanceStrategy.java`: Implementaciones de las estrategias.

- **src/test/java/com/example/trainroutes**: Contiene las pruebas unitarias del proyecto.
    - `GraphTest.java`: Pruebas unitarias para las funcionalidades de la clase `Graph`.

- **pom.xml**: Archivo de configuración de Maven que define las dependencias y plugins del proyecto.

## Uso

