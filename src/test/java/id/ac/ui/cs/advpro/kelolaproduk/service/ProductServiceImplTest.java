package id.ac.ui.cs.advpro.kelolaproduk.service;

import id.ac.ui.cs.advpro.kelolaproduk.model.ProductModel;
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
        ProductModel productModel = new ProductModel();
        when(productRepository.save(productModel)).thenReturn(productModel);
        ProductModel savedProductModel = productService.addProduct(productModel);
        assertThat(savedProductModel).isNotNull();
    }

    @Test
    void testFindAllProduct() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(productService.findAllProduct()).isEmpty();
    }

    @Test
    void testFindById() {
        Optional<ProductModel> optionalProduct = Optional.of(new ProductModel());
        when(productRepository.findById(1L)).thenReturn(optionalProduct);
        assertThat(productService.findById(1L)).isNotEmpty();
    }

    @Test
    void testUpdateProduct() {
        ProductModel productModel = new ProductModel();
        when(productRepository.save(productModel)).thenReturn(productModel);
        assertThat(productService.updateProduct(productModel)).isEqualTo(productModel);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
