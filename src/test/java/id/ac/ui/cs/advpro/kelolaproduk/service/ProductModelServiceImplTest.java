package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.Product;
import id.ac.ui.cs.advpro.kelolaproduk.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testAddProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);
        Product savedProduct = productService.addProduct(product);
        assertThat(savedProduct).isNotNull();
    }

    @Test
    void testFindAllProduct() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(productService.findAllProduct()).isEmpty();
    }

    @Test
    void testFindById() {
        Optional<Product> optionalProduct = Optional.of(new Product());
        when(productRepository.findById(1L)).thenReturn(optionalProduct);
        assertThat(productService.findById(1L)).isNotEmpty();
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);
        assertThat(productService.updateProduct(product)).isEqualTo(product);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
