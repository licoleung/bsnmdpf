package cn.bsnmdpf.fcprt.paycenter5070;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.paycenter5070.mapper")
@EnableTransactionManagement
public class Paycenter5070Application {

    public static void main(String[] args) {
        SpringApplication.run(Paycenter5070Application.class, args);
    }

}
