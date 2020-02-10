package net.zabalburu.news.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="terminobusqueda")
public class TerminoBusqueda implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idarea")
	private AreaInteres area;
	
	private String busqueda;
	
	@Column(name="numresultados")
	private Integer numResultados;

	public TerminoBusqueda() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AreaInteres getArea() {
		return area;
	}

	public void setArea(AreaInteres area) {
		this.area = area;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public Integer getNumResultados() {
		return numResultados;
	}

	public void setNumResultados(Integer numResultados) {
		this.numResultados = numResultados;
	}
	
	
}
