package io.fullstacklabs.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeController {

    @Value("${application.name:info-service}")
    private String serviceName;

    @GetMapping("/service")
    public String getServiceName() {
        return "Service name { " + this.serviceName + " } ";
    }
}
