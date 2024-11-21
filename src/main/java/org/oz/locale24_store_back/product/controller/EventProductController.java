package org.oz.locale24_store_back.product.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.product.dto.EventProductListDTO;
import org.oz.locale24_store_back.product.service.EventProductService;
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
public class EventProductController {

    private final EventProductService eventProductService;

    @GetMapping("{eno}")
    public ResponseEntity<List<EventProductListDTO>> getEventProduct(@PathVariable("eno") Long eno) {

        return ResponseEntity.ok().body(eventProductService.getByEvent(eno));
    }
}
