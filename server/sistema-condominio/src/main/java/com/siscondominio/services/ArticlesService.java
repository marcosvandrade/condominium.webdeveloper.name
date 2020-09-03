package com.siscondominio.services;

import java.util.Optional;

import com.siscondominio.enums.Perfil;
import com.siscondominio.model.Articles;
import com.siscondominio.repository.ArticlesRepository;
import com.siscondominio.security.UserSS;
import com.siscondominio.services.exceptions.AuthorizationException;
import com.siscondominio.services.exceptions.DataIntegrityException;
import com.siscondominio.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticlesService {

    @Autowired
	private ArticlesRepository repo;
		
	public Articles find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) || !user.hasRole(Perfil.CLIENTE) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Articles> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Artigo não encontrado! Id: " + id + ", Tipo: " + Articles.class.getName()));
	}

	@Transactional
	public Articles insert(Articles obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Articles update(Articles obj) {
		Articles newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há artigos relacionados");
		}
	}

	private void updateData(Articles newObj, Articles obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setContent(obj.getContent());
	}

}
