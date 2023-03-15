# Overview

An example project to demonstrate:
* how to create a Spring Boot REST API 
* how to run Spring Boot in Docker and publish to Docker Hub 
* how to deploy the Spring Boot application to AWS with CloudFormation 

# Pre-requisites 
* JDK 11 
* Docker 

# Building 

## Testing 
```./gradlew test```

## Building (no tests) 
```./gradlew assemble```

## Building (with tests) 
```./gradlew build```

## Running in Docker 
```./gradlew assemble docker dockerRun```

## Stopping Docker container 
```./gradlew dockerStop```

## Deploying to AWS 
```./gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId= -Pregion=```

## Deleting AWS deployment 
```./gradlew awsCfnDeleteStack awsCfnWaitStackComplete```

Using API get all books - GET /book to get a list of all the books get specific book - GET /book?=${bookname} to get a specific book create book - POST JSON to /books to create a new book
