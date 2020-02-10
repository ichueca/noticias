import { Component, OnInit } from '@angular/core';
import { NoticiasService } from 'src/app/servicios/noticias.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TerminoBusquedas } from 'src/app/modelo/termino-busquedas';
import { AreaInteres } from 'src/app/modelo/area-interes';

@Component({
  selector: 'app-area-interes',
  templateUrl: './area-interes.component.html',
  styles: []
})
export class AreaInteresComponent implements OnInit {
  private terminos:TerminoBusquedas[];
  private termino:TerminoBusquedas = new TerminoBusquedas("",10);
  private area:AreaInteres;
  constructor(private servicio:NoticiasService,
    private ruta:ActivatedRoute,
    private router:Router) { 
      this.area = JSON.parse(sessionStorage.getItem("area"));
      this.getTerminosBusqueda();
    }

  ngOnInit() {
  }

  getTerminosBusqueda(){
    this.servicio.getTerminosBusqueda(this.area.id).subscribe(
      (datos:any) => {
        console.log(datos);
        this.terminos = datos;
      }
    );
  }

  async crear(){
    this.termino.idArea = this.area.id;
    await this.servicio.nuevoTerminoBusqueda(this.termino);
    this.getTerminosBusqueda();
    this.termino = new TerminoBusquedas("",10);
  }

  async eliminar(evt:MouseEvent,id:number){
    evt.stopPropagation();
    evt.preventDefault();
    await this.servicio.eliminarTerminoBusqueda(id);
    this.getTerminosBusqueda();
  }

  verNoticias(){
    this.router.navigate(['noticias',this.area.id]);
    
  }
  volver(evt:MouseEvent){
    evt.preventDefault();
    window.history.back();
  }
}
