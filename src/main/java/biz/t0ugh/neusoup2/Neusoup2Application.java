package biz.t0ugh.neusoup2;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"biz.t0ugh.neusoup2.mapper"}, annotationClass = Mapper.class)
public class Neusoup2Application {

    public static void main(String[] args) {
        SpringApplication.run(Neusoup2Application.class, args);
    }

}
