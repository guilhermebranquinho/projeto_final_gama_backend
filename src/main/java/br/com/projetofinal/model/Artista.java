package br.com.projetofinal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="TB_ARTISTA")
@Entity
public class Artista {
	//variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome",length=30)
	private String nome;
	
	@Column(name="nacionalidade",length=30)
	private String nacionalidade;
	
	@OneToMany(mappedBy="artista", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("artista")
	private List<Musica> musicas;
	
	@Column(name="nascimento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date nascimento;
	
	//constructor
	public Artista() {
		super();
	}	
	public Artista(int id, String nome, String nacionalidade, List<Musica> musicas, Date nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.musicas = musicas;
		this.nascimento = nascimento;
	}

	//setter
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	//getter
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public Date getNascimento() {
		return nascimento;
	}
	
}
