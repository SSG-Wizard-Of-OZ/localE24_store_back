package org.oz.locale24_store_back.event.repository;

import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.event.domain.EventStatus;
import org.oz.locale24_store_back.event.dto.EventReadDTO;
import org.oz.locale24_store_back.event.repository.search.EventEntitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventEntityRepository extends JpaRepository<EventEntity, Long>, EventEntitySearch {


    @Query("""
        SELECT 
            new org.oz.locale24_store_back.event.dto.EventReadDTO(e) 
        from EventEntity e
        where e.eno = :eno
""")
    Optional<EventReadDTO> getEvent( @Param("eno") Long eno);

    @Modifying
    @Query("update EventEntity e set e.status = :status where e.eno = :eno")
    int updateStatus(@Param("eno") Long eno, @Param("status") EventStatus status);
}
