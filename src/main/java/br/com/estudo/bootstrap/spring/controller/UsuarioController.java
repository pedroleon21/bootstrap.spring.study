package br.com.estudo.bootstrap.spring.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.estudo.bootstrap.spring.DTO.UsuarioDTO;
import br.com.estudo.bootstrap.spring.form.UsuarioCompletoForm;
import br.com.estudo.bootstrap.spring.form.UsuarioForm;
import br.com.estudo.bootstrap.spring.model.Usuario;
import br.com.estudo.bootstrap.spring.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		Usuario user = repository.getById(id);
		repository.delete(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDTO> editar(@PathVariable("id") Long id, @RequestBody UsuarioCompletoForm userForm) {
		Optional<Usuario> optional = repository.findById(id);
		if (optional.isPresent()) {
			Usuario user = optional.get();
			userForm.fazerMudancas(user);
			return ResponseEntity.ok(new UsuarioDTO(user));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable("id") Long id) {
		Optional<Usuario> user = repository.findById(id);
		if (user.isPresent())
			return ResponseEntity.ok(new UsuarioDTO(user.get()));

		return ResponseEntity.notFound().build();
	}

	@RequestMapping
	@GetMapping
	public List<UsuarioDTO> getUsers(Long id, String nome, String email, Long nacimentoTms) {
		Date nascimento = nacimentoTms != null ? new Date(nacimentoTms) : null;
		if (id != null && email != null && nascimento != null)
			return repository.findAll().stream()
					.filter(u -> u.getId().equals(id) && u.getEmail().equals(email)
							&& u.getNascimento().equals(nascimento) && u.getNome().equals(nome))
					.map(UsuarioDTO::new).collect(Collectors.toList());
		if(email != null)
			return repository.findByEmail(email).stream().map(UsuarioDTO::new).collect(Collectors.toList());
		if(nome != null)
			return repository.findByNome(nome).stream().map(UsuarioDTO::new).collect(Collectors.toList());
		if(nascimento != null)
			return repository.findByNascimento(nascimento).stream().map(UsuarioDTO::new).collect(Collectors.toList());
		List<Usuario> usuarios = repository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> cadastarUsuario(@RequestBody UsuarioForm userFrom,
			UriComponentsBuilder uriBuilder) {
		Usuario user = userFrom.toEntity();
		repository.save(user);
		URI uri = uriBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDTO(user));
	}
}
