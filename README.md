# Nombre y descripción de la app
Autoras es una aplicación diseñada para incentivar y acercar la lectura de libros e historias contadas por mujeres mediante un juego interactivo.

## Requisitos Previos
Antes de comenzar, asegurarse de tener instalados los siguientes componentes en el ambiente de desarrollo:

- **JDK 11** o superior: Necesario para compilar y ejecutar código Java. Puedes descargarlo [aquí](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Base de datos MySQL 8.x** o superior: La base de datos requerida para almacenar la información de la aplicación. Puedes descargarla [aquí](https://dev.mysql.com/downloads/installer/).
- **Spring Boot**: Utilizado para la configuración del entorno y ejecución de la aplicación. Asegúrate de tener instalado Maven o Gradle, ya que estos manejan las dependencias de Spring Boot.

## Instalación para desarrolladores
1. Clonar el repositorio: 
    `git clone https://github.com/tuusuario/autoras.git`
2. Instalar las dependencias: 
    ./mvnw clean install 
3. Esto generará el archivo .jar, que puede utilizarse para ejecutar el backend.

## Instalación para usuarios 
Autoras sigue en desarrollo y aún no está disponible para descargas. Para más información sobre los avances, visitar 
AutorasLeamosMasMujeres.com

## Configuración

- Iniciar el servicio MySQL y crear la base de datos: juego_autoras
- Configurar el archivo application.properties para conectar la base de datos de manera adecuada
    spring.datasource.url=jdbc:mysql://localhost:3306/juego_autoras
    spring.datasource.username=devuser
    spring.datasource.password=devpass

## Despliegue en entorno Local
- Usando el archivo JAR
    1. Navegar hasta el directorio raíz del proyecto donde se encuentra el archivo JAR generado.
    2. Ejecutar el siguiente comando desde la terminal:
		java -jar juego-de-preguntas.jar
    3. Acceder a la aplicación en el navegador a través de http://localhost:8080.

- En modo desarrollo usando Spring Boot:
    1. Para ejecutar la aplicación en modo desarrollo y aprovechar las capacidades de autocompilación y recarga
                ./mvnw spring-boot:run
    2.  Al ejecutar este comando, la aplicación se compilará y estará disponible en http://localhost:8080.


## Mejores prácticas
Una de las misiones de Autoras es contribuir a la visibilidad y empoderamiento de escritoras mujeres. 
Para colaborar con el proyecto, es crucial que se respete la línea editorial y directrices disponibles en el sitio AutorasLeamosMasMujeres.com, y se tengan en cuenta las siguientes mejores prácticas:

1. **Uso de Control de Versiones:**
Usar Git para controlar las versiones del proyecto. 
Crear ramas para nuevas funcionalidades o correcciones de errores, y realizar PRs (Pull Requests) para revisiones de código.

2. **Documentación y Comentarios:**
Comentar el código donde sea necesario y utiliza Javadoc para documentar las clases y métodos en Java. La claridad es clave para un código mantenible.

3. **Gestión de Incidencias:**
Usar GitHub Issues para rastrear y gestionar errores, nuevas funcionalidades u otras tareas relacionadas con el proyecto.

4. **Pruebas de Código:**
Implementar pruebas unitarias para todas las funciones críticas. 
Usar herramientas como JUnit para verificar el correcto funcionamiento del código.

5. **Consistencia del Código:**
Seguir las convenciones de estilo de código en Java. Se puede usar un linter o formatter para asegurar la coherencia.

6. **Seguridad:**
Mantener las dependencias actualizadas y revisar regularmente por vulnerabilidades. Implementar prácticas seguras, sobre todo en la gestión de datos y autenticación.

7. **Optimización y Escalabilidad:**
Considerar la escalabilidad al diseñar nuevas funciones. Usar patrones de diseño donde sea apropiado para promover la reutilización y la eficiencia.

8. **Feedback y Mejora:**
Fomentar una cultura abierta de feedback y mejora continua. 
Usar revisiones de código para mejorar la calidad del mismo y promover el aprendizaje compartido.

Implementar y mantener estas mejores prácticas ayudará a asegurar que el proyecto se desarrolle de manera eficiente y ordenada, facilitando su mantenimiento y evolución futura.
¡Muchas gracias!

## Instrucciones de uso
- Acceder a la aplicación en el navegador ingresando al puerto configurado (http://localhost:8080)
- Regístrarse o iniciar sesión para comenzar a jugar
- Para responder a la pregunta, escribir el número de la respuesta correcta en la casilla
- Responder a la siguiente pregunta y seguir aprendiendo

## Contribuciones
Autoras es un proyecto colaborativo y sin fines de lucro. Si deseas contribuir, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu nueva funcionalidad (git checkout -b feature/nueva-funcionalidad).
3. Haz commit de tus cambios (git commit -m 'Añadir nueva funcionalidad').
4. Realiza un push a la rama (git push origin feature/nueva-funcionalidad).
5. Crea un Pull Request.

# Contacto y soporte
Si tienes cualquier duda, contacta a nuestro equipo de soporte (soporte@autoras-app.com)


## Licencia
Este proyecto está disponible bajo la [CC0 1.0 Universal (CC0 1.0) - la dedicatoria de dominio público](LICENSE), permitiendo su uso libre para cualquier propósito.