package org.oz.locale24_store_back.eventproduct.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.common.domain.AttachFile;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.event.domain.EventEntity;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "event_product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventProductEntity extends BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_product_no", nullable = false)
    private Long eventProductNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_no", referencedColumnName = "event_no")
    private EventEntity eventNo;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @ElementCollection
    @Builder.Default
    @CollectionTable(
            name = "event_product_file",
            joinColumns = @JoinColumn(name = "event_product_id")
    )
    private Set<AttachFile> attachFiles = new HashSet<>();

}
