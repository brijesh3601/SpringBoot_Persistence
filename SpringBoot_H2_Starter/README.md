- Execute : mvn spring-boot:run

- Browser http://localhost:8088/h2. Click 'Connect' to see 'Customers' table.


-  @PostConstruct is used to drop/create 'Customers' table & insert records


- Create file 'test.mv.db' at location home ( MAC cd ~, Windows cd c:\ or check c:\users\{yourname})  in case if it is not present. test.mv.db is file created due to file-based storage property declared by "spring.datasource.url=jdbc:h2:file:~/test"



Dependencies
---
- spring-boot-starter-jdbc  : to use JdbcTemplate
- spring-boot-starter-data-rest : for restful service but here it is used as container, either/or spring-boot-starter-data-web can be used as well

Reference
- https://www.baeldung.com/spring-boot-h2-database

