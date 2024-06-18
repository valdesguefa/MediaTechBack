package com.fstg.demo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDTO {

    private Integer id;
    private String nom;
    private String telephone;
    private String prenom;
    
}
