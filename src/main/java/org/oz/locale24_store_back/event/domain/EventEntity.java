package org.oz.locale24_store_back.event.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.common.domain.BasicStatus;
import org.oz.locale24_store_back.store.domain.StoreEntity;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_event")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventEntity extends BasicEntity {

    //지점에서 신청받은 이벤트 ( 매칭이 되지 않은 이벤트 )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_no", nullable = false)
    private Long eno;

    @Column(name = "event_name")
    private String ename;

    @Column(name = "event_maker")
    private String maker;

    @Column(name = "event_start")
    private LocalDate startDate;

    @Column(name = "event_end")
    private LocalDate endDate;

    @Column(name = "event_space_rent")
    private boolean useSpace;


    @ManyToOne(fetch = FetchType.LAZY)
    private StoreEntity store;

    private String tags;

    @Enumerated(EnumType.ORDINAL)
    @Builder.Default
    @Column(name = "event_status", columnDefinition = "INT DEFAULT 0")
    private EventStatus status = EventStatus.PENDING;



}
