package org.oz.locale24_store_back.refund.repository;

import org.oz.locale24_store_back.refund.domain.RefundEntity;
import org.oz.locale24_store_back.refund.domain.RefundStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RefundRepository extends JpaRepository<RefundEntity,Long> {

    @Query("select r from RefundEntity r left join ProductEntity p on r.product = p where p.pno = :pno")
    List<RefundEntity> getListOfProduct(@Param("pno") Long pno);
}
