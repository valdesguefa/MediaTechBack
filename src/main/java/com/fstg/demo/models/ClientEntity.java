package com.fstg.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
//import javax.validation.constraints.Size;


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


//    @Column(name = "nom")
    @Valid
    @Size(max = 30, message="le nom doit contenir moin de 15 lettres")
    @Size(min = 3, message="le nom doit contenir plus de 3 lettres")
    @NotBlank(message="vous devez entrer un nom valide")
    @NotNull(message = "The first name of client is required.")
    private String nom;


    @Valid
    @NotBlank(message="vous devez entrer un prenom valide")
    @NotNull(message = "The last name of client is required.")
//    @Column(name = "prenom")
    private String prenom;

//    @Column(name = "numero_telephone")
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "client_id")
    private List<FactureEntity> factures;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
