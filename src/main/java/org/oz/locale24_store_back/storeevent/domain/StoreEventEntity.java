package org.oz.locale24_store_back.storeevent.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.store.domain.StoreEntity;

@Entity
@Table(name = "store_event")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreEventEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_event_no", nullable = false)
    private Long storeEventNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_no", referencedColumnName = "event_no")
    private EventEntity eventNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_no", referencedColumnName = "store_no")
    private StoreEntity storeNo;

    @Column(name = "event_matching_status")
    @Builder.Default
    private StoreEventStatus eventMatchingStatus = StoreEventStatus.PENDING;

}
