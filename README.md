<img src="https://wakatime.com/badge/user/7468211e-4fb5-451d-95a8-2d5d4f898776/project/3478e0ab-5e08-4854-b4eb-bd04e8ccb451.svg" />

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
