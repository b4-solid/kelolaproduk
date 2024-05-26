package id.ac.ui.cs.advpro.kelolaproduk.service.impl;

import id.ac.ui.cs.advpro.kelolaproduk.model.ProductModel;
import id.ac.ui.cs.advpro.kelolaproduk.repository.ProductRepository;
import id.ac.ui.cs.advpro.kelolaproduk.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public List<ProductModel> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
