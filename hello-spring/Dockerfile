FROM azul/zulu-openjdk:17

WORKDIR /app

COPY gradle gradle
COPY gradlew build.gradle settings.gradle ./
COPY src ./src

RUN chmod u+x ./gradlew

RUN ./gradlew build -x test

CMD ["./gradlew", "bootRun"]
