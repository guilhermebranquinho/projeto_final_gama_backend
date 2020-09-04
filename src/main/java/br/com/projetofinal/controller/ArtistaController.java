package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.ArtistaDAO;
import br.com.projetofinal.model.Artista;

@RestController
@CrossOrigin("*")
public class ArtistaController {
	
	@Autowired
	private ArtistaDAO dao;
	
	@GetMapping("/artistas")
	public ResponseEntity<List<Artista>> getAllArtistas(){
		ArrayList<Artista> lista = (ArrayList<Artista>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/artista/{id}")
	public ResponseEntity<Artista> getArtista(@PathVariable int id){
		Artista resposta = dao.findById(id).orElse(null);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	@PostMapping("/nacionalidade")
	public ResponseEntity<List<Artista>> getNacionalidade(@RequestBody Artista var_artista){
		ArrayList<Artista> lista = (ArrayList<Artista>) dao.findByNacionalidade(var_artista.getNacionalidade());
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/incluirartista")
	public ResponseEntity<Artista> incluirArtista(@RequestBody Artista var_artista) {
		try {
			Artista resposta = dao.save(var_artista);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		}
	}
	
}
