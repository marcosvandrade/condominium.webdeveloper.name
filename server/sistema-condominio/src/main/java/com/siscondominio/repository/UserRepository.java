package com.siscondominio.repository;

import java.util.Optional;

import com.siscondominio.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends JpaRepository<Usuarios, Integer> {

    @Transactional(readOnly = true)
    Usuarios findByEmail(String email);

    Optional<Usuarios> findById(Integer id);
}
