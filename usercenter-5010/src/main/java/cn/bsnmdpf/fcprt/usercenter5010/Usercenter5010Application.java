package cn.bsnmdpf.fcprt.usercenter5010;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.usercenter5010.mapper")
@EnableTransactionManagement
public class Usercenter5010Application {

    public static void main(String[] args) {
        SpringApplication.run(Usercenter5010Application.class, args);
    }

}
