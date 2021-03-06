package cn.bsnmdpf.fcprt.ordercenter5020;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.ordercenter5020.mapper")
@EnableTransactionManagement
public class Ordercenter5020Application {

    public static void main(String[] args) {
        SpringApplication.run(Ordercenter5020Application.class, args);
    }

}
