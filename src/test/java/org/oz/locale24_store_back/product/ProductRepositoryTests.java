package org.oz.locale24_store_back.product;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.event.domain.EventEntity;
import org.oz.locale24_store_back.product.domain.ProductEntity;
import org.oz.locale24_store_back.product.dto.ProductStockListDTO;
import org.oz.locale24_store_back.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void insertEventProduct() {

        Long eventNo = 311L;

        EventEntity eventEntity = EventEntity.builder().eno(eventNo).build();

        for (int i = 0; i < 3; i++) {

            Long pcode = (long)(Math.random()* 100) + 1; // 1 - 100


            ProductEntity eventProduct =
                    ProductEntity.builder()
                            .event(eventEntity)
                            .pcode(pcode)
                            .pname("테스트상품"+ pcode)
                            .price(3000)
                            .pdesc("Description....")
                            .build();

            eventProduct.addFile(UUID.randomUUID()+"test.jpg");
            eventProduct.addFile(UUID.randomUUID()+"test.jpg");

            productRepository.save(eventProduct);
        }
    }


    @Test
    public void testOfEvent() {

        Long eventNo = 300L;

        List<ProductEntity> productEntityList = productRepository.getListOfEvent(eventNo);

        productEntityList.forEach(productEntity -> {
            log.info(productEntity.toString());
            log.info(productEntity.getAttachFiles());
        });
    }

    @Transactional
    @Commit
    @Test
    public void testUpdateQuantity() {

        Long pno = 10L;

        productRepository.updateQuantity(pno, 100);

    }

    @Test
    public void testListOfAllProducts() {
        Long storeNo = 3L;

        PageRequestDTO requestDTO = new PageRequestDTO(1, 10);
        PageResponseDTO<ProductStockListDTO> productEntityList = productRepository.listAll(requestDTO,storeNo);

        log.info(productEntityList.toString());
    }
}
