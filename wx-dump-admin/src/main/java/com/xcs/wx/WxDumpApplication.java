package com.xcs.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xcs
 * @date 2023年12月21日 17时02分
 **/
@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement
public class WxDumpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxDumpApplication.class, args);
    }
}
