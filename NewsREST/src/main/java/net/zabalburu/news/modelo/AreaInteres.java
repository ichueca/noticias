package net.zabalburu.news.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="areasinteres ")
public class AreaInteres implements Serializable{
	@Override
	public String toString() {
		return "AreaInteres [id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechacreacion=" + fechacreacion + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	@JsonIgnore
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "area", cascade = CascadeType.REMOVE)
	private List<TerminoBusqueda> busquedas;
	
	public List<TerminoBusqueda> getBusquedas() {
		return busquedas;
	}

	public void setBusquedas(List<TerminoBusqueda> busquedas) {
		this.busquedas = busquedas;
	}

	private String nombre;
	
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechacreacion;

	public AreaInteres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	
	
}
