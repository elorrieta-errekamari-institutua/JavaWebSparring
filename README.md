# JavaWebSparring
Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una base de datos **Mysql**\
CMS para gestionar los cursos y los participantes de Lanbide

![screenshot 1]( /docs/resources/screenshot.png?raw=true)

## Tecnología
* [Maven 3.8.1](https://maven.apache.org/index.html)
* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* Jakarta Servlet Api 5.0.0
* JSP 3.0.0
* JSTL 2.0.0
* Jakarta Validation Api 3.0.0
* [Bulma 0.9.2](https://bulma.io/)
* [FontAwesome 5.10.0](https://fontawesome.com/)
* [Simple Datatables Latest](https://github.com/fiduswriter/Simple-DataTables)

Para ver mas detalles sobre las depencias de este proyecto mirar el [pom.xml](https://github.com/elorrieta-errekamari-institutua/JavaWebSparring/blob/master/pom.xml)

## Configuración de la base de datos

Para crear la base de datos disponemos de un script **script-db.sql** en */src/main/resources/db*, el cual crear el esquema **elorrieta** y las tablas necesarias, ademas de insertar datos de prueba.

![esquemaDB]( /docs/resources/esquemaDB.png?raw=true)

Para realizar la conexión a la base de datos cambiar el siguiente fichero **src/main/webapp/META-INF/context.xml**

```
<?xml version="1.0" encoding="UTF-8"?>
<Context>
	<Resource auth="Container" 
	    driverClassName="com.mysql.cj.jdbc.Driver"
		maxActive="100" 
		maxIdle="30" 
		maxWait="10000" 
		name="jdbc/elorrieta"	 
		type="javax.sql.DataSource"
		url="jdbc:mysql://localhost:3306/elorrieta" 
		username="root"
		password="root" 
		/> <!-- Pon tu propia clave -->
</Context>	
```

Tambien disponemos de dos documentos excel para probar las funcionalidades en */src/main/resources/excel/input*

## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 10.0**.

Al tratarse de una aplicacion de gestión y por falta de tiempo unicamente el administrador puede navegar por las diferentes funciones aunque la base de datos y el proyecto están preparados para gestionar diferentes roles.

Tenemos dos roles diferentes:

1. Administrador   **[admin,admin]** : Permisos totales para crear, ver, modificar o eliminar cualquier objeto de la base de datos
2. Usuario **[user,user]** : No tiene ningun permiso

*Las contraseñas estan hasheadas en MD5 dentro de la base de datos.*

## Estructura Clases del proyecto

Interesante consultar la documentación [JavaDoc API](https://elorrieta-errekamari-institutua.github.io/JavaWebSparring/).

Intersante mirar los siguientes packages de java:

* **com.elorrieta.controller.commons** Paquete con todos los controladores
* **com.elorrieta.controller.commons.api** Paquete con API para acceder a datos a traves de AJAX
* **com.elorrieta.controller.filter** Filtros de seguridad
* **com.elorrieta.file.parser**	Paquete con los parseadores de excel
* **com.elorrieta.modelo.dao** Clases que implementan el acceso a la base de datos
* **com.elorrieta.modelo.pojo** Clases que implementan los objetos representados en la aplicacion
* **com.elorrieta.utilities** Contiene las clases necesarias para el funcionamiento del controlador único

## Funcionamiento del controlador BackOffice

Todas las operaciones que se realizan en el backoffice pasan por un solo controlador llamado **BackOfficeController (/action)** que recogera los parametros **clase** **operacion** e **id** en forma de enteros, si cualquiera de ellos no existe se le asignará -1, y **edicion** en forma de booleano, este controlador entonces llamará a las clases almacenadas en el paquete **com.elorrieta.utilities** para realizar las operaciones necesarias, en caso de no existir los parametros de clase u operación volvera a index.

## Estado del proyecto

Por falta de tiempo actualmente únicamente están implementadas las siguientes acciones: 

1. Sin iniciar sesión:

* Iniciar sesión
* Registrar usuario sin privilegios

2. Para el administrador:

* Crear, editar, borrar o listar participantes.
* Crear, editar, borrar o listar cursos.
* Crear, editar, borrar o listar aulas.
* Crear ediciones a partir de un curso existente, pudiendo agregar hasta cinco aulas previamente creadas.
* Editar, borrar o listar ediciones.
* Importar participantes o ediciones a partir de un documento de excel, en caso de las ediciones si estas pertenecen a cursos nuevos o contienen aulas nuevas estos tambien serán creados
* Cerrar sesión

3. Para el suario sin privilevios:
* Cerrar sesión