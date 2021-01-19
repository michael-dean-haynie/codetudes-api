# Codetudes API

A Spring Boot RESTful API with endpoints for CRUD operations on codetudes.com data.

## Local Development Setup
1. Use [codetudes-schema-backup.sql](./database/codetudes-schema-backup.sql) to initialize codetudes database (mysql)
1. Make a copy of [application.properties.example](./application.properties.example), remove `.example` off the end of the file name and update the configurations as necessary for your environment
    * `seed-db-on-startup` will empty all tables and populate with example data upon application startup.
1. Build
1. Run

## Build
From root: `mvn clean install`

## Run
From root: `mvn spring-boot:run`
