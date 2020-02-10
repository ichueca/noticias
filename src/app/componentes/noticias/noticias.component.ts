import { Component, OnInit } from '@angular/core';
import { NoticiasService } from 'src/app/servicios/noticias.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location} from '@angular/common';
import { AreaInteres } from 'src/app/modelo/area-interes';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styles: []
})
export class NoticiasComponent implements OnInit {
  private noticias:any[];
  private area:AreaInteres;
  constructor(private servicio:NoticiasService,
    private ruta:ActivatedRoute,    
    private location:Location) { 
      this.area = JSON.parse(sessionStorage.getItem("area"));
      this.servicio.getNoticias(this.ruta.snapshot.params["id"]).subscribe(
      (datos:any) => {
        this.noticias = datos;
        console.log(this.noticias);
      }
    )
  }

  ngOnInit() {
  }

  volver(evt:MouseEvent){
    evt.preventDefault();
    this.location.back();
  }

}
