package com.Inmobiliaria.demo.cliente.repository;


import com.Inmobiliaria.demo.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    void deleteById(Long id);
}


