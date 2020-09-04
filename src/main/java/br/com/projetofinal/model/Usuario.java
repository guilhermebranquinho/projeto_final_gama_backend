package br.com.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="TB_USUARIOS")
@Entity
public class Usuario {
	//variable
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nome",length=40)
	private String nome;
	
	@Column(name="email",length=80)
	private String email;
	
	@Column(name="senha",length=20)
	private String senha;
	
	@Column(name="foto",length=80)
	private String foto;
	
	@Column(name="racf",length=7)
	private String racf;
	
	//constructor
	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String email, String senha, String foto, String racf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.racf = racf;
	}
	//setter
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	//getter
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getFoto() {
		return foto;
	}
	public String getRacf() {
		return racf;
	}	
}
