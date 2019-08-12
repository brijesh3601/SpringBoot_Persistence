
- Run H2CommandLiner to add, delete & show customer count using CommandLineRunner. You can also use REST URL like http://localhost:8080/add.


- Run H2RestApplication to start application for REST.


- Either use H2RestApplication or H2CommandLiner in real scenario, as both are launched as both are using annotation @SpringBootApplication


- We are using @Async annotation with delayAddContact method. (Note : @EnableAsync can be used with @Configuration)

- Refresh on browser URL http://localhost:8080/dyladd and see the console to view Async effect. You will see on console that request comes in millisec while on console the Start log will be displayed while the Stop log appears after 10seconds. 

REST URLs:

- http://localhost:8080/add
- http://localhost:8080/count
- http://localhost:8080/dyladd	


SQL:
- drop table CONTACTS
- SELECT * FROM CONTACTS  

JPA:
- @Entity(name="CONTACTS") - CONTACTS table to store name/age, by default H2 table will be Customer if no Entity name is empty
-  @Column(name= "firstName") - 'Full_Name' column is created instead of 'name'


Version Issue :

From version 1.5.10.RELEASE to 2.1.5.RELEASE, methods findOne & delete is changed to  findById & deleteById. Below is the new CrudRepository interface


~~~
interface CrudRepository<T, ID> extends Repository<T, ID> {

    S save(S entity);

    Iterable<S> saveAll(Iterable<S> entities)

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAllById(Iterable<ID> ids);

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);
}
~~~

Reference :
- https://spring.io/blog/2017/06/20/a-preview-on-spring-data-kay#improved-naming-for-crud-repository-methods

- https://stackoverflow.com/questions/51027002/the-method-findoneexamples-in-the-type-querybyexampleexecutorcontact-is-no

- https://www.concretepage.com/spring/example_enableasync_spring  :: @EnableAsync/@Async
