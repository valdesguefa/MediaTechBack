package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "produits")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProduitEntity implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable=false)
    private String 	ref;


    @Column(nullable = false)
    private BigDecimal prix;


    @Column(nullable = false)
    private double quantite_stock;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProduitFacture> produitFactures;
}
