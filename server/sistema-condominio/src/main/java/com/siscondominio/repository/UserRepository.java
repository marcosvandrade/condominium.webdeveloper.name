package com.siscondominio.repository;

import com.siscondominio.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends JpaRepository<Usuarios, Integer> {
    
    @Transactional(readOnly=true)
    Usuarios findByEmail(String email);
    
    // Usuarios deleteById(Long id);
    // List<Usuarios> findByEmailIgnoreCaseContaining(String email);
//    Usuarios findById(Integer id);
}
