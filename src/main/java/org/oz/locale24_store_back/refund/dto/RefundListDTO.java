package org.oz.locale24_store_back.refund.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.refund.domain.RefundEntity;
import org.oz.locale24_store_back.refund.domain.RefundStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RefundListDTO {
    private Long rfno;
    private LocalDate regDate;
    private RefundStatus status;
    private String rfdesc;

    public RefundListDTO(RefundEntity entity) {
        this.rfno = entity.getRfno();
        this.regDate = entity.getRegDate().toLocalDate();
        this.status = entity.getStatus();
        this.rfdesc = entity.getRfdesc();
    }
}
