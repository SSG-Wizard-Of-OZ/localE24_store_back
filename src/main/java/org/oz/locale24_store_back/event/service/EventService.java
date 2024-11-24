package org.oz.locale24_store_back.event.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.domain.EventStatus;
import org.oz.locale24_store_back.event.dto.EventListDTO;
import org.oz.locale24_store_back.event.dto.EventListRequestDTO;
import org.oz.locale24_store_back.event.dto.EventReadDTO;
import org.oz.locale24_store_back.event.dto.EventUpdateDTO;
import org.oz.locale24_store_back.event.repository.EventEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class EventService {

    private final EventEntityRepository eventEntityRepository;

    public PageResponseDTO<EventListDTO> getList(EventListRequestDTO requestDTO, Long sno){

        return eventEntityRepository.list(requestDTO, sno);
    }

    public Optional<EventReadDTO> getRead(Long eno){

        log.info("=======================EVENT NO " + eno);

        log.info("=======================EVEN " + eno);

        log.info(eventEntityRepository.getEvent(eno));

        return eventEntityRepository.getEvent(eno);
    }

    public int putStatus(EventUpdateDTO statusDTO){
        log.info("------------------------EVENT NO, STATUS NO" + statusDTO);

        Long eno = statusDTO.getEno();

        EventStatus status = EventStatus.PENDING;
        if (statusDTO.getStatus() == 1){
            status = EventStatus.APPROVED;
        }
        if (statusDTO.getStatus() == 2){
            status = EventStatus.REJECTED;
        }

        int result = eventEntityRepository.updateStatus(eno, status);
        log.info(result);
        return result;
    }
}
