package cn.bsnmdpf.fcprt.stockcenter5050;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "cn.bsnmdpf.fcprt.stockcenter5050.mapper")
@EnableTransactionManagement
public class Stockcenter5050Application {

    public static void main(String[] args) {
        SpringApplication.run(Stockcenter5050Application.class, args);
    }

}
