package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.ProductModel;

import java.util.Optional;
import java.util.List;

public interface ProductService {
    List<ProductModel> findAllProduct();
    Optional<ProductModel> findById(Long id);
    ProductModel addProduct(ProductModel productModel);
    ProductModel updateProduct(ProductModel productModel);
    void deleteProduct(Long id);
}
