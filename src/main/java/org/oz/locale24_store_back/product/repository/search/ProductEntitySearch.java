package org.oz.locale24_store_back.product.repository.search;

import org.oz.locale24_store_back.common.dto.PageRequestDTO;
import org.oz.locale24_store_back.common.dto.PageResponseDTO;
import org.oz.locale24_store_back.product.dto.ProductStockListDTO;

public interface ProductEntitySearch {

    PageResponseDTO<ProductStockListDTO> listAll(PageRequestDTO pageRequestDTO, Long sno);
}
