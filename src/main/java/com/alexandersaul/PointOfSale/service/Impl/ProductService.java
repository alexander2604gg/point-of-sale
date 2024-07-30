package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.entities.Inventory;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.mapper.ProductMapper;
import com.alexandersaul.PointOfSale.repository.InventoryRepository;
import com.alexandersaul.PointOfSale.repository.ProductRepository;
import com.alexandersaul.PointOfSale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return productList.stream()
                .map(productMapper::productToProductDTO)
                .toList();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {

        Product product = productMapper.productDTOToProduct(productDTO);
        product = productRepository.save(product);

        Inventory newInventory = new Inventory();
        newInventory.setId(product.getInventory().getId());
        newInventory.setProduct(product);
        newInventory.setStock(productDTO.getStock());
        newInventory.setLastUpdated(LocalDateTime.now());
        newInventory = inventoryRepository.save(newInventory);

        product.setInventory(newInventory);
        product = productRepository.save(product);
        return productMapper.productToProductDTO(product);

    }

    @Override
    public ProductDTO update(ProductDTO updatedProductDTO , long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return null;
        }

        Product product = productOptional.get();
        product.setName(updatedProductDTO.getName());
        product.setPrice(updatedProductDTO.getPrice());
        product.setCategory(updatedProductDTO.getCategory());

        Inventory inventory = product.getInventory();
        if (inventory != null) {
            inventory.setStock(updatedProductDTO.getStock());
            inventory.setLastUpdated(LocalDateTime.now());
            inventoryRepository.save(inventory);
        } else {
            Inventory newInventory = new Inventory();
            newInventory.setProduct(product);
            newInventory.setStock(updatedProductDTO.getStock());
            newInventory.setLastUpdated(LocalDateTime.now());
            inventoryRepository.save(newInventory);
            product.setInventory(newInventory);
        }

        product = productRepository.save(product);

        return productMapper.productToProductDTO(product);
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
