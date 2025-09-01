# springboot_with_Docker

# for refresences link
 - [chatgpt.com] (https://chatgpt.com/c/680b9d11-3768-8005-bfc3-b2231e5e6ce4)
 - [chatgpt.com] (https://chatgpt.com/c/68b3e0ca-2964-8321-b7fc-029d40456a93)

 # take berfore runing project with docker
   - project has Dockerfile or Docker-compose.yml file
   - project must be build before creating img
   - docker dashboard(look into).

# project learning
  - Docker build process go that path where your project is located or in sts go terminal 
       ex. C:\Users\Vishal\Documents\workspace-spring-tool-suite-4-4.27.0.RELEASE\ProjectWithDocker>
  - heat this command
        docker build -t  project1docer .
        docker run -d -p 8080:8080  project1docer 
        docker ps  or ps -a //runing and not running.
        docker start /stop 
  -after doctor and patient service in hostpital services 
       run this
           - docker-compose up --build
 * while working with external resources with docker into accessiable within docker container only(take reference of mysql connection).*

# Extra
-Swagger UI will be available at 👉 http://localhost:8080/swagger-ui.html
-OpenAPI docs 👉 http://localhost:8080/v3/api-docs

