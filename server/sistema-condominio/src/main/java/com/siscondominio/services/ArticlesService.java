package com.siscondominio.services;

import java.util.Optional;

import com.siscondominio.model.Articles;
import com.siscondominio.repository.ArticlesRepository;
import com.siscondominio.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticlesService {

    @Autowired
	private ArticlesRepository repo;
		
	public Articles find(Integer id) {
		Optional<Articles> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Artigo não encontrado! Id: " + id + ", Tipo: " + Articles.class.getName()));
	}

}
