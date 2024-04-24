package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;
import id.ac.ui.cs.advpro.kelolaproduk.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

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

    }

    @Test
    void whenAddProduct_thenProductIsAdded() {

    }

    @Test
    void whenUpdateProduct_thenProductIsUpdated() {

    }

    @Test
    void whenDeleteProduct_thenRepositoryDeleteCalled() {

    }

    @Test
    void whenApplyDiscount_thenDiscountIsApplied() {

    }

    @Test
    void whenGetProductById_thenReturnProduct() {

    }
}

