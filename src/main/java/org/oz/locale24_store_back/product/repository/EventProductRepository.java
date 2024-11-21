package org.oz.locale24_store_back.product.repository;

import org.oz.locale24_store_back.product.domain.EventProductEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventProductRepository extends JpaRepository<EventProductEntity, Long> {



    @Query("""
    select p from EventProductEntity p left join EventEntity ev on p.event = ev join fetch p.attachFiles
    where ev.eno = :eno
    
    """)
    java.util.List<EventProductEntity> getListOfEvent( @Param("eno") Long eno);

    @Modifying
    @Query("update EventProductEntity  ep set ep.quantity = :quantity where ep.pno = :pno ")
    void updateQuantity(@Param("pno") Long pno, @Param("quantity") int quantity);
}



