package id.ac.ui.cs.advpro.kelolaproduk.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    @Test
    void testGetUserID() {
        this.product= new Product();
        this.product.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        assertEquals(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"), this.product.getId());
    }

    @Test
    void testGetTitle() {
        this.product = new Product();
        this.product.setTitle("Youkoso Store");
        assertEquals("Youkoso Store", this.product.getTitle());
    }

    @Test
    void testGetDescription() {
        this.product = new Product();
        this.product.setDescription("Ini adalah sepatu naiki");
        assertEquals("Ini adalah sepatu naiki", this.product.getDescription());
    }

    @Test
    void testGetStock() {
        this.product = new Product();
        this.product.setStock(5);
        assertEquals(5, this.product.getStock());
    }

    @Test
    void testGetImageUrl() {
        this.product = new Product();
        this.product.setImageUrl("https://blog.rosihanari.net/wp-content/uploads/2022/01/dummy02.png");
        assertEquals("https://blog.rosihanari.net/wp-content/uploads/2022/01/dummy02.png", this.product.getImageUrl());
    }
}