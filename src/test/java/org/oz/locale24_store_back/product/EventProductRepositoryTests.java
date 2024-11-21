package org.oz.locale24_store_back.product;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.product.domain.EventProductEntity;
import org.oz.locale24_store_back.product.repository.EventProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class EventProductRepositoryTests {

    @Autowired
    private EventProductRepository eventProductRepository;

    @Test
    public void insertEventProduct() {

        Long eventNo = 11L;

        EventEntity eventEntity = EventEntity.builder().eno(eventNo).build();

        for (int i = 0; i < 3; i++) {

            Long pcode = (long)(Math.random()* 100) + 1; // 1 - 100


            EventProductEntity eventProduct =
                    EventProductEntity.builder()
                            .event(eventEntity)
                            .pcode(pcode)
                            .pname("테스트상품"+ pcode)
                            .price(3000)
                            .pdesc("Description....")
                            .build();

            eventProduct.addFile(UUID.randomUUID()+"test.jpg");
            eventProduct.addFile(UUID.randomUUID()+"test.jpg");

            eventProductRepository.save(eventProduct);
        }
    }


    @Test
    public void testOfEvent() {

        Long eventNo = 3L;

        List<EventProductEntity> productEntityList = eventProductRepository.getListOfEvent(eventNo);

        productEntityList.forEach(productEntity -> {
            log.info(productEntity.toString());
            log.info(productEntity.getAttachFiles());
        });
    }

    @Transactional
    @Commit
    @Test
    public void testUpdateQuantity() {

        Long pno = 5L;

        eventProductRepository.updateQuantity(pno, 100);

    }
}
