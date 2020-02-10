package net.zabalburu.news.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.news.modelo.AreaInteres;
import net.zabalburu.news.modelo.TerminoBusqueda;
import net.zabalburu.news.servicio.NoticiasServicio;

@RestController
public class NoticiasControlador {
	@Autowired
	private NoticiasServicio servicio;
	
	@GetMapping("/api/areas/{idArea}")
	public ResponseEntity<?> getNoticias(@PathVariable("idArea") Integer idArea){
		//return ResponseEntity.ok(servicio.getNoticias(idArea));
		return ResponseEntity.ok(servicio.getNews(idArea));
	}
	
	@DeleteMapping("/api/areas/{idArea}")
	public ResponseEntity<?> eliminarArea(@PathVariable("idArea") Integer idArea){
		return ResponseEntity.ok(servicio.eliminarAreaInteres(idArea));
	}
	
	@PostMapping("/api/areas/{idUsuario}")
	public ResponseEntity<?> nuevaAreaInteres(@PathVariable("idUsuario") Integer id,
			@RequestBody AreaInteres area){
		area.setUsuario(servicio.getUsuarioId(id));
		return ResponseEntity.ok(servicio.añadirAreaInteres(area));
	}
	
	@GetMapping("/api/usuario/{idUsuario}/areas")
	public ResponseEntity<?> getAreasInteres(@PathVariable("idUsuario") Integer idUsuario){
		return ResponseEntity.ok(servicio.getAreasInteres(idUsuario));
	}
	
	
	@GetMapping("/api/areas/{id}/terminos")
	public ResponseEntity<?> getTerminosBusquedaArea(@PathVariable("id") Integer id){
		return ResponseEntity.ok(servicio.getTerminosBusquedasArea(id));
	}
	
	
	@GetMapping("/api/terminos/{id}")
	public ResponseEntity<?> getTerminoBusqueda(@PathVariable("id") Integer idTermino){
		return ResponseEntity.ok(servicio.getTerminoBusqueda(idTermino));
	}
	
	@DeleteMapping("/api/terminos/{id}")
	public ResponseEntity<?> eliminarTerminoBusqueda(@PathVariable("id") Integer idTermino){
		return ResponseEntity.ok(servicio.eliminarTerminoBusqueda(idTermino));
	}
	
	@PostMapping("/api/terminos/{idArea}")
	public ResponseEntity<?> nuevoTerminoBusqueda(@PathVariable("idArea") Integer idArea, @RequestBody TerminoBusqueda termino){
		termino.setArea(servicio.getAreaInteres(idArea));
		return ResponseEntity.ok(servicio.añadirTerminoBusqueda(termino));
	}
	
	@GetMapping("/api/usuarios/{nombre}")
	public ResponseEntity<?> getUsuario(@PathVariable("nombre") String nombre){
		return ResponseEntity.ok(servicio.getUsuario(nombre));
	}
}
