# REST API application

Application  API REST to Hacker detection



## Tools


    STS 4 Spring Boot

    Junit

    Postman


# REST API

    A system provided by a company allows customers to sign in using their username and password. 
    There is a requirement for an automated system to be developed to help identify
    attempts to hack the system and compromise accounts. Activity log files are recorded and
    the new system will need to process these logs to identify suspicious activity.
    • GET method that given a record returns if it is suspicious
    • GET method that given two RFC2822 dates calculates the number of minutes between them

## Request a suspicious  IP

### Request

`GET http://localhost:8080/hackertest/detection?logLine=80.238.9.180,1336129472,SIGNIN_FAILURE,Jaden.Smith`

    curl --location --request GET 'http://localhost:8080/hackertest/detection?logLine=80.238.9.180,1336129472,SIGNIN_FAILURE,Jaden.Smith'

### Response

    Status: 200 OK
    Content-Type: application/json
        80.238.9.180

    
## Request number of minutes

### Request

`GET http://localhost:8080/hackertest/calculateTime?time1=Tue, 07 Feb 1984 12:34:56 +0700&time2=Tue, 07 Feb 1984 12:35:56 +0700`

    curl --location --request GET 'http://localhost:8080/hackertest/calculateTime?time1=Tue, 07 Feb 1984 12:34:56 +0700&time2=Tue, 07 Feb 1984 		12:35:56 +0700'

### Response

    Status: 200 OK
    Content-Type: application/json
        1

        