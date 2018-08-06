# Polling Bot

## Description
Polling bot is a bot that provides poll creation services in a group chat. Polling bot is also user friendly because it does not interfere with the conversation between users. This bot poll can be active when pressed 'help', so bot will give guide about codes to operate bot.

nb: this bot poll only support the respondent text, while button not yet support. Due to technicality.
## Getting Started
This project use the [Gradle](https://spring.io/guides/gs/gradle/) build system.

First download the project by cloning this repository or downloading an archived snapshot. (See the options on the right hand side.)

You can open the project in your favorite IDE such as IntelliJ, NetBeans, STS, Eclipse, etc. In IntelliJ, go to ```File > Open > Select one of the sample directories that you downloaded from this repository > Select the build.gradle file > Ok.``` This should load the project properly.

This project uses [JpaRepository](http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html) feature from spring framework and [Flyway](https://flywaydb.org) to easily migrate the database.

## Run in Localhost
To Run this project in your localhost, make sure you have Java and MySQL installed.
###MySQL
You can download MySQL [here](http://dev.mysql.com/downloads/). Take a look at ```application.properties```, and you'll see ```spring.datasource.url =jdbc:mysql://localhost/polling_bot```. This means the project will migrate the database to your local database named **polling_bot**.

First start your MySQL and create your database by opening ```http://localhost/phpmyadmin``` in your browser. Select ```Databases``` then create a database named **polling_bot**. Voila, done. You don't need to do anything else. Once the program Run, it'll automatically migrate the databases created in project to your localhost. 

**DO NOT** change anything in your movie database (phpmyadmin).

###Run & Send Request 
Once the project loaded properly in your IDE, right click on ```PollingApplication.java``` then select ```Run```. It should build and run the project. 

If you look at ```application.properties``` file, you could see ```server.port=8080```, so this means that the program use server in port 8080.

You can use [Postman](https://www.getpostman.com) to help you construct request quickly. In Postman, set URL to ```http://localhost:8084/kaskus``` with method type **POST**. As for the body, construct JSON needed for the request. API can be found in [Kaskus Chat API](http://slate.obrol.id/#introduction).
