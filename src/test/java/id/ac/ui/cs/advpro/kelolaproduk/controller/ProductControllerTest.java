package id.ac.ui.cs.advpro.kelolaproduk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advpro.kelolaproduk.model.Product;
import id.ac.ui.cs.advpro.kelolaproduk.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ObjectMapper objectMapper;
    private Product product;
    private UUID productId;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
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
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenPostProduct_thenProductIsAdded() throws Exception {
        when(productService.addProduct(any(Product.class))).thenReturn(product);
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(product.getId().toString()));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenGetProductById_thenReturnProduct() throws Exception {
        when(productService.getProductById(productId)).thenReturn(product);
        mockMvc.perform(get("/api/products/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(productId.toString()));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenUpdateProduct_thenProductIsUpdated() throws Exception {
        when(productService.updateProduct(any(Product.class))).thenReturn(product);
        mockMvc.perform(put("/api/products/{id}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(productId.toString()));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenDeleteProduct_thenProductIsDeleted() throws Exception {
        doNothing().when(productService).deleteProduct(productId);
        mockMvc.perform(delete("/api/products/{id}", productId))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenApplyDiscount_thenDiscountIsApplied() throws Exception {
        doNothing().when(productService).applyDiscount(any(UUID.class), any(BigDecimal.class));
        mockMvc.perform(patch("/api/products/{id}/discount", productId)
                        .param("discountRate", "0.1"))
                .andExpect(status().isOk());
    }
}
