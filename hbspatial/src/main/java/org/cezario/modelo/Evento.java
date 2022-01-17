package org.cezario.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.locationtech.jts.geom.Point;


@Entity
public class Evento extends AbstractEntity {

	@NotBlank
	private String descricao;

	@NotBlank
	@Column(columnDefinition = "GEOMETRY")
	private Point localizacao;
	
//	@ManyToMany
//	private List<Pessoa> pessoas;


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Point getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Point localizacao) {
		this.localizacao = localizacao;
	}

}
