package cn.iverdon.vhrlixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.iverdon.vhrlixi.mapper")
public class VhrLixiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrLixiApplication.class, args);
    }

}
