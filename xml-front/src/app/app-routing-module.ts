import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';

const routes: Routes = [
  {path: 'add-patent', component: PatentFormComponent},
  {path: 'view-patent-pdf-html', component: PatentPdfHtmlTableComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }