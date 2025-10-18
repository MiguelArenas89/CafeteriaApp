## Project Structure

```
CafeteriaApp/
├── src/                           # Código fuente de la aplicación
│   ├── main/                      # Código principal
│   │   ├── java/                  # Archivos Java del proyecto
│   │   │   └── com/project/cafeteria/cafeteriaapp/
│   │   │       ├── controller/    # Controladores REST
│   │   │       │   ├── CafeController.java
│   │   │       │   └── OrderController.java
│   │   │       ├── dto/           # Objetos de transferencia de datos
│   │   │       │   └── ItemOrderDTO.java
│   │   │       ├── entity/        # Entidades JPA
│   │   │       │   ├── Cafe.java
│   │   │       │   └── Order.java
│   │   │       ├── exceptions/    # Manejo de excepciones
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── NotFoundException.java
│   │   │       ├── repository/    # Repositorios para acceso a datos
│   │   │       │   ├── CafeRepository.java
│   │   │       │   └── OrderRepository.java
│   │   │       ├── service/       # Lógica de negocio
│   │   │       │   ├── CafeService.java
│   │   │       │   └── OrderService.java
│   │   │       ├── CafeteriaAppApplication.java  # Punto de entrada principal
│   │   │       └── ServletInitializer.java       # Inicializador de servlet
│   │   └── resources/             # Recursos de la aplicación
│   │       ├── application.properties  # Configuraciones de la aplicación
│   │       ├── static/            # Recursos estáticos (CSS, JS, imágenes)
│   │       └── templates/         # Plantillas para vistas (si se utilizan)
│   └── test/                      # Pruebas unitarias e integración
│       └── java/
│           └── com/project/cafeteria/cafeteriaapp/
│               └── CafeteriaAppApplicationTests.java
├── target/                        # Directorio de compilación
├── pom.xml                        # Configuración de Maven
├── mvnw                           # Script de Maven Wrapper para Linux
└── mvnw.cmd                       # Script de Maven Wrapper para Windows


```
