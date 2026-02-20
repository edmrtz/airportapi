**Overview**

- **Descripción:** Sencilla API REST construida con Spring Boot para gestionar aeropuertos, clientes, rutas, vuelos y reservas. Incluye integración con Docker y `docker-compose` para despliegue rápido en servidores.

**Requisitos**

- **Java:** 11+ (recomendado 17).
- **Maven:** incluido vía `mvnw` (wrapper) — no es necesario tener Maven instalado globalmente.
- **Docker & docker-compose:** para construir y ejecutar contenedores.

**Estructura clave**

- **Código fuente:** [airport/src/main/java](airport/src/main/java)
- **Configuración Maven:** [airport/pom.xml](airport/pom.xml)
- **Docker + compose:** `airport/Dockerfile` y `docker-compose.yml` en la raíz.

**Construir y ejecutar localmente (Maven)**

1. Compilar:

```
cd airport
./mvnw clean package
```

2. Ejecutar el JAR generado:

```
java -jar target/airport-0.0.1.jar
```

La aplicación arrancará por defecto en el puerto `8080`.

**Usar Docker**

1. Construir la imagen (desde la raíz del repo):

```
docker build -t airport:latest ./airport
```

2. Ejecutar el contenedor:

```
docker run -p 8080:8080 airport:latest
```

**Usar docker-compose**

Desde la raíz del proyecto:

```
docker-compose up --build
```

Para ejecución en segundo plano:

```
docker-compose up -d --build
```

**Endpoints (principales)**

Base: `http://localhost:8080`

- **Aeropuertos:** base `GET/POST/PUT/DELETE` en [airport/src/main/java/dev/mrtz/airport/controller/AeropuertoController.java](airport/src/main/java/dev/mrtz/airport/controller/AeropuertoController.java)
- **Clientes:** base `GET/POST/PUT/DELETE` en [airport/src/main/java/dev/mrtz/airport/controller/ClienteController.java](airport/src/main/java/dev/mrtz/airport/controller/ClienteController.java)
- **Vuelos:** base `GET/POST/PUT/DELETE` en [airport/src/main/java/dev/mrtz/airport/controller/VueloController.java](airport/src/main/java/dev/mrtz/airport/controller/VueloController.java)
- **Rutas:** base `GET/POST/PUT/DELETE` en [airport/src/main/java/dev/mrtz/airport/controller/RutaController.java](airport/src/main/java/dev/mrtz/airport/controller/RutaController.java)
- **Reservas:** base `GET/POST/PUT/DELETE` en [airport/src/main/java/dev/mrtz/airport/controller/ReservaPasajeController.java](airport/src/main/java/dev/mrtz/airport/controller/ReservaPasajeController.java)

Cada controlador expone rutas bajo el prefijo `/api/*` (por ejemplo `/api/aeropuertos`, `/api/clientes`, `/api/vuelos`, `/api/rutas`, `/api/reservas`) y soporta las operaciones REST básicas (listar, crear, actualizar por `id`, borrar por `id`).

**Notas de despliegue**

- `docker-compose.yml` está preparado para despliegue simple; ajuste variables de entorno y volúmenes según su entorno de servidor.
- Si quiere ejecutar la imagen en un servidor remoto, suba la imagen a su registry y actualice `docker-compose` o ejecute `docker run` allí.
