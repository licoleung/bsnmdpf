package cn.bsnmdpf.fcprt.goodcenter5030;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.goodcenter5030.mapper")
@EnableTransactionManagement
public class Goodcenter5030Application {

    public static void main(String[] args) {
        SpringApplication.run(Goodcenter5030Application.class, args);
    }

}
