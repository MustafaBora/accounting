# accounting
This is a demo project for a specific coding assignment.

# Assessment Project
#### This is a demo project for a specific coding assignment.
#### There are 2 different services namely accounting and transactions.
#### They are separated by using Spring Profiles.
#### Each runs on different servers and communicates with each other when necessary</b>.
#### If one of these services does not run, an informative explanation is returned with HTTP 503 Service Unavailable error.
#### The server ports are 8090 and 8081 and the URL's are hardcoded.

## Technologies Used
* Java SE 8
* Spring Boot 2.7.2
* Maven
* JUnit
* Lombok

##Note
There are no database connections. Data is held in memory in HashMaps.
There are 4 predefined users with CustomerID:  
1BIL, 2CYB, 3HVL, 4CGM  
Each have its accounts  
1, 2, 3, 4
Account ids increase by 1 starting from 1.  
There are 4 predefined transactions. Their ids are  
1000 1010 1020 1030 and increases by ten for new ones.

# Try it!
* Useful links to try as a backend demo:
##Accounting:
#### To create a new account and its first transaction:
* POST localhost:8090/api/v1/account
  Request Body: { "customerID":"1HVL", "initialCredit": 1 }
* POST localhost:8090/api/v1/account
  Request Body: { "customerID":"2CYB", "initialCredit": 2 }
* POST localhost:8090/api/v1/account
  Request Body: { "customerID":"3HVL", "initialCredit": 3 }
* POST localhost:8090/api/v1/account
  Request Body: { "customerID":"4CGM", "initialCredit": 4 }
#### To get account ids array from customer id
* GET localhost:8090/api/v1/account/accountIds/1HVL
* GET localhost:8090/api/v1/account/accountIds/2CYB
* GET localhost:8090/api/v1/account/accountIds/3HVL
* GET localhost:8090/api/v1/account/accountIds/4CGP
#### Customer detailed information by CustomerId
* GET localhost:8090/api/v1/account/getByCustomerId/1HVL
* GET localhost:8090/api/v1/account/getByCustomerId/2CYB
* GET localhost:8090/api/v1/account/getByCustomerId/3HVL
* GET localhost:8090/api/v1/account/getByCustomerId/4CGM
#### To get an account information without its transactions:
* GET localhost:8090/api/v1/account/8

##Transactions
* GET http://localhost:8081/api/v1/transaction/transactionsByAccountId/1
* GET http://localhost:8081/api/v1/transaction/transactionsByAccountId/2
* GET http://localhost:8081/api/v1/transaction/transactionsByAccountId/3

* POST http://localhost:8081/api/v1/transaction/
  Request Body { "accountID":1, "value":100 }
* POST http://localhost:8081/api/v1/transaction/
  Request Body { "accountID":2, "value":100 }
* POST http://localhost:8081/api/v1/transaction/
  Request Body { "accountID":3, "value":100 }

* GET http://localhost:8081/api/v1/transaction/transactionsByCustomerId/1BIL
* GET http://localhost:8081/api/v1/transaction/transactionsByCustomerId/2CYB
* GET http://localhost:8081/api/v1/transaction/transactionsByCustomerId/3HVL
* GET http://localhost:8081/api/v1/transaction/transactionsByCustomerId/4CGP
