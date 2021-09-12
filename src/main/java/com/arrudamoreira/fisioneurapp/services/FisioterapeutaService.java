package com.arrudamoreira.fisioneurapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.enums.Perfil;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaDTO;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaNewDTO;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.security.UserSS;
import com.arrudamoreira.fisioneurapp.services.exceptions.AuthorizationException;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

/**
 *
 * @author Mario Arruda
 */
@Service
public class FisioterapeutaService {

	@Autowired
	private FisioterapeutaRepository repo;

	@Autowired
	private BCryptPasswordEncoder pe;

	public List<Fisioterapeuta> findAll() {
		return repo.findAll();
	}

	public Fisioterapeuta find(Long id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN_FISIO) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Fisioterapeuta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fisioterapeuta.class.getName()));
	}

	public Fisioterapeuta findByEmail(String email) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN_FISIO) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Fisioterapeuta> obj = Optional.ofNullable(repo.findByEmail(email));
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! email: " + email + ", Tipo: " + Fisioterapeuta.class.getName()));
	}

	public Fisioterapeuta fromDTO(FisioterapeutaNewDTO objDto) {
		return new Fisioterapeuta(null, objDto.getNome(), objDto.getCpfOuCnpj(), objDto.getEmail(),
				pe.encode(objDto.getSenha()), objDto.getCrefito(), objDto.getDataNascimento());
	}

	public Fisioterapeuta fromDTO(FisioterapeutaDTO objDto) {
		return new Fisioterapeuta(objDto.getId(), objDto.getNome(), objDto.getCpfOuCnpj(), objDto.getEmail(),
				pe.encode(objDto.getSenha()), objDto.getCrefito(), objDto.getDataNascimento());
	}

	@Transactional
	public Fisioterapeuta insert(Fisioterapeuta obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Fisioterapeuta update(Fisioterapeuta obj) {
		Fisioterapeuta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Fisioterapeuta newObj, Fisioterapeuta obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpfOuCnpj(obj.getCpfOuCnpj());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setCrefito(obj.getCrefito());
	}

}
