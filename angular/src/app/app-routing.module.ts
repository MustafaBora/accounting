import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewAccountComponent } from './components/new-account/new-account.component';
import { UserInfoComponent } from './components/user-info/user-info.component';


const routes: Routes = [
  {path: '', redirectTo: 'user-info', pathMatch: 'full'},
  {path: 'new-account', component: NewAccountComponent},
  {path: 'user-info', component: UserInfoComponent},
  {path: '**', redirectTo: 'user-info'}
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
