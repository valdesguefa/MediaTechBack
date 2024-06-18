package com.fstg.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProduitFactureKey implements Serializable {

    @Column(name = "facture_id")
    private Integer factureId;

    @Column(name = "produit_id")
    private Integer produitId;
}
