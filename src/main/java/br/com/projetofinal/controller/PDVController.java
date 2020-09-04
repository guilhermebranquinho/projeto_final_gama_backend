package br.com.projetofinal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetofinal.dao.PDVDAO;
import br.com.projetofinal.model.Artista;
import br.com.projetofinal.model.PDV;

@RestController
@CrossOrigin("*")
public class PDVController {
	
	@Autowired
	private PDVDAO dao;
	
	@GetMapping("/pdv")
	public ResponseEntity<List<PDV>> getAllPDV(){
		ArrayList<PDV> lista = (ArrayList<PDV>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

}
