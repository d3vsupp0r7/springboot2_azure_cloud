# springboot2-ms-type-a

# Run
Default Port: 8080  
Default URL : http://localhost:8080/  

# H2 DB
http://localhost:8080/console/  

# REST API Exposure
## Employee REST API
### GET
#### List all employees
**URL:** http://localhost:8080/employee/all  

#### Get Employee by id
**URL: ** http://localhost:8080/employee/10001
(ID of employee preloaded with H2 initial load script )

**URL: ** http://localhost:8080//employee/1
(Invocation on id not present into with H2 initial load script )

### POST
#### Create a new employee
**URL: ** http://localhost:8080/employee  
**JSON BODY for request:**

```json
{
    "name": "EmployeeName_1_create_from_post",
    "surname": "EmployeeSurname_1_create_from_post"
}
```

Note: Ensure that into request there are:
1) Header config:
**Key: ** Content-Type - **Value: ** application/json  

### PUT
#### Update an existing employee
**URL: ** http://localhost:8080/employee/10004  
**JSON BODY for request:**

```json
{
  "id":"10004",
  "name":"EmployeeName_2_Mod",
  "surname":"EmployeeSurname_2_Mod"
}
```
Note: Ensure that into request there are:
1) Header config:
**Key: ** Content-Type - **Value: ** application/json  

### DELETE
#### Delete Employee by id
**URL: ** http://localhost:8080/employee/10004

# SOAP WSDL Service
## Exposed SOAP WS
**Soap WSDL url: ** http://localhost:8080/ws/soapwsdl-endpoint.wsdl