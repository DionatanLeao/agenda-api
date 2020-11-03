package com.agenda.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.api.entity.Contato;
import com.agenda.api.repository.ContatoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor	
public class ContatoController {
	
	private final ContatoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato save(@RequestBody Contato contato) {
		return repository.save(contato);
	}
	
	public List<Contato> list() {
		return repository.findAll();
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	public void favorite(@PathVariable Integer id, @RequestBody Boolean favorito) {
		Optional<Contato> contato = repository.findById(id);
		contato.ifPresent(c -> {
			c.setFavorito(favorito);
			repository.save(c);
		});
		
	}
	

}
