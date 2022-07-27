package cn.iverdon.vhrlixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "cn.iverdon.vhrlixi.mapper")
@EnableScheduling
public class VhrLixiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrLixiApplication.class, args);
    }

}
