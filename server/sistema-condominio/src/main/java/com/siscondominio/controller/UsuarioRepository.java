package com.siscondominio.controller;

import java.util.List;

import com.siscondominio.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByid(Integer id);
}
