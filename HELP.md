# Assessment Project
This is a demo project for a specific coding assignment.
There are 2 different services namely accounting and transactions.
They are separated by using Spring Profiles.
So each runs on different web servers and communicates with each other when necessary.
If one of these services does not run, an informative explanation is returned with HTTP 503 Service Unavailable error.
The server ports are 8090 and 8081 and the URL's are hardcoded.

## Technologies Used
* Java SE 8
* Spring Boot 2.7.2
* Maven
* JUnit
* Lombok

