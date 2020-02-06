package cn.bsnmdpf.fcprt.vipcenter5040;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.vipcenter5040.mapper")
@EnableTransactionManagement
public class Vipcenter5040Application {

    public static void main(String[] args) {
        SpringApplication.run(Vipcenter5040Application.class, args);
    }

}
