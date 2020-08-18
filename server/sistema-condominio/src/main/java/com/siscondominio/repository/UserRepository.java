package com.siscondominio.repository;

import java.util.List;

import com.siscondominio.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends JpaRepository<Usuarios, Long> {
        
    List<Usuarios> findByEmailIgnoreCaseContaining(String email);
//    Usuarios findById(Integer id);
}
