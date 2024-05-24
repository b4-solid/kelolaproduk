package id.ac.ui.cs.advpro.kelolaproduk.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductModelTest {

    @Test
    void testProductGettersAndSetters() {
        ProductModel productModel = new ProductModel();
        productModel.setId(1L);
        productModel.setHarga(100);
        productModel.setName("Test Product");
        productModel.setDeskripsi("Test Description");
        productModel.setImageLink("http://test.link");

        assertThat(productModel.getId()).isEqualTo(1L);
        assertThat(productModel.getHarga()).isEqualTo(100);
        assertThat(productModel.getName()).isEqualTo("Test Product");
        assertThat(productModel.getDeskripsi()).isEqualTo("Test Description");
        assertThat(productModel.getImageLink()).isEqualTo("http://test.link");
    }

    @Test
    void testProductConstructor() {
        ProductModel productModel = new ProductModel(1L, 100, "Test Product", "Test Description", "http://test.link");
        assertThat(productModel.getId()).isEqualTo(1L);
        assertThat(productModel.getHarga()).isEqualTo(100);
        assertThat(productModel.getName()).isEqualTo("Test Product");
        assertThat(productModel.getDeskripsi()).isEqualTo("Test Description");
        assertThat(productModel.getImageLink()).isEqualTo("http://test.link");
    }
}