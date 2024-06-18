package com.fstg.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ProduitFacture implements Serializable {
    @EmbeddedId
    ProduitFactureKey id;

    @ManyToOne
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    private FactureEntity facture;

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private ProduitEntity produit;

    private int quantite;
}
