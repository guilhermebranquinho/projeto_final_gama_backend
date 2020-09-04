package br.com.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.MusicaDAO;
import br.com.projetofinal.model.Musica;

@RestController
@CrossOrigin("*")
public class MusicaController {
	
	@Autowired
	private MusicaDAO dao;
	
	@PostMapping("/incluirmusica")
	public ResponseEntity<Musica> add(@RequestBody Musica var_musica){
		try {
			Musica resposta = dao.save(var_musica);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		}
	}
}
