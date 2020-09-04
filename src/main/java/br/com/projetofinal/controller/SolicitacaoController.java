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

import br.com.projetofinal.dao.SolicitacaoDAO;
import br.com.projetofinal.model.Solicitacao;

@RestController
@CrossOrigin("*")
public class SolicitacaoController {
	
	@Autowired
	private SolicitacaoDAO dao;
	
	@PostMapping("/novasolicitacao")
	public ResponseEntity<Solicitacao> add(@RequestBody Solicitacao var_solicitacao){
		try {
			Solicitacao resposta = dao.save(var_solicitacao);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping("/solicitacoes")
	public ResponseEntity<List<Solicitacao>> getAllSolicitacao(){
		ArrayList<Solicitacao> lista = (ArrayList<Solicitacao>) dao.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/atualizarsolicitacao")
	public ResponseEntity<Solicitacao> atualizarSolicitacao(@RequestBody Solicitacao var_solicitacao){
		Solicitacao resposta = dao.findById(var_solicitacao.getNum_seq()).orElse(null);
		if (resposta==null) {
			return ResponseEntity.status(404).build();
		}
		resposta.setStatus(var_solicitacao.getStatus());
		dao.save(resposta);
		return ResponseEntity.ok(resposta);
		
	}
	
	@GetMapping("/solicitacao/{status}")
	public ResponseEntity<List<Solicitacao>> getSolStatus(@PathVariable String status) {
		List<Solicitacao> lista = (ArrayList<Solicitacao>) dao.findByStatus(status);
		if (lista==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	

	
	
}
