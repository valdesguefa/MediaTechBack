package com.fstg.demo.controller;

import com.fstg.demo.DTO.ClientRequestDTO;
import com.fstg.demo.DTO.ClientResponseDTO;
import com.fstg.demo.service.ClientService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDTO>> getClient() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDTO> save(@RequestBody() @Valid ClientRequestDTO clientRequestDTO){
        ClientResponseDTO clientResponseDTO  = clientService.save(clientRequestDTO);
        return new ResponseEntity<>(clientResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(@RequestBody() ClientRequestDTO clientRequestDTO, @PathVariable Integer id) throws NotFoundException {
        return clientService.update(clientRequestDTO, id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Integer id){
        return ResponseEntity.accepted().body(clientService.findById(id));
    }

    @GetMapping("/nom/{nom}")
    public ClientResponseDTO findByName(@Valid @PathVariable String nom){
        return clientService.findByNom((nom));
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) throws NotFoundException {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
