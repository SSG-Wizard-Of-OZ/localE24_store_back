package org.oz.locale24_store_back.product.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.product.domain.ProductEntity;
import org.oz.locale24_store_back.product.dto.ProductListDTO;
import org.oz.locale24_store_back.product.dto.ProductStockListDTO;
import org.oz.locale24_store_back.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductListDTO> getByEvent(Long eno){

        List<ProductEntity> productEntityList = productRepository.getListOfEvent(eno);

        log.info("----------------------------getByEvent-------------");
        log.info(productEntityList);

        return productEntityList.stream().map(productEntity -> new ProductListDTO(productEntity)).toList();
    }

    public PageResponseDTO<ProductStockListDTO> getProductsByStore(PageRequestDTO pageRequestDTO, Long sno){
        log.info("----------------------------getProductsByStore-------------");

        return productRepository.listAll(pageRequestDTO, sno);
    }

}
