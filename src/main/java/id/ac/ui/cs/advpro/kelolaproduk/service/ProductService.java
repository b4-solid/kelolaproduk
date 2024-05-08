package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;

import java.util.Optional;
import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Optional<Product> findById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
