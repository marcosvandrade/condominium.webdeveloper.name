package com.siscondominio.services;

import java.util.List;
import java.util.Optional;

import com.siscondominio.dto.ClienteDTO;
import com.siscondominio.dto.ClienteNewDTO;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder pe;
				
	public Usuarios find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Usuarios> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuarios.class.getName()));
	}
				
	public List<Usuarios> findAll() {
		return repo.findAll();
	}

	public Usuarios findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Usuarios obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuarios.class.getName());
		}
		return obj;
	}
	
	public Page<Usuarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
    }
	
	public Usuarios fromDTO(ClienteDTO objDto) {
		return new Usuarios(objDto.getNome(), objDto.getEmail(), null, null, null, null);
	}
	
	public Usuarios fromDTO(ClienteNewDTO objDto) {
		Usuarios cli = new Usuarios(objDto.getNome(), objDto.getCpf(), objDto.getApartamento(), objDto.getContato1(),
													   objDto.getEmail(), pe.encode(objDto.getSenha()));
		cli.addPerfil(Perfil.CLIENTE);
		cli.setCliente(true);
		cli.setAdministrador(false);

		return cli;
	}
	
}
    