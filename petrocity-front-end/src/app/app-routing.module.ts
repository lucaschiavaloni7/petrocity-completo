import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegisterInterestedComponent } from './register-interested/register-interested.component';
import { SuccessFormComponent } from './register-interested/success-form/success-form.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'empreendimento', component: RegisterInterestedComponent },
  { path: 'obrigado', component: SuccessFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
