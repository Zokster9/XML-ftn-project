import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing-module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PatentFormComponent } from './components/patent-form/patent-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PatentPdfHtmlTableComponent } from './components/patent-pdf-html-table/patent-pdf-html-table.component';
import { ModalAcceptDeclineRequestComponent } from './components/modal-accept-decline-request/modal-accept-decline-request.component';
import { ModalShowReferenceComponent } from './components/modal-show-reference/modal-show-reference.component';
import { PatentFormXonomyComponent } from './components/patent-form-xonomy/patent-form-xonomy.component';
import { AutorskaFormComponent } from './components/autorska-form/autorska-form.component';
import { AutorskaTableComponent } from './components/autorska-table/autorska-table.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ZigFormComponent } from './components/zig-form/zig-form.component';
import { MatRadioModule } from '@angular/material/radio';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { ZigPdfHtmlTableComponent } from './components/zig-pdf-html-table/zig-pdf-html-table.component';

@NgModule({
  declarations: [
    AppComponent,
    PatentFormComponent,
    PatentPdfHtmlTableComponent,
    ModalAcceptDeclineRequestComponent,
    ModalShowReferenceComponent,
    PatentFormXonomyComponent,
    AutorskaFormComponent,
    AutorskaTableComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    HomePageComponent,
    ZigFormComponent,
    ZigPdfHtmlTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatRadioModule,
    MatChipsModule,
    MatIconModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatSelectModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
