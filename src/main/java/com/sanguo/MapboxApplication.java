package com.sanguo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sanguo.mapper")
public class MapboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapboxApplication.class, args);
    }
}
