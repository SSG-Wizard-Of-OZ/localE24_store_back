package org.oz.locale24_store_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LocalE24StoreBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalE24StoreBackApplication.class, args);
    }

}
