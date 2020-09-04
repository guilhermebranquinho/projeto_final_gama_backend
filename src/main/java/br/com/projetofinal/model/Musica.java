package br.com.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="TB_MUSICA")
@Entity
public class Musica {
	//variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="titulo",length=40)
	private String titulo;
	
	@Column(name="ano")
	private int ano;
	
	@ManyToOne
	@JsonIgnoreProperties("musicas")
	private Artista artista;


	//constructor
	public Musica() {
		super();
	}
	public Musica(int id, String titulo, int ano, Artista artista) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.artista = artista;
	}
	
	//setter
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	//getter
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getAno() {
		return ano;
	}
	public Artista getArtista() {
		return artista;
	}
	
	
	
}
