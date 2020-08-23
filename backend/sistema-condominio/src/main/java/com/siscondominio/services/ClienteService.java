package com.siscondominio.services;

import java.util.List;
import java.util.Optional;

import com.siscondominio.enums.Perfil;
import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;
import com.siscondominio.security.UserSS;
import com.siscondominio.services.exceptions.AuthorizationException;
import com.siscondominio.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private UserRepository repo;
				
	public Usuarios find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuarios> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuarios.class.getName()));
	}
		
	public Usuarios update(Usuarios obj) {
		Usuarios newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
		
	public List<Usuarios> findAll() {
		return repo.findAll();
	}
	
	public Page<Usuarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
    }
    
	private void updateData(Usuarios newObj, Usuarios obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
    }
}
    