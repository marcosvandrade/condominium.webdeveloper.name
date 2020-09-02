package com.siscondominio.repository;

import com.siscondominio.model.Articles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
       
}
