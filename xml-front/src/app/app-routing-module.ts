import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PatentFormComponent } from './components/patent-form/patent-form.component';

const routes: Routes = [
  {path: 'add-patent', component: PatentFormComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }