package io.fullstacklabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //this annotation is not mandatory adding dependency to the classpath is enough to make it a eureka client
public class InfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoServiceApplication.class, args);
    }

}
