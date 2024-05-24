package id.ac.ui.cs.advpro.kelolaproduk.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "product")
public class ProductModel {

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

    @Column(name = "stok")
    @NotNull
    @Getter
    @Setter
    private Integer stok;

    @Column(name = "nama")
    @NotNull
    @Getter
    @Setter
    private String nama;

    @Column(name = "deskripsi")
    @Getter
    @Setter
    private String deskripsi;

    @Column(name = "imageLink")
    @Getter
    @Setter
    private String imageLink;

    public ProductModel() {
    }

    public ProductModel(long id, Integer harga, Integer stok, String nama, String deskripsi, String imageLink) {
        this.id = id;
        this.harga = harga;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.imageLink = imageLink;
    }
}
