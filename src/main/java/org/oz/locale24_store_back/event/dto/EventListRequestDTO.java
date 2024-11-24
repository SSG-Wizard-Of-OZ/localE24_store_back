package org.oz.locale24_store_back.event.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.event.domain.EventStatus;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class EventListRequestDTO extends PageRequestDTO {

    private EventStatus status;

    private java.time.LocalDate startDate, endDate;

    private String useSpace;

    private String keyword;
}
