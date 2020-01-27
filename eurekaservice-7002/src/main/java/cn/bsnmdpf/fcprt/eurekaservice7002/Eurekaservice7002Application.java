package cn.bsnmdpf.fcprt.eurekaservice7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaservice7002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaservice7002Application.class, args);
    }

}
