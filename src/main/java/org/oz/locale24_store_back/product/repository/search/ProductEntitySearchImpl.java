package org.oz.locale24_store_back.product.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.domain.QEventEntity;
import org.oz.locale24_store_back.product.domain.ProductEntity;
import org.oz.locale24_store_back.product.domain.QProductEntity;
import org.oz.locale24_store_back.product.dto.ProductListRequestDTO;
import org.oz.locale24_store_back.product.dto.ProductStockListDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class ProductEntitySearchImpl extends QuerydslRepositorySupport implements ProductEntitySearch {
    public ProductEntitySearchImpl() {
        super(ProductEntity.class);
    }

    @Override
    public PageResponseDTO<ProductStockListDTO> listAll(ProductListRequestDTO pageRequestDTO, Long sno) {
        QProductEntity productEntity = QProductEntity.productEntity;
        QEventEntity eventEntity = QEventEntity.eventEntity;

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("pno").descending());

        JPQLQuery<ProductEntity> query = from(productEntity);
        query.leftJoin(eventEntity).on(productEntity.event.eq(eventEntity));
        query.where(eventEntity.store.storeNo.eq(sno));
        query.where(eventEntity.delFlag.eq(false));

        log.info(pageRequestDTO);
        // 상품키워드 검색
        if (pageRequestDTO.getPkeyword() != null){
            String keyword = "%" + pageRequestDTO.getPkeyword() + "%";
            query.where(productEntity.pname.like(keyword));
        }
        // 이벤트키워드 검색
        if (pageRequestDTO.getEkeyword() != null){
            String keyword = "%" + pageRequestDTO.getEkeyword() + "%";
            query.where(eventEntity.ename.like(keyword));
        }

        this.getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<ProductStockListDTO> dtoQuery = query.select(Projections.bean(
                ProductStockListDTO.class,
                productEntity.pno,
                productEntity.pname,
                productEntity.quantity,
                eventEntity.ename));

        List<ProductStockListDTO> dtoList = dtoQuery.fetch();

        long total = dtoQuery.fetchCount();

        return PageResponseDTO.<ProductStockListDTO>withAll()
                .dtoList(dtoList)
                .totalCount(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }
}
