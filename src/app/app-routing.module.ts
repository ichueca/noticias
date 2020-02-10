import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './componentes/login/login.component';
import { HomeComponent } from './componentes/home/home.component';
import { AreaInteresComponent } from './componentes/area-interes/area-interes.component';
import { NoticiasService } from './servicios/noticias.service';
import { NoticiasComponent } from './componentes/noticias/noticias.component';


const routes: Routes = [
  {
    path:"", component:LoginComponent
  },
  {
    path:"home", component:HomeComponent
  },
  {
    path:"login", component:LoginComponent
  },
  {
    path:"areaInteres/:id", component:AreaInteresComponent
  },
  {
    path:"noticias/:id", component:NoticiasComponent
  },
  {
    path:"**", redirectTo:"home"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
