package org.oz.locale24_store_back.event.repository.search;

import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.dto.EventListDTO;
import org.oz.locale24_store_back.event.dto.EventListRequestDTO;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface EventEntitySearch {

    PageResponseDTO<EventListDTO> list(EventListRequestDTO pageRequestDTO, Long sno);

}
