### Why this project?
This is a project to practice a reactive programming using Spring WebFlux.

For this example, we use : 
- spring-boot-starter-webflux (maven dependency)
- spring-boot-starter-data-redis-reactive (maven dependency)
- **'redis'** as a database.

### How to test

1- Run a redis server. 
We will use docker to run an instance : 
- create a docker network : `docker network create mynet`
- deploy redis using a docker image : `docker run --name redis-users -p6379:6379 --net mynet -d redis`

2- Run a spring application : 
- using maven : `./mvnw spring-boot:run`
- or build the project with maven `./mvnw clean package` and launch the jar `java -jar target/reactive-users-0.0.1-SNAPSHOT.jar`
- or using docker : build the project with maven `./mvnw clean package` 
and execute `docker run --name=reactive-users -p8080:8080 --net mynet -e redis-host="redis-users" aallou/reactive-users:0.0.1-SNAPSHOT`

3- Call api (using httpie (https://github.com/jakubroztocil/httpie#json) with terminal)
- Get all users : `http localhost:8080/users`
- Get all users as a stream : `http :8080/users Accept:application/stream+json --stream`
- Get all users using curl with limit (back pressure) : curl -H Accept:application/stream+json localhost:8080/users --limit-rate 1K (see https://curl.haxx.se/mail/archive-2004-02/0062.html)
- Add a new user : `http -v localhost:8080/users firstName=Abdelhafid lastName=Allou`
