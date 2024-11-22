package org.oz.locale24_store_back.refund.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.refund.domain.RefundEntity;
import org.oz.locale24_store_back.refund.dto.RefundListDTO;
import org.oz.locale24_store_back.refund.repository.RefundRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class RefundService {
    private final RefundRepository refundRepository;

    public List<RefundListDTO> getRefundByProduct(Long pno){
        List<RefundEntity> refundList = refundRepository.getListOfProduct(pno);

        return refundList.stream().map(refundEntity -> new RefundListDTO(refundEntity)).toList();
    }
}
