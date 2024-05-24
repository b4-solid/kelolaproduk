package id.ac.ui.cs.advpro.kelolaproduk.controller;

import id.ac.ui.cs.advpro.kelolaproduk.model.ProductModel;
import id.ac.ui.cs.advpro.kelolaproduk.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ProductModel>> addProduct(@RequestBody ProductModel productModel) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(productService.addProduct(productModel)));
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<ProductModel>>> getAllProducts() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(productService.findAllProduct()));
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<ProductModel>> getProductById(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<ProductModel>> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel) {
        return CompletableFuture.supplyAsync(() -> {
            productModel.setId(id);
            return ResponseEntity.ok(productService.updateProduct(productModel));
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteProduct(@PathVariable Long id) {
        return CompletableFuture.runAsync(() -> productService.deleteProduct(id))
                .thenApply(e -> ResponseEntity.noContent().<Void>build());
    }
}
