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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

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

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenPostProduct_thenProductIsAdded() throws Exception {

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenGetProductById_thenReturnProduct() throws Exception {

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenUpdateProduct_thenProductIsUpdated() throws Exception {

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenDeleteProduct_thenProductIsDeleted() throws Exception {

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenApplyDiscount_thenDiscountIsApplied() throws Exception {

    }
}
