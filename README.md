<img src="https://wakatime.com/badge/user/7468211e-4fb5-451d-95a8-2d5d4f898776/project/3478e0ab-5e08-4854-b4eb-bd04e8ccb451.svg" />
<img src="https://raw.githubusercontent.com/vedantchimote/Curiositees/main/curiositees-resources/curiositees-logo/CuriositeesTransGif-Crop.gif" />

<h4>
Curiositees is an e-commerce project developed using Spring Boot and ReactJS. It is an e-commerce application that allows users to browse and purchase fashion products online.
</h4>

The project utilizes the latest version of Spring Boot and incorporates Spring Data JPA and Hibernate for handling the complexity of data persistence operations. The persistence side of the application is managed using MySQL database.

### Deployment:

* #### DockerHub

  * ##### [CuriositeesFrontend](https://hub.docker.com/repository/docker/vedantchimote/curiositees-frontend/general)
  
  `docker pull vedantchimote/curiositees-backend:1.0 `
  
    * ##### [CuriositeesBackend](https://hub.docker.com/repository/docker/vedantchimote/curiositees-backend/general)

  `docker pull vedantchimote/curiositees-backend:1.0`

* #### Azure
    
    * ##### [CuriositeesAdmin](http://172.174.208.204:8090/CuriositeesAdmin/login)

    * ##### [CuriositeesUser](http://172.174.208.204:8090/CuriositeesAdmin/login)

### The backend project structure is as follows:

```
CuriositeesProject (root project) (pom)
      -- CuriositeesCommon -module 1 (jar) -Shared library between backend & frontend 
      -- CuriositeesWebParent -module 2 (pom) -- Common dependencies between backend & frontend 
             -- CuriositeesBackEnd -module 2a (jar) 
             -- CuriositeesFrontEnd -module 2b (jar)
```

<h3 align="center">
The project is causing stress 😓, oh wait we mean progress 🚀
</h3>

<h3 align="center">
The blood, sweat, and tears 😅💪🏽💦 that has been put into this project up until now
</h3>
<br>

### Class-Diagrams:

* #### CuriositeesCommon Module

<img src="https://raw.githubusercontent.com/vedantchimote/Curiositees/main/curiositees-diagrams/class-diagrams/v2/CuriositeesCommon/CuriositeesCommon.png" />

* #### CuriositeesFrontend Module

<img src="https://raw.githubusercontent.com/vedantchimote/Curiositees/main/curiositees-diagrams/class-diagrams/v2/CuriositeesFrontend/CuriositeesFrontend.png" />

* #### CuriositeesBackend Module

<img src="https://raw.githubusercontent.com/vedantchimote/Curiositees/main/curiositees-diagrams/class-diagrams/v2/CuriositeesBackend/CuriositeesBackend.png" />
