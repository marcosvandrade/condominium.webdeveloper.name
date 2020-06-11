package com.siscondominio.repository;

import java.util.List;

import com.siscondominio.model.Usuarios;

import org.springframework.data.repository.CrudRepository;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends CrudRepository<Usuarios, Long> {
        
     List<Usuarios> findByNomeIgnoreCaseContaining(String nome);
    //Usuarios findById(Integer id);
}
