package com.siscondominio.repository;

import java.util.Optional;

import com.siscondominio.model.Articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
    @Transactional(readOnly = true)
    Articles findByTitle(String title);

    Optional<Articles> findById(Integer id);
}
