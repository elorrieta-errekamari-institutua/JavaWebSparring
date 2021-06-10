# JavaWebSparring
Proyecto Web **Java EE** siguiendo el patrón de **MVC** contra una bbdd **Mysql**\
CMS para gestionar los cursos y los participantes de Lanbide

## Tecnologia
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

## Configuracion de la base de datos

Para crear la bbdd disponemos de un script **script-db.sql** en la raiz del proyecto, el cual crear el esquema **supermercado** y las tablas necesarias, ademas de insertar datos de prueba.

![screenshot 2]( /docs/resources/esquemaDB.png?raw=true)

Para realizar la conexión a la bbdd cambiar el siguiente fichero **src/main/webapp/META-INF/context.xml**

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

## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 10.0**.

Al tratarse de una aplcacion de gestion y por falta de tiempo solo el administrador puede navegar por las diferentes funciones aunque la base de datos y el proyecto estan preparados para gestionar diferentes roles.
Tenemos dos roles diferentes:

1. Administrador   **[Wanda,3WiXc6G]** : Permisos Totales para crear, ver, modificar o eliminar cualquier objeto de la base de datos

*Las contraseñas **no** estan haseadas dentro de la bbdd.*


## Estructura Clases del proyecto

Interesante consultar la documentacion [JavaDoc API](https://elorrieta-errekamari-institutua.github.io/JavaWebSparring/).

Intersante mirar los siguientes packages de java:

* **com.elorrieta.controller.commons** Paquete con todos los controladores
* **com.elorrieta.controller.filter** Filtros de seguridad
* **com.elorrieta.file.parser**	Paquete con los parseadores de excel
* **com.elorrieta.modelo.dao** Clases que implementan el acceso a la base de datos
* **com.elorrieta.modelo.pojo** Clases que implementan los objetos represntados en la aplicacion
* **com.elorrieta.utilities** Contiene las clases necesarios para el funcionamiento del controlador unico

