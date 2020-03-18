package cn.bsnmdpf.fcprt.vipshop9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.bsnmdpf.fcprt"})
public class Vipshop9002Application {

    public static void main(String[] args) {
        SpringApplication.run(Vipshop9002Application.class, args);
    }

}
