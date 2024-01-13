package hello.querydslexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class QuerydslExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslExampleApplication.class, args);
    }

}
