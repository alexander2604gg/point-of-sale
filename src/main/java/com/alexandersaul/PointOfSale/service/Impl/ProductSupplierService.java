package com.alexandersaul.PointOfSale.service.Impl;

import com.alexandersaul.PointOfSale.dto.ProductDTO;
import com.alexandersaul.PointOfSale.dto.ProductSupplierDTO;
import com.alexandersaul.PointOfSale.dto.SupplierWithProductsDTO;
import com.alexandersaul.PointOfSale.entities.Product;
import com.alexandersaul.PointOfSale.entities.ProductSupplier;
import com.alexandersaul.PointOfSale.entities.ProductSupplierId;
import com.alexandersaul.PointOfSale.entities.Supplier;
import com.alexandersaul.PointOfSale.mapper.ProductMapper;
import com.alexandersaul.PointOfSale.mapper.ProductSupplierMapper;
import com.alexandersaul.PointOfSale.repository.ProductRepository;
import com.alexandersaul.PointOfSale.repository.ProductSupplierRepository;
import com.alexandersaul.PointOfSale.repository.SupplierRepository;
import com.alexandersaul.PointOfSale.service.IProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSupplierService implements IProductSupplierService {

    @Autowired
    private ProductSupplierRepository productSupplierRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductSupplierMapper productSupplierMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductSupplierDTO assignProductToSupplier(ProductSupplierDTO productSupplierDTO) {

        Optional<Product> productOptional = productRepository.findById(productSupplierDTO.getProductId());
        Optional<Supplier> supplierOptional = supplierRepository.findById(productSupplierDTO.getSupplierId());

        if(productOptional.isPresent() & supplierOptional.isPresent() & productSupplierDTO.getPrice().compareTo(BigDecimal.ZERO) > 0){
            Product product = productOptional.get();
            Supplier supplier = supplierOptional.get();
            ProductSupplierId productSupplierId = new ProductSupplierId(product.getId(), supplier.getId());
            ProductSupplier productSupplier = ProductSupplier.builder().id(productSupplierId)
                    .product(productOptional.get())
                    .supplier(supplierOptional.get())
                    .supplyPrice(productSupplierDTO.getPrice())
                    .build();
            ProductSupplier savedProductSupplier = productSupplierRepository.save(productSupplier);
            return productSupplierMapper.toDTO(savedProductSupplier);
        }
        return null;
    }

    @Override
    public List<SupplierWithProductsDTO> getSupplierWithProducts() {

        List<ProductSupplier> productSupplierList = (List<ProductSupplier>) productSupplierRepository.findAll();
        List<SupplierWithProductsDTO> supplierWithProductsDTOList = new ArrayList<>();

        productSupplierList.forEach((i)->{
            SupplierWithProductsDTO supplierWithProductsDTO = new SupplierWithProductsDTO();
            List<ProductSupplier> supplierWithProducts = productSupplierRepository.getBySupplierId(i.getId().getSupplierId());
            supplierWithProductsDTO.setSupplierName(i.getSupplier().getName());
            supplierWithProductsDTO.setPriceOfSupplier(i.getSupplyPrice());
            List<ProductDTO> productDTOList = new ArrayList<>();
            supplierWithProducts.forEach((sp)->{
                productDTOList.add(productMapper.productToProductDTO(sp.getProduct()));
            });
            supplierWithProductsDTO.setProductList(productDTOList);
            supplierWithProductsDTOList.add(supplierWithProductsDTO);
        });

        return supplierWithProductsDTOList;
    }


}
