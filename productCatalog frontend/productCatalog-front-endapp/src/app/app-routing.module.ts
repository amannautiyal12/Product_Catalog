import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProdDetailPageComponent } from './prod-detail-page/prod-detail-page.component';

const routes: Routes = [
{
  path:'login',
  component: LoginComponent
},
{
  path:'',
  component: HomeComponent
},
{
  path:'register',
  component: RegisterComponent
},
{
  component:ProdDetailPageComponent,
  path:'productDetails/:id'
}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
