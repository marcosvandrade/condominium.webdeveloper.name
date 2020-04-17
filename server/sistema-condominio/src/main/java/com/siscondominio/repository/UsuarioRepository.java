package com.siscondominio.repository;

import java.util.List;

import com.siscondominio.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    List<Usuarios> findByid(Integer id);
    //Usuarios findById(Integer id);
}
