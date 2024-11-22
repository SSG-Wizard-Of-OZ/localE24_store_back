package org.oz.locale24_store_back.product.repository;

import org.oz.locale24_store_back.product.domain.ProductEntity;
import org.oz.locale24_store_back.product.repository.search.ProductEntitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductEntitySearch {



    @Query("""
    select p from ProductEntity p left join EventEntity ev on p.event = ev join fetch p.attachFiles
    where ev.eno = :eno
    """)
    List<ProductEntity> getListOfEvent(@Param("eno") Long eno);

    @Modifying
    @Query("update ProductEntity  ep set ep.quantity = :quantity where ep.pno = :pno ")
    void updateQuantity(@Param("pno") Long pno, @Param("quantity") int quantity);
}



