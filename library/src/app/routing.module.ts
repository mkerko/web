import { NgModule } from '@angular/core'; 
import { RouterModule, Routes } from '@angular/router'; 
import { UsersComponent } from './components/users.component';
import { ErrorComponent } from './components/error.component';
import { LoginComponent } from './components/login.component';
import { ExchangeRatesComponent } from './components/exchange-rates.component';
import { UserDetailComponent } from './components/user-details.component';
import { RegistrationComponent } from './components/registration.component';
import { EditUserComponent } from './components/edit-user.component';
 

const routes: Routes = [ 
{ path: '', redirectTo: '/users', pathMatch: 'full' }, 
{ path: 'login', component: LoginComponent}, 
{ path: 'exchange', component: ExchangeRatesComponent}, 
{ path: 'users', component: UsersComponent}, 
{ path: 'error', component: ErrorComponent }, 
{ path: 'users/:id', component: UserDetailComponent },
{ path: 'users/:id/edit', component: EditUserComponent },
{ path: 'registration', component: RegistrationComponent }
]; 
@NgModule({ 
imports: [ RouterModule.forRoot(routes) ], 
exports: [ RouterModule ] 
}) 

export class AppRoutingModule {}