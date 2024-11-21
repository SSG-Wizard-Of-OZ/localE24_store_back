package org.oz.locale24_store_back.event.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.event.domain.EventStatus;
import org.oz.locale24_store_back.event.domain.QEventEntity;
import org.oz.locale24_store_back.event.dto.EventListDTO;
import org.oz.locale24_store_back.event.dto.EventListRequestDTO;
import org.oz.locale24_store_back.store.domain.QStoreEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;


@Log4j2
public class EventEntitySearchImpl extends QuerydslRepositorySupport implements  EventEntitySearch {

    public EventEntitySearchImpl() {
        super(EventEntity.class);
    }


    @Override
    public PageResponseDTO<EventListDTO> list(EventListRequestDTO pageRequestDTO, Long sno) {

        QEventEntity eventEntity = QEventEntity.eventEntity;
        QStoreEntity storeEntity = QStoreEntity.storeEntity;

        JPQLQuery<EventEntity> query = from(eventEntity);
        query.leftJoin(storeEntity).on(eventEntity.store.eq(storeEntity));
        query.where(storeEntity.storeNo.eq(sno));

        if(pageRequestDTO.getStatus() != null){
            eventEntity.status.eq(pageRequestDTO.getStatus());
        }

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("eno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<EventListDTO> dtoQuery = query.select(Projections.bean(
                EventListDTO.class,
                eventEntity.eno,
                eventEntity.ename,
                eventEntity.startDate,
                eventEntity.endDate,
                eventEntity.useSpace,
                eventEntity.status));

        List<EventListDTO> dtoList = dtoQuery.fetch();

        long totalCount = dtoQuery.fetchCount();

        return PageResponseDTO.<EventListDTO>withAll()
                .dtoList(dtoList)
                .totalCount(totalCount)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }
}
