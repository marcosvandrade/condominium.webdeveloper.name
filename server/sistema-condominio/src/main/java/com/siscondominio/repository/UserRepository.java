package com.siscondominio.repository;

import com.siscondominio.model.Usuarios;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * passar como parametro a entidade (tabela) e o tipo do id
 */
public interface UserRepository extends PagingAndSortingRepository<Usuarios, Long> {
    Usuarios findByUsername(String email);
    
    // List<Usuarios> findByid(Integer id);
    //Usuarios findById(Integer id);
}
