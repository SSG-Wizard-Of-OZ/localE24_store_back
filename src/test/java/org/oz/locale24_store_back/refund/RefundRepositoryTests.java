package org.oz.locale24_store_back.refund;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oz.locale24_store_back.product.domain.ProductEntity;
import org.oz.locale24_store_back.refund.domain.RefundEntity;
import org.oz.locale24_store_back.refund.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class RefundRepositoryTests {
    @Autowired
    private RefundRepository refundRepository;

    @Test
    public void testInsert() {
        Long ProductNo = 18L;

        ProductEntity productEntity = ProductEntity.builder().pno(ProductNo).build();

        for (int i = 0; i < 30; i++) {
            RefundEntity refundEntity = RefundEntity.builder()
                    .product(productEntity)
                    .rfdesc("Refund Desc....")
                    .build();

            refundRepository.save(refundEntity);
        }
    }

    @Test
    public void testList() {
        Long ProductNo = 12L;

        List<RefundEntity> refundEntities = refundRepository.getListOfProduct(ProductNo);

        refundEntities.forEach(refundEntity -> {
            log.info(refundEntity.toString());
        });
    }
}
