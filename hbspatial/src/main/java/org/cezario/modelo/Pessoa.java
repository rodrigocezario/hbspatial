package org.cezario.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.locationtech.jts.geom.Point;

@Entity
public class Pessoa extends AbstractEntity {


	private String nome;

	private LocalDate dataCadastro;

	@Column(columnDefinition = "GEOMETRY")
	private Point localizacao;
	
//	@ManyToMany
//	@JoinTable(
//			  name = "evento_pessoa", 
//			  joinColumns = @JoinColumn(name = "pessoa_id"), 
//			  inverseJoinColumns = @JoinColumn(name = "evento_id"))
//	private List<Evento> eventos;
	
	public Pessoa() {
		this.dataCadastro = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Point getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Point localizacao) {
		this.localizacao = localizacao;
	}
	

}
