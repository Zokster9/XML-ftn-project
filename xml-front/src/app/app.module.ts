import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing-module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';

@NgModule({
  declarations: [
    AppComponent,
    PatentFormComponent,
    PatentPdfHtmlTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
