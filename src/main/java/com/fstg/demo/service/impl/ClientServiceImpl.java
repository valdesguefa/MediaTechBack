package com.fstg.demo.service.impl;

import com.fstg.demo.DAO.ClientDAO;
import com.fstg.demo.DTO.ClientRequestDTO;
import com.fstg.demo.DTO.ClientResponseDTO;
import com.fstg.demo.exception.EntityAlreadyExistException;
import com.fstg.demo.models.ClientEntity;
import com.fstg.demo.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service()
public class ClientServiceImpl implements ClientService {
    private ClientDAO  clientDAO;
    private ModelMapper modelMapper;


    public ClientServiceImpl(ClientDAO clientDAO, ModelMapper modelMapper) {
        this.clientDAO = clientDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {

        ClientEntity clientEntity = modelMapper.map(clientRequestDTO, ClientEntity.class);
        ClientEntity clientEntity1 = clientDAO.findByNom(clientEntity.getNom());
        if(clientEntity1 != null) {
            throw new EntityAlreadyExistException("This client Already exist :_(");
        }
        ClientEntity savedEntity = clientDAO.save(clientEntity);
        return modelMapper.map(savedEntity, ClientResponseDTO.class);

    }

    @Override
    public ClientResponseDTO findById(Integer id) {
        ClientEntity clientEntity = clientDAO.findById(id).orElseThrow(()-> new EntityNotFoundException("Client Not Found"));
        return modelMapper.map(clientEntity, ClientResponseDTO.class);
    }

    @Override
    public ClientResponseDTO findByNom(String nom) {

        ClientEntity clientEntity = clientDAO.findByNom(nom);//.orElseThrow(()-> new RuntimeException("Client Not Found"));
        if (clientEntity == null) {
            throw new EntityNotFoundException("client not found");
           // return null;
        }
        else {
            return modelMapper.map(clientEntity, ClientResponseDTO.class);
        }

    }

    @Override
    public ClientResponseDTO findByprenom(String prenom) {
        return null;
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<ClientEntity> clientEntity = clientDAO.findById(id);

        if(clientEntity.isPresent()){
            clientDAO.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Client Not found");
        }

    }

    @Override
    public ClientResponseDTO update(ClientRequestDTO clientRequestDTO, Integer id) throws NotFoundException {

        Optional<ClientEntity> clientEntity = clientDAO.findById(id);
        if (clientEntity.isPresent()){
            ClientEntity clientEntity1 = modelMapper.map(clientRequestDTO, ClientEntity.class);
            clientEntity1.setId(id);
            ClientEntity client = this.clientDAO.save(clientEntity1);
            return modelMapper.map(client, ClientResponseDTO.class);
        } else {
            throw new EntityNotFoundException("Client Not found");
        }
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        return clientDAO.findAll().stream().map(elt->modelMapper.map(elt, ClientResponseDTO.class)).collect(Collectors.toList());
    }
}
