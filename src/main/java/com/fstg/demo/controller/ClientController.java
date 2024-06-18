package com.fstg.demo.controller;

import com.fstg.demo.DTO.ClientRequestDTO;
import com.fstg.demo.DTO.ClientResponseDTO;
import com.fstg.demo.service.ClientService;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<ClientResponseDTO> getClient() {
        return clientService.findAll();
    }

    @PostMapping("")
    public ClientResponseDTO save(@RequestBody() ClientRequestDTO clientRequestDTO){
        return clientService.save(clientRequestDTO);
    }


    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(@RequestBody() ClientRequestDTO clientRequestDTO, @PathVariable Integer id) throws NotFoundException {
        return clientService.update(clientRequestDTO, id);
    }

    @GetMapping("/id/{id}")
    public ClientResponseDTO findById(@PathVariable Integer id){
        return clientService.findById(id);
    }

    @GetMapping("/nom/{nom}")
    public ClientResponseDTO findByName(@PathVariable String nom){
        return clientService.findByNom((nom));
    }

//    @DeleteMapping("/id/{id}")
//    public void deleteById(@PathVariable("id") Integer id){
//        return clientService.delete(id);
//    }


}
