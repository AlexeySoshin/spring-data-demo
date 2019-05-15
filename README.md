# Spring Data demo

This projects aims to demonstrate some capabilities of Spring Data and Spring Data REST that may be not documented well enough. <br />
We'll create a simple object and an interface, adding only custom methods to the interface. <br />
Everything else we'll get from the framework.

In addition to complex queries, this project also demonstrates how data could be altered using event handlers

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