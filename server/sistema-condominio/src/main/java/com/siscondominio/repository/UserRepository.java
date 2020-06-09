package com.siscondominio.repository;

import java.util.List;

import com.siscondominio.model.Usuarios;

import org.springframework.data.repository.CrudRepository;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends CrudRepository<Usuarios, Long> {
        
     List<Usuarios> findByNameIgnoreCaseContaining(String email);
    //Usuarios findById(Integer id);
}
