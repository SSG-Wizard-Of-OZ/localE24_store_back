package org.oz.locale24_store_back.refund.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.locale24_store_back.refund.dto.RefundListDTO;
import org.oz.locale24_store_back.refund.service.RefundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/store/event/product/refund")
public class RefundController {
    private final RefundService refundService;

    @GetMapping("{pno}")
    public ResponseEntity<List<RefundListDTO>> getProductRefund(@PathVariable Long pno){
        return ResponseEntity.ok().body(refundService.getRefundByProduct(pno));
    }
}
