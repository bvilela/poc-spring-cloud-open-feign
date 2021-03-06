# POC Spring Cloud OpenFeign

### Quality Status
[![build](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd.yml/badge.svg?branch=master)](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd.yml)
[![publish](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd_publish.yml/badge.svg)](https://github.com/bvilela/poc-spring-cloud-open-feign/actions/workflows/maven_ci_cd_publish.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bvilela_poc-spring-cloud-open-feign&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=bvilela_poc-spring-cloud-open-feign)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=bvilela_poc-spring-cloud-open-feign&metric=coverage)](https://sonarcloud.io/summary/new_code?id=bvilela_poc-spring-cloud-open-feign)

### Repository Statistics
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=bvilela_poc-spring-cloud-open-feign&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=bvilela_poc-spring-cloud-open-feign)
![GitHub repo size](https://img.shields.io/github/repo-size/bvilela/poc-spring-cloud-open-feign)
![GitHub language count](https://img.shields.io/github/languages/count/bvilela/poc-spring-cloud-open-feign)
![GitHub open issues](https://img.shields.io/github/issues-raw/bvilela/poc-spring-cloud-open-feign)
![GitHub open pull requests](https://img.shields.io/github/issues-pr/bvilela/poc-spring-cloud-open-feign)
<!--![GitHub forks](https://img.shields.io/github/forks/bvilela/poc-spring-cloud-open-feign)-->

## Summary
This PoC (Proof of Concept) uses Spring Cloud OpenFeign to make a REST calls to an API and to explore Lib's functions.

Click [here](https://medium.com/@brunovilela2008/java-fazendo-chamadas-rest-com-spring-cloud-openfeign-31f70f9144f7) for view article in Medium.

## Technologies
* Java 17
* Spring Boot 2.6.7
* [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
* [Lombok](https://projectlombok.org/)
* [SpringFox 3.0.0](https://springfox.github.io/springfox/)
* Gson 2.9.0
* Static Code Analysis: [SonarCloud](https://sonarcloud.io/)
* Maven

## GitHub Action
* Build and Test Java with Maven (branch master)
* Analyze SonarCloud (branch master)
* Publish on GitHub Packages (tag/release)

## Public APIs used
* [ViaCEP](https://viacep.com.br/)
* [JSONPlaceholder](https://jsonplaceholder.typicode.com/)

## Swagger DOC
http://localhost:8080/poc/swagger-ui/index.html#/

## CURLs Examplos
* **GET Busca CEP:**
```
curl --location --request GET 'localhost:8080/poc/busca-cep/01001000'
```
* **POST criar Post:** 
```
curl --location --request POST 'localhost:8080/poc/criar-post' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "foo",
    "body": "bar",
    "userId": 1
}'
```

[??? Voltar ao topo](#poc-spring-cloud-openfeign)<br>
