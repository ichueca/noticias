import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { AreaInteres } from '../modelo/area-interes';
import { TerminoBusquedas } from '../modelo/termino-busquedas';
@Injectable({
  providedIn: "root"
})
export class NoticiasService {
  private URI:string="http://localhost:8080/api/";
  constructor(private http: HttpClient) {}

  async getToken(usuario:string,password:string) {
    let params = new HttpParams();
    params.set("grant_type", "password");
    params.set("username", usuario);
    params.set("password", password);
    console.log(usuario,password);
    let auth = btoa("cliente:password");
    let token =  this.http
      .post("http://localhost:8080/oauth/token", params.toString(), {
        headers: {
          Authorization: "Basic " + auth,
          "content-type": "application/x-www-form-urlencoded"
        },
        "params":{
          "grant_type": "password",
          "username":usuario,
          "password":password
        }
      }).toPromise();
    return token;
  }

  getNoticias(idArea:number){
    return this.http.get(
      this.URI+`areas/${idArea}`
    )
  }

  getAreasInteres(usuario){
    return this.http.get(
      this.URI+`usuario/${usuario}/areas`
    )
  }

  getUsuario(usuario){
    return this.http.get(
      this.URI+`usuarios/${usuario}`
    ).toPromise();
  }

  getTerminosBusqueda(idArea){
    return this.http.get(
      this.URI+`areas/${idArea}/terminos`
    )
  }

  nuevaAreaInteres(idUsuario:number,area:AreaInteres){
    console.log(idUsuario);
    return this.http.post(
      this.URI+`areas/${idUsuario}`,
      JSON.stringify(area),{
        headers: {
        "content-type": "application/json"
        }
      }).toPromise();
  }

  eliminarAreaInteres(idArea:number){
    console.log(this.URI+`areas/${idArea}`);
    return this.http.delete(
      this.URI+`areas/${idArea}`
    ).toPromise();
  }

  nuevoTerminoBusqueda(termino:TerminoBusquedas){
    return this.http.post(
      this.URI+`terminos/${termino.idArea}`,
      JSON.stringify(termino),{
        headers: {
        "content-type": "application/json"
        }
      }).toPromise();
  }

  eliminarTerminoBusqueda(idTermino:number){
    return this.http.delete(
      this.URI+`terminos/${idTermino}`
    ).toPromise();
  }


}
