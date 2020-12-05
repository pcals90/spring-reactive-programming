package com.springreactive.netfluxsample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootTest
@EnableReactiveMongoRepositories
class NetfluxSampleApplicationTests {

    @Test
    void contextLoads() {
    }

}
