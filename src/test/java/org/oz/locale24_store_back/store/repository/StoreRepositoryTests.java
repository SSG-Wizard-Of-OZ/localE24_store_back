package org.oz.locale24_store_back.store.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.oz.locale24_store_back.store.domain.StoreEntity;
import org.oz.locale24_store_back.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired(required = false)
    private StoreRepository storeRepository;

//    @Disabled
    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {

            StoreEntity store = StoreEntity.builder()
                    .name("Store "+i)
                    .addr("Address "+i)
                    .lat(37.123333)
                    .lng(127.13343434)
                    .build();

            storeRepository.save(store);
        }
    }

}
