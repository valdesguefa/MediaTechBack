package com.fstg.demo.service;

import com.fstg.demo.DTO.ClientRequestDTO;
import com.fstg.demo.DTO.ClientResponseDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ClientService {

    ClientResponseDTO save(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO findById(Integer id);

    ClientResponseDTO findByNom(String nom);

    ClientResponseDTO findByprenom(String prenom);

    void delete(Integer id) throws NotFoundException;

    ClientResponseDTO update(ClientRequestDTO clientRequestDTO, Integer id) throws NotFoundException;

    List<ClientResponseDTO> findAll();

}
