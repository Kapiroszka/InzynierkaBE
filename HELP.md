# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jooq)

### Uruchomienie lokalne

1) uruchomic baze danych po przez polecenie ```docker-compose up -d```
2) uruomic aplikacje z poziomu IDE

### Generowanie kode JOOQ 

Wygenerowanie kody na podstawie bazy lokalnej
 ```mvn -P jooq-service-db jooq-codegen:generate```