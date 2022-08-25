# Citizen

## Requirements and Tech Stack

Java 11, Spring, Spring Boot, Hibernate, JUnit and Intellij or Eclipse for development and run.

##ApiList

####Citizen-Api
###### EndPoints

---
- /citizen -> Post (Create Citizen)
---
- /citizen -> Put (Update Citizen)
---
- /citizen/{citizenId} -> Get (Get Citizen By Id)
---
- /citizen/find-by-parameters -> Post (Find Citizen By Parameters)
---
## Testing Application

### Run Application

- mvn clean package
- docker-compose up

This application has a swagger implementation for testing.
Just go to [Swagger Link](http://localhost:8080/swagger-ui/index.html#/) after run the app.


## Postman Collection
You can use this link to access collections of API's -> https://www.getpostman.com/collections/f4699ffad730c3b35491