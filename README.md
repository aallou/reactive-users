### Why this project?
This is a project to practice a reactive programming using Spring WebFlux.

For this example, we use : 
- spring-boot-starter-webflux (maven dependency)
- spring-boot-starter-data-redis-reactive (maven dependency)
- **'redis'** as a database.

### How to test

1- Run a redis server. 
To deploy a redis instance, you can use a docker image (`docker run --name redis-users -p6379:6379 -it redis`)

2- Run a spring application : 
- using maven : `./mvnw spring-boot:run`
- or build the project withmaven `./mvnw clean package` and launch the jar `java -jar target/reactive-users-0.0.1-SNAPSHOT.jar`

3- Call api (using httpie (https://github.com/jakubroztocil/httpie#json) with terminal)
- Get all users : `http localhost:8080/users`
- Add a new user : `http -v localhost:8080/users firstName=Abdelhafid lastName=Allou`
