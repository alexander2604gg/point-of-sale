package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> getAll();
    ProductDTO save(ProductDTO product);
    ProductDTO update(ProductDTO product , long id);
    ProductDTO findById (long id);
    void delete(Long id);

}
