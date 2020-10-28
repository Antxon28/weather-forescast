# Introducción

**WeatherForecast** es un ejercicio similar a la [Weather kata](https://github.com/CodiumTeam/weather-kata) de [Codium Team](https://www.codium.team).

Se trata de una clase con un método público que devuelve la previsión del tiempo de una ciudad en una fecha concreta.

Para ello, esta clase utiliza una API externa (requiere conexión a internet): [www.metaweather.com](https://www.metaweather.com) 

Ejemplo:

```java
WeatherForecast weatherForecast = new WeatherForecast();
weatherForecast.getCityWeather("Madrid", new Date());
```


# Ejercicio

El ejercicio consiste en **refactorizar** el código para hacerlo más **mantenible**, ya que el código existente, aunque **funciona**, es muy difícil de entender. 
  
Para ello se pueden realizar múltiples modificaciones siempre que se mantenga el API público. Ejemplos de modificaciones: incluir tests automáticos, extraer métodos, renombrar variables, modificar tipos de datos, crear nuevas clases, añadir librerías, etc. 


# Documentación

La solución debería contener un fichero README donde se respondan estas preguntas:
- ¿Qué has empezado implementando y por qué?
- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?
- ¿Qué componentes has creado y por qué?
- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?
- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
- ¿Qué piensas del rendimiento de la aplicación? 
- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
- ¿Cuánto tiempo has invertido para implementar la solución? 
- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?


# A tener en cuenta

- Se valorará positivamente el uso de TDD, se revisarán los commits para comprobar su uso.
- Se valorará positivamente la aplicación de los principios SOLID y "código limpio".
- La aplicación ya tiene un API público: un método público que devuelve el tiempo en un String. No es necesario crear nuevas interfaces: REST, HTML, GraphQL, ni nada por el estilo.


# Entrega

La solución se puede subir a un repositorio de código público como [github](https://github.com/). 

Otra opción sería comprimir la solución (incluyendo el directorio .git) en un fichero .zip/.tar.gz y enviarlo por email.


#############################

# Repuesta a la documentación

**- ¿Qué has empezado implementando y por qué?**

La creación de nuevos test unitarios:
	- la búsqueda del tiempo en una ciudad con tiempo especificado
	- la búsqueda del tiempo en una ciudad sin tiempo especificado
	- la búsqueda del tiempo en una ciudad con nombre erroneo
	
Esto es debido a la metodología TDD. 
Me situo desde el punto de vista del usuario, las acciones comunes que se lograría realizar para así tener y saber como ha de funcionar la aplicación por detrás.


**- ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?**

Los dos problemas con los que me encontré fueron: 
	- La falta de implementación de métodos que recibieran los parámetros a buscar.
		Esto debido a que los test unitarios cambiaron de parámetros.
	- La fecha de búsqueda.
		Hago incapié debido a que dependerá mucho de la interfaz con la que interactue el usuario, la fecha se mostrará en un formato u otro.


**- ¿Qué componentes has creado y por qué?**

He requerido de la creación de dos nuevas clases:
	- Utils.java
	- Constants.java
	
Debido a que serán clases de utilidad para el desarrollo, contendrán métodos y variables que se podrán reutilizar a lo largo de la aplicación.
Su creación permite modularizar mejor el desarrollo.


**- Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?**

Únicamente he requerido de la dependencia "commons-lang3".
Esto se debe a que ofrece la posiblidad de controlar mejor la validación de cadenas con métodos tales como isNotBlank(), isBlank(), equals().


**- ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?**

Concretamente para esta refactorización de código no lo he usado.

Son nuevas formas de programación que resultan muy útiles, aunque actualmente no lo haya usado, sí que facilitan el trabajo.


**- ¿Qué piensas del rendimiento de la aplicación?**

Es una aplicación bastante sencilla, sin complejidad alguna más que de entender la API externa usada.
Aunque he de resaltar que para ser sencilla se complica mucho debido a los endpoints que ofrece la API.
Son dependientes, es decir, se requiere invocar al primer endpoint simplemente para recoger el valor WoeID para después enviarlo en el segundo endpoint.
Son dos llamadas incesarias debido a que se podría desarrollar un endpoint más específico.

Luego, la forma de obtener el tiempo para un día específico tampoco es el adecuado ya que se requiere de una iteración para recoger el día exacto.
Comprendo que la API ofrezca devolver más de un día y es de total agrado pero si solamente se desea saber un día en específico, el programador debe implementar lógica suya por detrás.


**- ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?**

Debido a que para saber el tiempo de una ciudad se requiere el consumo de dos endpoints, este supone una latencia importante a la hora de ejecutar la aplicación.
Una de las soluciones idóneas sería almacenar, ya sea en base de datos, memoria o fichero local, el WoeID de las ciudades consultadas previamente, con esto, el primer endpoint solo sería útil para las ciudades nuevas o consultadas por primera vez.

La segunda opción, sería almacenar también la respuesta del tiempo de una ciudad para un día (y demás días) específico. Haciendo uso de esta lista en vez de hacer llamadas continuas al endpoint.


**- ¿Cuánto tiempo has invertido para implementar la solución?**

3 horas

**- ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?**

Pienso que en todo escenario siempre es bueno refactorizar código y tener buenos manejos en la práctica de Código Limpio.
Esto evitará la perdida de tiempo intentando adivinar lo que hace el código y será una forma robusta de ser mantenido en un futuro, tanto para solventar problemas como para añadir nueva funcionalidad.