package org.oz.locale24_store_back.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.eventproduct.domain.EventProductEntity;
import org.oz.locale24_store_back.storeevent.domain.StoreEventEntity;

import java.util.Date;

@Entity
@Table(name = "store_event_product_order")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreEventProductOrderEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private Long orderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_event_no", referencedColumnName = "store_event_no")
    private StoreEventEntity storeEventNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_product_no", referencedColumnName = "event_product_no")
    private EventProductEntity eventProductNo;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @Column(name = "period_date")
    private Date periodDate;
}
