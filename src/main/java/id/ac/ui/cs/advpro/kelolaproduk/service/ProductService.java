package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductService {
    Product getProductById(UUID id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(UUID productId);
    void applyDiscount(UUID productId, BigDecimal discountRate);
}
