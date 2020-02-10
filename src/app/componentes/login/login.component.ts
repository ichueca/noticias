import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelo/usuario';
import { NoticiasService } from 'src/app/servicios/noticias.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {
  private usuario:Usuario = new Usuario();
  private error:string;
  constructor(private servicio:NoticiasService,
    private router:Router) { 
    
  }

  ngOnInit() {
  }

  async entrar(nombre){
    try {
      let tk:any = await this.servicio.getToken(this.usuario.nombre,
        this.usuario.password);
        sessionStorage.setItem("token",JSON.stringify(tk));
        this.error="";
        let usuario = await this.servicio.getUsuario(this.usuario.nombre);
        sessionStorage.setItem("usuario", JSON.stringify(usuario));
        console.log(usuario);
        this.router.navigate(["home"]);
    } catch (error)  {
      this.error="Se ha producido un error en la autenticación";
    }
    
    
  }

}
