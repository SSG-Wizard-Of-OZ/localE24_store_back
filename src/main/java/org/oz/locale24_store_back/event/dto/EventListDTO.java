package org.oz.locale24_store_back.event.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.oz.locale24_store_back.common.domain.BasicStatus;
import org.oz.locale24_store_back.event.domain.EventStatus;

import java.time.LocalDate;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class EventListDTO {

    private Long eno;

    private String ename;

    private LocalDate startDate, endDate;

    private boolean useSpace;

    private EventStatus status;



    public EventListDTO(Long eno, String ename, LocalDate startDate, LocalDate endDate, boolean useSpace, EventStatus status) {

        this.eno = eno;
        this.ename = ename;
        this.startDate = startDate;
        this.endDate = endDate;
        this.useSpace = useSpace;
        this.status = status;
    }
}
