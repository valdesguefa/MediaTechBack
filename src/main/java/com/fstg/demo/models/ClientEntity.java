package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Table(name = "Clients")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "numero_telephone")
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "client_id")
    private List<FactureEntity> factures;
}
