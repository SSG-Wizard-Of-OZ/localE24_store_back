package org.oz.locale24_store_back.product.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.product.domain.EventProductEntity;
import org.oz.locale24_store_back.product.dto.EventProductListDTO;
import org.oz.locale24_store_back.product.repository.EventProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2

public class EventProductService {

    private final EventProductRepository eventProductRepository;

    @Transactional(readOnly = true)
    public java.util.List<EventProductListDTO> getByEvent(Long eno){

        List<EventProductEntity> productEntityList = eventProductRepository.getListOfEvent(eno);

        log.info("----------------------------getByEvent-------------");
        log.info(productEntityList);

        return productEntityList.stream().map(productEntity -> new EventProductListDTO(productEntity)).toList();
    }

}
