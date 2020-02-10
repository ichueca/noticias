import { Component, OnInit } from '@angular/core';
import { NoticiasService } from 'src/app/servicios/noticias.service';
import { Noticia } from 'src/app/modelo/noticia';
import { AreaInteres } from 'src/app/modelo/area-interes';
import { Usuario } from 'src/app/modelo/usuario';
import { AreaInteresComponent } from '../area-interes/area-interes.component';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: []
})
export class HomeComponent implements OnInit {
  private areasInteres:AreaInteres[];
  private area:AreaInteres = new AreaInteres("","",new Date());
  private usuario:Usuario;
  constructor(private service:NoticiasService,
    private router:Router){
    console.log()
    this.usuario = JSON.parse(sessionStorage.getItem("usuario"));
    if (!this.usuario) {
      router.navigate(['login']);
    } else {
      this.cargarAreas();
    }
    
  }

  cargarAreas(){
    this.service.getAreasInteres(this.usuario.id)
        .subscribe(
        (datos:any) => {
          this.areasInteres = datos;
          console.log(this.areasInteres);
        }
      )
  }

  ngOnInit() {
  }

  async eliminar(evt:MouseEvent,id){
    evt.stopPropagation();
    evt.preventDefault();
    await this.service.eliminarAreaInteres(id);
    this.cargarAreas();
  }

  irArea(evt,area){
    evt.preventDefault();
    sessionStorage.setItem("area",JSON.stringify(area));
    this.router.navigate(['areaInteres',area.id]);
  }

  async crear(nuevaForm:NgForm){
    await this.service.nuevaAreaInteres(this.usuario.id,this.area);
    this.cargarAreas();
    this.area = new AreaInteres("","",new Date());
    nuevaForm.reset();
  }
}
