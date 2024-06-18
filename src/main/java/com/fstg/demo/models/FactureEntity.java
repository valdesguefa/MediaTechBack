package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "factures")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FactureEntity implements Serializable {
    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "date_creation_facture")
    private Date date;

    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProduitFacture> quantite;
}
