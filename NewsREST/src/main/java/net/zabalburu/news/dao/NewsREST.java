package net.zabalburu.news.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.news.modelo.AreaInteres;
import net.zabalburu.news.modelo.Articulo;
import net.zabalburu.news.modelo.Noticia;
import net.zabalburu.news.modelo.TerminoBusqueda;
import net.zabalburu.news.modelo.Usuario;
import net.zabalburu.news.modelo.dto.NewsApiDTO;
import net.zabalburu.news.modelo.dto.NewsDTO;

@Repository
@Transactional
public class NewsREST implements NewsDAO{
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private EntityManager em;
	
	private List<Noticia> getNoticias(String q, Integer num){
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-rapidapi-key", "333b042ea5msh873fe5be7047703p1f190ajsn6a78e3b54294");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<NewsDTO> resp = template.exchange(
				 "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/NewsSearchAPI?q="
						+ q +"&page_size="+num ,
			HttpMethod.GET,
			entity,
			NewsDTO.class);
		NewsDTO datos =	resp.getBody();
		return datos.getValue();
	}
	
	private List<Articulo> getNews(String q, Integer num){
		NewsApiDTO dto = template.getForObject(
				"https://newsapi.org/v2/everything?q={q}&apiKey={key}", 
				NewsApiDTO.class,q,"651e0033a1ba40ec9be7548be12e6f39");
		System.out.println(dto);
		return dto.getArticles();
	}
	
	public List<Articulo> getNews(Integer idArea) {
		List<TerminoBusqueda> busquedas = getTerminosBusquedasArea(idArea);
		List<Articulo> noticias = new ArrayList<>();
		for(TerminoBusqueda tb : busquedas) {
			List<Articulo> not = getNews(tb.getBusqueda(),tb.getNumResultados());
			if (not != null) {
				noticias.addAll(not);
			}
		}
		return noticias;
	}
	
	@Override
	public List<Noticia> getNoticias(Integer idArea) {
		List<TerminoBusqueda> busquedas = getTerminosBusquedasArea(idArea);
		List<Noticia> noticias = new ArrayList<>();
		for(TerminoBusqueda tb : busquedas) {
			noticias.addAll(getNoticias(tb.getBusqueda(),tb.getNumResultados()));
		}
		return noticias;
	}

	@Override
	public List<AreaInteres> getAreasInteres(Integer idUsuario) {
		Query q = em.createQuery("Select a From AreaInteres a Where a.usuario.id=:id Order By a.nombre");
		q.setParameter("id", idUsuario);
		return q.getResultList();
	}

	@Override
	public List<TerminoBusqueda> getTerminosBusquedasArea(Integer idArea) {
		Query q = em.createQuery("Select t From TerminoBusqueda t where t.area.id = :id Order By t.busqueda");
		q.setParameter("id", idArea);
		return q.getResultList();
	}

	@Override
	public AreaInteres añadirAreaInteres(AreaInteres nueva) {
		System.out.println("Nueva : " + nueva);
		nueva = em.merge(nueva);
		return nueva;
	}

	@Override
	public AreaInteres eliminarAreaInteres(Integer idArea) {
		AreaInteres area = getAreaInteres(idArea);
		em.remove(area);
		return area;
	}

	@Override
	public TerminoBusqueda añadirTerminoBusqueda(TerminoBusqueda nuevo) {
		nuevo = em.merge(nuevo);
		return nuevo;
	}

	@Override
	public TerminoBusqueda eliminarTerminoBusqueda(Integer idTermino) {
		TerminoBusqueda termino = getTerminoBusqueda(idTermino);
		em.remove(termino);
		return termino;
	}

	@Override
	public AreaInteres getAreaInteres(Integer id) {
		return em.find(AreaInteres.class, id);
	}

	@Override
	public TerminoBusqueda getTerminoBusqueda(Integer idTermino) {
		return em.find(TerminoBusqueda.class, idTermino);
	}

	@Override
	public Usuario getUsuario(String nombre) {
		Query q = em.createQuery("Select u From Usuario u where lower(u.nombre)=:nombre");
		q.setParameter("nombre", nombre.toLowerCase());
		return (Usuario) q.getSingleResult();
	}
	
	@Override
	public Usuario getUsuarioId(Integer id) {
		return em.find(Usuario.class, id);
	}

}
