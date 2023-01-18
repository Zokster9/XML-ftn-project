import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AutorskaFormComponent } from './components/autorska-form/autorska-form.component';
import { AutorskaTableComponent } from './components/autorska-table/autorska-table.component';
import { PatentFormXonomyComponent } from './components/patent-form-xonomy/patent-form-xonomy.component';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';

const routes: Routes = [
  {path: 'kreiraj-autorska', component: AutorskaFormComponent},
  {path: 'kreiraj-patent', component: PatentFormComponent},
  {path: 'pregledaj-patente', component: PatentPdfHtmlTableComponent},
  {path: 'kreiraj-patent-xonomy', component:PatentFormXonomyComponent},
  {path: 'pregledaj-autorska', component: AutorskaTableComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }