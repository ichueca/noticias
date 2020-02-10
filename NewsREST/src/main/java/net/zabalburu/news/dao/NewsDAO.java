package net.zabalburu.news.dao;

import java.util.List;

import net.zabalburu.news.modelo.AreaInteres;
import net.zabalburu.news.modelo.Articulo;
import net.zabalburu.news.modelo.Noticia;
import net.zabalburu.news.modelo.TerminoBusqueda;
import net.zabalburu.news.modelo.Usuario;

public interface NewsDAO {
	List<Noticia> getNoticias(Integer idArea);
	List<Articulo> getNews(Integer idArea);
	List<AreaInteres> getAreasInteres(Integer idUsuario);
	List<TerminoBusqueda> getTerminosBusquedasArea(Integer idArea);
	AreaInteres getAreaInteres(Integer id);
	AreaInteres añadirAreaInteres(AreaInteres nueva);
	AreaInteres eliminarAreaInteres(Integer idArea);
	TerminoBusqueda añadirTerminoBusqueda(TerminoBusqueda nuevo);
	TerminoBusqueda eliminarTerminoBusqueda(Integer idTermino);
	TerminoBusqueda getTerminoBusqueda(Integer idTermino);
	Usuario getUsuario(String nombre);
	Usuario getUsuarioId(Integer id);
}
