[![build](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd.yml/badge.svg?branch=master)](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd.yml)
[![publish](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd_publish.yml/badge.svg)](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd_publish.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bvilela_poc-spring-cloud-open-feign&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=bvilela_poc-spring-cloud-open-feign)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=bvilela_poc-spring-cloud-open-feign&metric=coverage)](https://sonarcloud.io/summary/new_code?id=bvilela_poc-spring-cloud-open-feign)

# POC Spring Cloud OpenFeign

### Summary
This PoC (Proof of Concept) uses Spring Cloud OpenFeign to make a REST calls to an API and to explore Lib's functions.

### Technologies
* Java 17
* Spring Boot 2.6.7
* [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
* [Lombok](https://projectlombok.org/)
* Static Code Analysis: [SonarCloud](https://sonarcloud.io/)

### GitHub Action
* Build and Test Java with Maven (branch master)
* Analyze SonarCloud (branch master)
* Publish on GitHub Packages (tag/release)

### Public APIs used
* [ViaCEP](https://viacep.com.br/)
* [JSONPlaceholder](https://jsonplaceholder.typicode.com/)

### CURLs Examplos
* **GET Busca CEP:** curl --location --request GET 'localhost:8080/poc/busca-cep/01001000'
