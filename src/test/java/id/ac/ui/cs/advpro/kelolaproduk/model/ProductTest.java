package id.ac.ui.cs.advpro.kelolaproduk.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @Test
    void testProductGettersAndSetters() {
        Product product = new Product();
        product.setId(1L);
        product.setHarga(100);
        product.setName("Test Product");
        product.setDeskripsi("Test Description");
        product.setImageLink("http://test.link");

        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getHarga()).isEqualTo(100);
        assertThat(product.getName()).isEqualTo("Test Product");
        assertThat(product.getDeskripsi()).isEqualTo("Test Description");
        assertThat(product.getImageLink()).isEqualTo("http://test.link");
    }

    @Test
    void testProductConstructor() {
        Product product = new Product(1L, 100, "Test Product", "Test Description", "http://test.link");
        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getHarga()).isEqualTo(100);
        assertThat(product.getName()).isEqualTo("Test Product");
        assertThat(product.getDeskripsi()).isEqualTo("Test Description");
        assertThat(product.getImageLink()).isEqualTo("http://test.link");
    }
}