# spring-boot-security-acl-code-config

## Quick Overview

Pre-installed Requirements: Java 1.8+, Maven, MySQL.
Pre-execution Requirements: Turn off any existing Tomcat server running on port 8080 and ensure MySQL is running.

The will allow you to use Curl from the command line to issue REST API calls to your local server (embedded Tomcat comes with the project) that require you to Authenticate and then access a few basic endpoints that return a row from the database. Once of them is under the control of Spring Security ACL and required an authenticated role and the other two just require the user to be authenticated but use JPA to access instead of JdbcNamedTemplate used in the first one.
*** All commands provided below***

### Set-up:

Create a database (call it whatever you like) and import in the SQL from the ***java_spring_angular_rest_security_acl2.sql*** in the home directory.

Go to the directory where you want to install the project and then run the following commands:
```bash
git clone https://github.com/mccarthyr/spring-boot-security-acl-code-config
cd spring-boot-security-acl-code-config
cd src/main/resources/
```

From this location you need to edit the src/main/resource/application-development.properties file to add in your own username and password for the database connection along with whatever database name you have created to import in the database sql script with this project. You can also edit the application.properties file. The project uses the application-development.properties file but that is just because I was playing around with profiles at the time that are irrelevant to this project.
Once that is done then contine with the following:
```shell
cd ../../..
mvn install
```

Then once the Maven install is completed you can issue the following command:
```sh
mvn spring-boot:run
```

### Running the application :

The username and password used are: ***athlete1*** and ***test***
The REST API endpoints are defined in the AthleteAccountController.java

**To Authenticate**
```sh
curl -i -X POST -d username=athlete1 -d password=test  -c /opt/cookies.txt http://localhost:8080/login
```
This will set up the returned cookie in /opt/cookies.txt and also print out the returned header.

**To return a row from the database that is under Security ACL control (requires ROLE_ATHLETE)**
```sh
sudo curl -i -X GET -b /opt/cookies.txt 'localhost:8080/athleteAccount?acAction=view&athleteAccountId=35'
```

**To return the same row using JPA to access the database (all JPA in this is standard auto-configured Spring Boot)**
```sh
sudo curl -i -X GET -b /opt/cookies.txt 'localhost:8080/athleteAccount?acAction=viewByIdJpa&athleteAccountIdJpa=35'
```
**To logout**
```sh
sudo curl -i -X GET -b /opt/cookies.txt 'localhost:8080/logout'
```
