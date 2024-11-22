package org.oz.locale24_store_back.event.repository;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.event.dto.EventListDTO;
import org.oz.locale24_store_back.event.dto.EventListRequestDTO;
import org.oz.locale24_store_back.store.domain.StoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class EventRepositoryTests {


    @Autowired
    private EventEntityRepository eventEntityRepository;

    @Test

    public void testMakeEvent() {

        for (long i = 1; i < 10; i++) {

            StoreEntity store = StoreEntity.builder().storeNo(5L).build();

            EventEntity entity
                    = EventEntity.builder()
                    .store(store)
                    .ename("TestEvent " + i )
                    .useSpace(true)
                    .startDate(LocalDate.of(2025,12,01))
                    .endDate(LocalDate.of(2025,12,31))
                    .build();

            eventEntityRepository.save(entity);

        }//end for

    }

    @Test
    public void testList() {

        Long sno = 2L;

        EventListRequestDTO requestDTO = EventListRequestDTO.builder()
                .page(1)
                .size(10)
                .build();


        PageResponseDTO<EventListDTO> response = eventEntityRepository.list(requestDTO, sno);

        response.getDtoList().forEach(eventListDTO -> log.info(eventListDTO));



    }


}
