# Calculadora de prestamos para autos
# Análisis
### Requerimientos

**Funcionales**
    - Debe contener una aplicación sencilla interfaz web con campos de entrada para el calculo del prestamo.
    - Debe de visualizrse el pago mensual calculado.
    - La aplicación debe calcular el pago mensual en base a las fórmulas de préstamos estándar de Panamá.
    - Los campos de entrada deben validar la entrada del usuario para asegurar que es numérica y dentro de límites razonables.

**No funcionales**
    - La aplicación debe responder rápidamente a las entradas del usuario.
    - El cálculo debe realizarse de forma eficiente.
    - Interfaz del usuario debe ser intuitiva y fácil de usar
    - La validación de las entradas de datos lo que pude ayudar a mitigar el riesgo de errores y seguridad.
    - Uso de HTML y CSS adecuados para garantizar la accesibilidad de la Web.

# Diseño del sistema

**Cliente**
- Crearemos en **HTML:** la estructura basica de la pagina web, la que incluira las entradas del usuario para el calculo.
- **JavaScript:**
    - Para manejar la entrada y validación del usuario.
    - Enviar un **POST** request al servidor con los detalles del préstamo.
    - Recibir del servidor el pago mensual calculado y mostrarlo en la página.

```mermaid
classDiagram
    class Cliente {
        - sendRequest()
        - receiveResponse()
    }

    class Servidor {
        - receiveRequest()
        - processRequest()
        - sendResponse()
    }

    Cliente "1" -- "1" Servidor
```
*cliente-servidor*

**Server creado con Java:**
- **API:**
    - Creamos un API endpoint `http://localhost:3000/calcular` para gestionar la solicitud POST del cliente.
    - Extraemos los detalles de entrada validamos los datos y calculamos el pago.
```mermaid
classDiagram
    class calculoPrestamoRequest {
        - double importePrestamo
        - double interes
        - int plazos
    }

    class calculoPrestamoResponse {
        - double pagoMensual
    }

    class servicioCalculoPrestamo {
        + calculoPrestamoResponse calculateLoan(calculoPrestamoRequest)
    }

    calculoPrestamoRequest "1" -- "1" servicioCalculoPrestamo
    servicioCalculoPrestamo "1" -- "1" calculoPrestamoResponse
```
*Diagrama de clases del cliente*

    - Calcular el pago mensual.
    - Devolver el pago calculado como una respuesta JSON.
    - Implementar la lógica de cálculo del préstamo utilizando la fórmula estándar.
```mermaid
sequenceDiagram
    participant Usuario
    participant Cliente
    participant Servidor
    participant servicioCalculoPrestamo

    Usuario->>Cliente: Detalles del prestamo
    Cliente->>Servidor: HTTP POST request
    Servidor->>servicioCalculoPrestamo: Forwards request
    servicioCalculoPrestamo->>servicioCalculoPrestamo: Calculo del pago mensual
    servicioCalculoPrestamo->>Servidor: return resultados
    Servidor->>Cliente: HTTP response
    Cliente->>Usuario: Muestra pago mensual
```
*Diagrama de secuencia comunicacion cliente servidor*

# Implementación
##### Servidor
**Instalar gradle**
```bash
sudo apt install gradle
```

**Dar permiso a gradlew y ejecutar para instalar dependencias**
```bash
chmod +x ./gradlew
./gradlew build
```

**Iniciar servidor**
```bash
./gradlew bootRun
```

![API en Spring](./images/server.png)
*Levantamiento del servidor*

![Metodo POST al endpoint del la API usando Postman](./images/post.png)
*Verificación de funcionamiento utilizando Postman*
##### Cliente
Abrir **index.html** con live server (si utiliza VS Code) o cualquier navegador Web.
![cliente web](./images/client.png)
*Funcionamiento del cliente*
# Problemas encontrados y recomendaciones

##### Problemas encontrados:
1. Falta de experiencia utilizando una de las herramientas nesesarias para el sistema (**Java**).

##### Recomendaciones:
1. Si el numero de usuarios incrementa el sistema no podra ser capaz de procesar toda la carga, lo que nos forzaria a escalar la aplicacion de manera horizontal.
2. La interfaz de usuario se puede mejorar agregando mensajes de error, comentarios de ayuda y indicadores de carga.

