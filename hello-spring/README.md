## Project
**JDK**: azul/zulu-openjdk:17  
**DB**: H2 Database

## Docker
Database Run 
```shell
docker compose up -d h2db 
```
SpringBoot Run
```shell
docker compose build spring
docker compose up -d spring
```

### IntelliJ Setting

**Build, Execution, Deployment > Build Tool > Gradle > run tests using: Intellij**
**Run/Debug Configuration > Junit > Run on: docker-compose service name**
