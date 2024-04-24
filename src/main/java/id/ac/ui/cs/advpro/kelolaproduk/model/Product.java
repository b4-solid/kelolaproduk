package id.ac.ui.cs.advpro.kelolaproduk.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private BigDecimal discountPrice;
    private Boolean isDiscounted;

    public void applyDiscount(BigDecimal discountRate) {
        if (discountRate.compareTo(BigDecimal.ZERO) > 0 && discountRate.compareTo(BigDecimal.ONE) < 0) {
            this.isDiscounted = true;
            this.discountPrice = this.price.multiply(BigDecimal.ONE.subtract(discountRate));
        } else {
            throw new IllegalArgumentException("Invalid discount rate. Must be > 0 and < 1.");
        }
    }
}
