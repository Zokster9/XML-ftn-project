import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PatentFormXonomyComponent } from './components/patent-form-xonomy/patent-form-xonomy.component';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';

const routes: Routes = [
  {path: 'add-patent', component: PatentFormComponent},
  {path: 'view-patent-pdf-html', component: PatentPdfHtmlTableComponent},
  {path: 'add-patent-xonomy', component:PatentFormXonomyComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }