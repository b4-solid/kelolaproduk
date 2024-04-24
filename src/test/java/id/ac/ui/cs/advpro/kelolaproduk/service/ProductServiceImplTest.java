package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;
import id.ac.ui.cs.advpro.kelolaproduk.repository.ProductRepository;
import id.ac.ui.cs.advpro.kelolaproduk.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private UUID productId;

    @BeforeEach
    void setUp() {
        productId = UUID.randomUUID();
        product = new Product();
        product.setId(productId);
        product.setTitle("Gundam Model Kit");
        product.setDescription("A Gundam model kit for hobbyists.");
        product.setPrice(new BigDecimal("25.00"));
        product.setStock(100);
        product.setImageUrl("http://example.com/gundam.jpg");
    }

    @Test
    void whenAddProduct_thenProductIsAdded() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product savedProduct = productService.addProduct(product);
        assertEquals(productId, savedProduct.getId());
        verify(productRepository).save(product);
    }

    @Test
    void whenUpdateProduct_thenProductIsUpdated() {
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        product.setDescription("Updated description");
        Product updatedProduct = productService.updateProduct(product);
        assertEquals("Updated description", updatedProduct.getDescription());
        verify(productRepository).save(product);
    }

    @Test
    void whenDeleteProduct_thenRepositoryDeleteCalled() {
        doNothing().when(productRepository).deleteById(productId);
        productService.deleteProduct(productId);
        verify(productRepository).deleteById(productId);
    }

    @Test
    void whenApplyDiscount_thenDiscountIsApplied() {
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        doAnswer(invocation -> {
            Product p = invocation.getArgument(0);
            p.setPrice(p.getPrice().multiply(BigDecimal.valueOf(0.9)));
            return null;
        }).when(productRepository).save(any(Product.class));
        productService.applyDiscount(productId, BigDecimal.valueOf(0.1)); // 10% discount
        assertEquals(0, product.getPrice().compareTo(BigDecimal.valueOf(22.50)));
    }

    @Test
    void whenGetProductById_thenReturnProduct() {
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        Product foundProduct = productService.getProductById(productId);
        assertEquals(productId, foundProduct.getId());
        verify(productRepository).findById(productId);
    }
}

