package org.oz.locale24_store_back.event.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.common.domain.BasicStatus;

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
    private Long eventNo;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_maker")
    private String eventMaker;

    @Column(name = "event_start")
    private Date eventStart;

    @Column(name = "event_end")
    private Date eventEnd;

    @Column(name = "event_space_rent")
    private String eventSpaceRent;

    @Enumerated(EnumType.ORDINAL)
    @Builder.Default
    @Column(name = "event_status", columnDefinition = "INT DEFAULT 0")
    private BasicStatus eventStatus = BasicStatus.PENDING;
}
