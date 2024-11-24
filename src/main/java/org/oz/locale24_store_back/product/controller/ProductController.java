package org.oz.locale24_store_back.product.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.product.dto.ProductListDTO;
import org.oz.locale24_store_back.product.dto.ProductListRequestDTO;
import org.oz.locale24_store_back.product.dto.ProductStockListDTO;
import org.oz.locale24_store_back.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/store/event/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("{eno}")
    public ResponseEntity<List<ProductListDTO>> getEventProduct(@PathVariable("eno") Long eno) {

        return ResponseEntity.ok().body(productService.getByEvent(eno));
    }

    @GetMapping("/stock")
    public ResponseEntity<PageResponseDTO<ProductStockListDTO>> getStockProduct(ProductListRequestDTO requestDTO, Long sno) {

        log.info("----------------------------------" + sno);

        return ResponseEntity.ok().body(productService.getProductListByStore(requestDTO, sno));
    }
}
