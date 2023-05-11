e-commerce , Prices Solution
============ 
Tech Stack
============
| Tech Stack  |
|-------------|
| Java 17     |
| H2          |
| Maven       |
| Spring boot |    


How to Run:
============
```console
mvn clean install
```
```console
mvn spring-boot:run
```


Endpoints:
============
http://localhost:8080/ecommerce-api/v1/price

Request example:
------------
```json
{
  "productId":35455,
  "brandId":1,
  "assignmentRequestDate": "2020-06-16 21:00:00"
}
```
Response example:
------------
```json
{
    "rate": 4,
    "startDate": "2020-06-15 16:00:00",
    "endDate": "2020-12-31 23:59:59",
    "priceProduct": 39,
    "product": {
        "productId": 35455,
        "productName": "ABC"
    },
    "group": {
        "brandId": 1,
        "brandName": "ZARA"
    },
    "currency": "EUR"
}
``` 



