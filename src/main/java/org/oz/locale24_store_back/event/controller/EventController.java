package org.oz.locale24_store_back.event.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.dto.EventListDTO;
import org.oz.locale24_store_back.event.dto.EventListRequestDTO;
import org.oz.locale24_store_back.event.dto.EventReadDTO;
import org.oz.locale24_store_back.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store/event")
@RequiredArgsConstructor
@Log4j2
public class EventController {

    private final EventService eventService;

    @GetMapping("/assigned")
    public PageResponseDTO<EventListDTO> list(EventListRequestDTO requestDTO, Long sno){

        log.info("----------------------------------");

        return eventService.getList(requestDTO,sno);

    }

    @GetMapping("/assigned/{eno}")
    public ResponseEntity<EventReadDTO> read(@PathVariable("eno") Long eno){


        log.info("============================" + eno);

        return ResponseEntity.ok().body(eventService.getRead(eno).get());

    }
}
