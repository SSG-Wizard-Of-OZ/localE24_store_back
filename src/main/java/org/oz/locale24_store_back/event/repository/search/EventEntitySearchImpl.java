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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Log4j2
public class EventEntitySearchImpl extends QuerydslRepositorySupport implements  EventEntitySearch {

    public EventEntitySearchImpl() {
        super(EventEntity.class);
    }


    @Override
    public PageResponseDTO<EventListDTO> list(EventListRequestDTO pageRequestDTO, Long sno) {

        QEventEntity eventEntity = QEventEntity.eventEntity;
        QStoreEntity storeEntity = QStoreEntity.storeEntity;

        log.info(pageRequestDTO);

        // pageRequestDTO를 통한 pageable생성
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("eno").descending());

        JPQLQuery<EventEntity> query = from(eventEntity);
        query.leftJoin(storeEntity).on(eventEntity.store.eq(storeEntity));
        query.where(storeEntity.storeNo.eq(sno));
        query.where(storeEntity.delFlag.eq(false));

        // 이벤트 상태 검색
        if(pageRequestDTO.getStatus() != null){
            query.where(eventEntity.status.eq(pageRequestDTO.getStatus()));
        }
        // 공간대여 검색
        if(pageRequestDTO.getUseSpace() != null){
            boolean chkUseSpace = pageRequestDTO.getUseSpace().equals("Y") ? true : false;
            log.info(chkUseSpace);
            query.where(eventEntity.useSpace.eq(chkUseSpace));
        }
        // 기간 검색
        if (pageRequestDTO.getStartDate() != null || pageRequestDTO.getEndDate() != null){
            query.where(eventEntity.startDate.between(pageRequestDTO.getStartDate(), pageRequestDTO.getEndDate()));
            query.where(eventEntity.endDate.between(pageRequestDTO.getStartDate(), pageRequestDTO.getEndDate()));
        }
        // 키워드 검색
        if (pageRequestDTO.getKeyword() != null){
            // 현재 이벤트이름만으로 검색처리 추후 카테고리등 변경가능
            String keyword = "%" + pageRequestDTO.getKeyword() + "%";
            query.where(eventEntity.ename.like(keyword));
        }

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
