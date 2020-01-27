package cn.bsnmdpf.fcprt.eurekaservice7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eurekaservice7001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaservice7001Application.class, args);
    }

}
