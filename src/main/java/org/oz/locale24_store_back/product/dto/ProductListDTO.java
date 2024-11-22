package org.oz.locale24_store_back.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.oz.locale24_store_back.product.domain.ProductEntity;

import java.util.List;

@NoArgsConstructor
@Data
public class ProductListDTO {

    private Long pno;
    private String pname;
    private String pdesc;
    private int price;

    private List<String> fileNames;

    public ProductListDTO(ProductEntity entity){

        this.pno = entity.getPno();
        this.pname = entity.getPname();
        this.pdesc = entity.getPdesc();
        this.price = entity.getPrice();

        List<String> fileNames = entity.getAttachFiles().stream().map(attachFile -> attachFile.getFileName()).toList();

        this.fileNames = fileNames;
    }

}
