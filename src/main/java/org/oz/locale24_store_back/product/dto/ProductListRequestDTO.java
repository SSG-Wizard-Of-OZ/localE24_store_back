package org.oz.locale24_store_back.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.oz.locale24_store_back.common.dto.PageRequestDTO;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class ProductListRequestDTO extends PageRequestDTO {
    String pkeyword,ekeyword;
}
