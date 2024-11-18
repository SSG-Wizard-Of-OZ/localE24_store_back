package org.oz.locale24_store_back.stock.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.eventproduct.domain.EventProductEntity;
import org.oz.locale24_store_back.storeevent.domain.StoreEventEntity;


@Entity
@Table(name = "store_event_product_stock")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreEventProductStockEntity extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_no")
    private Long stockNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_event_no", referencedColumnName = "store_event_no")
    private StoreEventEntity storeEventNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_product_no", referencedColumnName = "event_product_no")
    private EventProductEntity eventProductNo;

    @Column(name = "stock_current")
    private Integer stockCurrent;
}
