package org.oz.locale24_store_back.refund.domain;

import jakarta.persistence.*;
import lombok.*;
import org.oz.locale24_store_back.common.domain.BasicEntity;
import org.oz.locale24_store_back.common.domain.BasicStatus;
import org.oz.locale24_store_back.product.domain.ProductEntity;

@Entity
@Table(name = "tbl_refund")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = {"product"})
public class RefundEntity extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rfno;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Builder.Default
    private RefundStatus status = RefundStatus.PENDING;

    private String rfdesc;
}
