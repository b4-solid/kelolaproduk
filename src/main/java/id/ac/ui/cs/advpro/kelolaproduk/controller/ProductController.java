package id.ac.ui.cs.advpro.kelolaproduk.controller;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;
import id.ac.ui.cs.advpro.kelolaproduk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Product>> addProduct(@RequestBody Product product) {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(productService.addProduct(product)));
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<Product>>> getAllProducts() {
        return CompletableFuture.supplyAsync(() -> ResponseEntity.ok(productService.findAllProduct()));
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Product>> getProductById(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return CompletableFuture.supplyAsync(() -> {
            product.setId(id);
            return ResponseEntity.ok(productService.updateProduct(product));
        });
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Void>> deleteProduct(@PathVariable Long id) {
        return CompletableFuture.runAsync(() -> productService.deleteProduct(id))
                .thenApply(e -> ResponseEntity.noContent().<Void>build());
    }
}
