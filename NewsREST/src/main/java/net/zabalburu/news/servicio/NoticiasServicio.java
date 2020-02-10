package net.zabalburu.news.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.news.dao.NewsDAO;
import net.zabalburu.news.modelo.AreaInteres;
import net.zabalburu.news.modelo.Articulo;
import net.zabalburu.news.modelo.Noticia;
import net.zabalburu.news.modelo.TerminoBusqueda;
import net.zabalburu.news.modelo.Usuario;

@Service
public class NoticiasServicio implements NewsDAO{
	@Autowired
	private NewsDAO dao;
	
	@Override
	public List<Noticia> getNoticias(Integer idArea) {
		return dao.getNoticias(idArea);
		
	}

	@Override
	public List<Articulo> getNews(Integer idArea) {
		return dao.getNews(idArea);
	}
	
	@Override
	public AreaInteres añadirAreaInteres(AreaInteres nueva) {
		return dao.añadirAreaInteres(nueva);
	}

	@Override
	public AreaInteres eliminarAreaInteres(Integer idArea) {
		return dao.eliminarAreaInteres(idArea);
	}

	@Override
	public TerminoBusqueda añadirTerminoBusqueda(TerminoBusqueda nuevo) {
		return dao.añadirTerminoBusqueda(nuevo);
	}

	@Override
	public TerminoBusqueda eliminarTerminoBusqueda(Integer idTermino) {
		return dao.eliminarTerminoBusqueda(idTermino);
	}

	@Override
	public AreaInteres getAreaInteres(Integer id) {
		return dao.getAreaInteres(id);
	}

	@Override
	public List<TerminoBusqueda> getTerminosBusquedasArea(Integer idArea) {
		return dao.getTerminosBusquedasArea(idArea);
	}

	@Override
	public TerminoBusqueda getTerminoBusqueda(Integer idTermino) {
		return dao.getTerminoBusqueda(idTermino);
	}

	@Override
	public List<AreaInteres> getAreasInteres(Integer idUsuario) {
		return dao.getAreasInteres(idUsuario);
	}

	@Override
	public Usuario getUsuario(String nombre) {
		return dao.getUsuario(nombre);
	}

	@Override
	public Usuario getUsuarioId(Integer id) {
		return dao.getUsuarioId(id);
	}

}
