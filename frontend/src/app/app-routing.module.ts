import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavigationComponent } from './components/dashboard/navigation/navigation.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'login', component:LoginComponent },
  { path: 'dashboard',component: NavigationComponent,children: [{path: 'customer', loadChildren: () => import('./components/customer/customer.module').then(m => m.CustomerModule)}]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
