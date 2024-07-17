package com.alexandersaul.PointOfSale.service;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();
    ProductDTO save(ProductDTO product);
    ProductDTO update(ProductDTO product , long id);
    ProductDTO findById (long id);
    void delete(Long id);

}
