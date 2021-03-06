package com.evan.distributedlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author evan
 * @date 2022-03-19
 */
@EnableScheduling
@MapperScan("com.evan.distributedlock.dao")
@SpringBootApplication
public class DistributedLockApplication {
    public static void main(String[] args) {

        SpringApplication.run(DistributedLockApplication.class, args);

    }
}
