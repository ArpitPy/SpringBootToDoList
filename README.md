# 📝 To-Do List Application
## This is an over engineered To-Do application made using Spring Boot.
It used advance concepts like:
- Custom Error Handling
- Clean API using DTOs
- Controller-Service architecture

### ❓ How to use?
- Run the spring boot application, the app will open at localhost:8080
- Then open Postman and create API requests to the app.
- Here are some sample requests:
```
Request Type: POST
Link: http://localhost:8080/api/tasks
JSON Body:
{
  "title": "Feed dog",
  "description": "Give food to dog"
}
```

```
Request Type: GET
Link: http://localhost:8080/api/tasks
```
```
Request Type: GET
Link: http://localhost:8080/api/tasks/<put task id here>
```
```
Request Type: PUT
Link: http://localhost:8080/api/tasks/<put task id here>
JSON Body:
{
  "title": "Feed dog",
  "description": "Give food to dog",
  "completed": true
}
```
```
Request Type: DELETE
Link: http://localhost:8080/api/tasks/<put task id here>
```
