package org.oz.locale24_store_back.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.product.domain.ProductEntity;

@NoArgsConstructor
@Data
public class ProductStockListDTO {
    private Long pno;
    private String pname;
    private int quantity;

    private String ename;

    public ProductStockListDTO(ProductEntity entity, String ename) {
        this.pno = entity.getPno();
        this.pname = entity.getPname();
        this.quantity = entity.getQuantity();
        this.ename = ename;
    }
}
