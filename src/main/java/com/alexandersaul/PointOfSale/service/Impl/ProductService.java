package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.mapper.ProductMapper;
import com.alexandersaul.PointOfSale.repository.ProductRepository;
import com.alexandersaul.PointOfSale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

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
    public ProductDTO save(ProductDTO productDTO) {
        Product savedProduct = productRepository.save(productMapper.productDTOToProduct(productDTO));
        return productMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO update(ProductDTO updatedProductDTO , long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            product.setName(updatedProductDTO.getName());
            product.setPrice(updatedProductDTO.getPrice());
            product.setCategory(updatedProductDTO.getCategory());
            return  productMapper.productToProductDTO(product);
        } else {
            return null;
        }
    }

    @Override
    public ProductDTO findById(long id) {
        Optional<Product> productOptional =  productRepository.findById(id);
        return productOptional.map(product -> productMapper.productToProductDTO(product)).orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
