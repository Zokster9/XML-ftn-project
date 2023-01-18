import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    email: '',
    password: '',
  });

  constructor(private formBuilder: FormBuilder) {}


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  login() {
    
  }
}
