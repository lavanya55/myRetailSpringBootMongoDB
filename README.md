**About**
myRetail is a rest service that returns product description and price details given product id.

 - Price details are stored in mongoDB which is hosted on mLab.
 - Product description comes from external API
 - myRetail combines both information and returns response in json format
 - Used Spring Boot to create the project
 - The application is deployed to Heroku, working example can be found here http://myretail5.herokuapp.com/
 - Resource discovery starts at http://myretail5.herokuapp.com/
All database records can be seen using
http://myretail5.herokuapp.com/productsDaos?size

**Rest Service Contract:**
*Title:* Get product information by product id.
*URL:* http://myretail5.herokuapp.com/v1/products/{productId}
*Method:* **GET**
*Pathvariable:* productId - must be integer
 *Returns:* json response
    Example:
{"productId":13860428,"name":"some name","currentPrice":{"value":"10","currencyCode":"USD"}}

*Title:* Updates product price
*URL:* http://myretail5.herokuapp.com/v1/products/{productId}
*Method:* **PUT**
*PathVariable:* productId - must be integer
*Returns:* json response
*accepts:* json requestBody same as response for GET.

**Error Responses**

 - When productid is forbidden in external rest api
http://localhost:8080/v1/products/15117729
{"httpStatus":403,"httpstatusPhrase":"Forbidden","message":"403 Forbidden"}

 - When product id is not found in external rest api
http://localhost:8080/v1/products/12345
{"httpStatus":404,"httpstatusPhrase":"Not Found","message":"404 Not Found"}

 - When product id is not found in database
http://localhost:8080/v1/products/16860481
{"httpStatus":404,"httpstatusPhrase":"Not Found","message":"Record not found in database"}

 - All other errors
http://localhost:8080/v1/products/xyz
{"httpStatus":500,"httpstatusPhrase":"Internal Server Error","message":"Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"xyz\""}







