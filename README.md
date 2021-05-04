# JAVA Rest API to retrieve product information by myRetail company.

# Application information:
This application connects to query a mongodb datastore which has product information. The connection parameters for mongo db can be found in appliation.properties file in src/main/resources directory.

**Product Controller** is the rest controller that has the api methods exposed as rest resources.

**Product Repository** is SimpleMongoRepository to retrieve and update product information.

**ProductNameRetrievalService** is a helper class to call the internally hosted rest service to retrieve the name of the product. The response the internal service is mapped to the unmarshalled into pojo's using ObjectMapper class.

# Build Information:
Import the myretail-restapi project into eclipse or rad as Gradle project.
To build this application from command line or terminal, navigate to project directory and run the following command

	Run:	./gradlew bootRun
	Debug:	./gradlew bootRun --debug
	
An embedded tomcat server is ready to receive the request either from browser or command line.

## To launch application from browser, use following commands:
View all products: http://localhost:8181/products
View product by ID: http://localhost:8181/products/13860428

## To launch application from command line, use following commands:

### To update:
**curl -i -X PUT -H "Cd '{"value":100, "currency_code":"USD"}' localhost:8181/products/13860428**

### To get:
**curl -i -H "Accept: application/json" localhost:8181/products/13860428**

