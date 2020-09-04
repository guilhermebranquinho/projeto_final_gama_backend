package br.com.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="TB_SOLICITACAO")
@Entity
public class Solicitacao {
	
	//variable
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
	private int num_seq;
	
	@Column(name="nome_tecnico",length=100)
	private String nome_tecnico;
	
	@Column(name="operadora",length=50)
	private String operadora;
	
	@Column(name="telefone",length=20)
	private String telefone;
	
	@Column(name="doc",length=20)
	private String doc;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date data;
	
	@Column(name="hora")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	private Date hora;
	
	@ManyToOne
	@JsonIgnoreProperties("solicitacoes")
	private PDV pdv;
	
	@Column(name="status",length=10)
	private String status;
	
	//constructor

	public Solicitacao() {
		super();
	}
	
	public Solicitacao(int num_seq, String nome_tecnico, String operadora, String telefone, String doc, Date data,
			Date hora, PDV pdv, String status) {
		super();
		this.num_seq = num_seq;
		this.nome_tecnico = nome_tecnico;
		this.operadora = operadora;
		this.telefone = telefone;
		this.doc = doc;
		this.data = data;
		this.hora = hora;
		this.pdv = pdv;
		this.status = status;
	}
	
	

	//setter

	public void setNum_seq(int num_seq) {
		this.num_seq = num_seq;
	}

	public void setNome_tecnico(String nome_tecnico) {
		this.nome_tecnico = nome_tecnico;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	//getter
	
	public int getNum_seq() {
		return num_seq;
	}

	public String getNome_tecnico() {
		return nome_tecnico;
	}

	public String getOperadora() {
		return operadora;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDoc() {
		return doc;
	}

	public Date getData() {
		return data;
	}

	public Date getHora() {
		return hora;
	}

	public PDV getPdv() {
		return pdv;
	}
	
	public String getStatus() {
		return status;
	}
	
}
