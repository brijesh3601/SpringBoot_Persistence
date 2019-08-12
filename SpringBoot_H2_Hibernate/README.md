- Run DemoApplication (mvn spring-boot:run)


- Browse http://localhost:8080/h2 and two records will be seen.  data.sql & schema.sql will be auto execute on start of DemoApplication


- Browse http://localhost:8080/customers/1 to view first record


- Execute POST command using file resources/hreq/postdata.txt. Execute both commands if records is not present it will create record and will update if record is present.