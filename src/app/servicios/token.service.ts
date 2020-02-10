import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpHandler, HttpRequest, HttpEvent} from "@angular/common/http";
import {from, Observable} from 'rxjs';
import { NoticiasService } from './noticias.service';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class TokenService 
  implements HttpInterceptor{
  intercept(req: HttpRequest<any>, 
        next: HttpHandler): Observable<HttpEvent<any>> {
     return from(this.getToken(req,next));
  }

  constructor(private servicio:NoticiasService,
    private router:Router) { }

  private async getToken(req,next): Promise<HttpEvent<any>>{
    if ( req.url.includes("token")){
        return next.handle(req).toPromise();
    } else {
      //let tk:any = await this.servicio.getToken("juan","juan");
      let tk:any = JSON.parse(sessionStorage.getItem("token"));
      let request = req.clone({
        setHeaders: {
          authorization: `Bearer ${ tk.access_token }`
        }
      });
      return next.handle(request).toPromise();
    }   
    
  }
}
