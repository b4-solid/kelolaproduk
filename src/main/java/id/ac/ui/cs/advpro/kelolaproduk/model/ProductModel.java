package id.ac.ui.cs.advpro.kelolaproduk.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Getter
    @Setter
    private long id;

    @Column(name = "harga")
    @NotNull
    @Getter
    @Setter
    private Integer harga;

    @Column(name = "name")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "deskripsi")
    @Getter
    @Setter
    private String deskripsi;

    @Column(name = "imageLink")
    @Getter
    @Setter
    private String imageLink;

    public Product() {
    }

    public Product(long id, Integer harga, String name, String deskripsi, String imageLink) {
        this.id = id;
        this.harga = harga;
        this.name = name;
        this.deskripsi = deskripsi;
        this.imageLink = imageLink;
    }
}
