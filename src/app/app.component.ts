import { Component } from '@angular/core';
import { NoticiasService } from './servicios/noticias.service';
import { Noticia } from './modelo/noticia';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'noticias';
  
}
