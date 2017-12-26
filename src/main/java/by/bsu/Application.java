package by.bsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Mikhail on 06.12.2017.
 */

@SpringBootApplication(scanBasePackages={
        "by.bsu"})
@ImportResource({"classpath:dispatcher-servlet.xml","classpath:spring-config.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
