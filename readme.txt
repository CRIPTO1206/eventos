La ruta del repositorio github donde se encuentra el código del reto es https://github.com/CRIPTO1206/eventos

Dicho reto se realizó en java con microservicos en spring boot.

Para correr el código, es necesario clonar el repositorio github y dejarlo en una carpeta local de un espacio de trabajo o workspace.

Adicionalmente, es necesario descargar e instalar la jdk de java 11, un ide de desarrollo (como sugerencia IntelliJ), maven y tener instalada la BD postgresql.

Es necesario crear en postgresql una base de datos llamada eventos( Se adjunta el script de creación).

Una vez descargado el repositorio, la jdk de java y el ide de desarrollo, procedemos a correr el código dando click derecho sobre la clase src/main/java/com/eventos/EventosApplication.java y seleccionando la opción RUN.

Automáticamente empieza a subir el servidor.

El proyecto tiene configurado como username postgres y como password admin, si credenciales son diferentes, es necesario acrualizarlas en el archivo src/main/resources/application.properties.

Si se realizaron ajustes de las credenciales es necesario repetir el proceso de subir el servidor.

una vez arriba el servidor, se puede ejecutar la API desde postman (Se adjunta el proyecto postman).

Los endpoint manejados son las siguientes:


GET		localhost:8080/servicios/geocodificacion 	(REQUIERE PARAMETROS)
			ejm:
						direccion: 	Carrera 2 #16A-38 Bogotá, Colombia
						rango :		100

GET		localhost:8080/servicios/eventos

GET		localhost:8080/servicios/eventosXasistentes

GET		localhost:8080/servicios/asistentes

GET		localhost:8080/servicios/eventos/x (# DE EVENTO)

GET		localhost:8080/servicios/eventosXasistentes/x (# DE EVENTOxASISTENTE)

GET		localhost:8080/servicios/asistentes/x (# DE ASISTENTE)

POST	localhost:8080/servicios/eventos	(REQUIERE BODY)
			ejm:	{
						"nombre": "Evento 4",
						"descripcion": "Descripcion evento 4"
					}
					
POST	localhost:8080/servicios/eventosXasistentes(REQUIERE BODY)
			ejm:	{
						"idAsistente": "1",
						"idEvento": "1",
						"fecha": "21 febrero 2024",
						"hora": "8:00 pm",
						"descripcion": "Test de Prueba"
					}
			
POST	localhost:8080/servicios/asistentes(REQUIERE BODY)
			ejm:	{
						"nombre": "Nombre Asistente 1",
						"apellido": "Apellido Asistente 1"
					}
					
POST	localhost:8080/servicios/eventos(REQUIERE BODY)
			ejm:	{
						"id": 1,
						"nombre": "Evento 1",
						"descripcion": "Descripcion evento 1"
					}
					
POST	localhost:8080/servicios/eventosXasistentes(REQUIERE BODY)
			ejm:	{
						"id": 1,
						"idAsistente": 1,
						"idEvento": 1,
						"fecha": "21 febrero 2024",
						"hora": "9:00 pm",
						"descripcion": "Test de Prueba"
					}
					
POST	localhost:8080/servicios/asistentes(REQUIERE BODY)
			ejm:	{
						"id": 1,
						"nombre": "Nombre Asistente 1",
						"apellido": "Apellido Asistente 1"
					}
					
DELETE	localhost:8080/servicios/eventos/x (# DE EVENTO)

DELETE	localhost:8080/servicios/asistentes/x (# DE ASISTENTE)


Tambien es posible ver y hacer pruebas desde swagger, ruta local: http://localhost:8080/servicios/swagger-ui/index.html#


Para la funcionalidad de Geocodificación Inversa fue necesario generar una clave propia de API de Google Maps desde la consola de Google Cloud (AIzaSyA8Sq2SjrHdfY84uakxZtJCgs9WTMt3JsY).

En caso de contarse con su propia prueba, se debe actualizar la variable apiKey en la clase src/main/java/com/eventos/controller/GeocodificacionController.java.

En la carpeta Docs_Adicionales hay varios archivos de apoyo y algunas evidencias.

El video donde se explica y se muestra brevemente la ejecución del reto se puede encontrar en la ruta: https://drive.google.com/file/d/16fl2DiWC384mgLDwt2wm7pzDuUSha8dn/view?usp=sharing