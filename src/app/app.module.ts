import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { TokenService } from './servicios/token.service';
import { LoginComponent } from './componentes/login/login.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './componentes/home/home.component';
import { AreaInteresComponent } from './componentes/area-interes/area-interes.component';
import { NoticiasComponent } from './componentes/noticias/noticias.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AreaInteresComponent,
    NoticiasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenService,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
