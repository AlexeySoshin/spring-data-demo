# Spring Data demo

## Creating DB
``` 
createdb springdata
```

## Running
```
./gradlew bootRun
```

## Exploring your data

* List available resources:
http://localhost:8080/api/

* Create new customer
```
POST http://localhost:8080/api/customers
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{"name":"Alexey Soshin", "email": "alexeysoshin@gmail.com"}
```

* List all Customers:
http://localhost:8080/api/customers/

* List all custom queries on Customers:
http://localhost:8080/api/customers/search

* Get first Customer with the name containing `alex`, ignoring case
http://localhost:8080/api/customers/search/findFirstByNameIgnoreCaseContaining?name=alex

* Get all Customers with emails containing `@gmail.com`, order by ID in descending order 
http://localhost:8080/api/customers/search/findAllByEmailEndsWithOrderByIdDesc?email=gmail.com