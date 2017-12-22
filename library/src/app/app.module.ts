import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { UserService } from './services/user.service';
import { UsersComponent } from './components/users.component';
import { HttpModule } from '@angular/http';
import { ErrorComponent } from './components/error.component';
import { AppRoutingModule } from './routing.module';
import { LoginComponent } from './components/login.component';
import { ExchangeRatesService } from './services/exchange-rates.service';
import { ExchangeRatesComponent } from './components/exchange-rates.component';
import { UserDetailComponent } from './components/user-details.component';
import { RegistrationComponent } from './components/registration.component';
import { EditUserComponent } from './components/edit-user.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ErrorComponent,
    LoginComponent,
    ExchangeRatesComponent,
    UserDetailComponent,
    RegistrationComponent,
    EditUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [UserService, ExchangeRatesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
