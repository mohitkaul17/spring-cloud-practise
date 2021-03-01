package io.fullstacklabs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeController {

    @Value("${application.name:catalog-service}")
    private String serviceName;

    @Autowired
    private Environment environment;
//    @Value("${secretkey}")//just for the sake of running the program
//    private String secret;

    @GetMapping("/service")
    public String getServiceName() {

        return "Service name { " + this.serviceName + " } ";
    }

    @GetMapping("/secret")
    public String getSecret() {

        return environment.getProperty("secretkey");
    }
}
