Curiositees is an e-commerce project developed using Spring Boot and ReactJS. It is an e-commerce application that allows users to browse and purchase fashion products online.

The project utilizes the latest version of Spring Boot and incorporates Spring Data JPA and Hibernate for handling the complexity of data persistence operations. The persistence side of the application is managed using MySQL database.

The backend project structure is as follows:

```
CuriositeesProject (root project) (pom)
      -- CuriositeesCommon -module 1 (jar) -Shared library between backend & frontend 
      -- CuriositeesWebParent -module 2 (pom) -- Common dependencies between backend & frontend 
             -- CuriositeesBackEnd -module 2a (jar) 
             -- CuriositeesFrontEnd -module 2b (jar)
  
```