package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.mapper.ProductMapper;
import com.alexandersaul.PointOfSale.repository.ProductRepository;
import com.alexandersaul.PointOfSale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList.stream()
                .map(productMapper::productToProductDTO)
                .toList();
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO update(ProductDTO product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
