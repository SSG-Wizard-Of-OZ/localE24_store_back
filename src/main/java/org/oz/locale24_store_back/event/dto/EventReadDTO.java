package org.oz.locale24_store_back.event.dto;

import lombok.Data;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.event.domain.EventStatus;

import java.time.LocalDate;

@Data
public class EventReadDTO {

    private Long eno;

    private String ename;

    private LocalDate startDate, endDate;

    private boolean useSpace;

    private EventStatus status;

    private String tags;

    public String[] getTagArr() {

        if(tags == null) return new String[0];

        return tags.split(",");

    }

    public EventReadDTO(EventEntity entity) {
        this.eno = entity.getEno();
        this.ename = entity.getEname();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.useSpace = entity.isUseSpace();
        this.status = entity.getStatus();
        this.tags = entity.getTags();
    }

}
