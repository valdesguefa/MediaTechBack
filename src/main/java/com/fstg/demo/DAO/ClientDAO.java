package com.fstg.demo.DAO;

import com.fstg.demo.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {

   // ClientEntity findById(Integer id);
    ClientEntity findByNom(String name);
}
