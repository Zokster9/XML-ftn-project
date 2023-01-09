import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing-module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';
import { ModalAcceptDeclineRequestComponent } from './components/modal-accept-decline-request/modal-accept-decline-request.component';
import { ModalShowReferenceComponent } from './components/modal-show-reference/modal-show-reference.component';
import { PatentFormXonomyComponent } from './components/patent-form-xonomy/patent-form-xonomy.component';

@NgModule({
  declarations: [
    AppComponent,
    PatentFormComponent,
    PatentPdfHtmlTableComponent,
    ModalAcceptDeclineRequestComponent,
    ModalShowReferenceComponent,
    PatentFormXonomyComponent
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
