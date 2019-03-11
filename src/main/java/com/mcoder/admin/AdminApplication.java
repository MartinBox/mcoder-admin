package com.mcoder.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuheng
 * @Description: TODO
 * @date 2019/3/11 17:39
 */
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        new SpringApplication(AdminApplication.class).run(args);
    }
}
