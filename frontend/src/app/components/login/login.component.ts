import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { timeout } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginUser } from './login-user';
import { TokenService } from './token.service';
import { AuthService } from './auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form!: FormGroup;
  isLoged = false;
  isLguedFaild = false;
  loginUser!: LoginUser;
  nameUser!: string;
  password!: string;
  roles: string[] = [];
  errMsj!: string;


  // New Bed Form onInit


  constructor(private tokenService: TokenService, private authService: AuthService, private router: Router, private fb: FormBuilder) {
    this.form = this.fb.group({
      nameUser: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLoged = true;
      this.isLguedFaild = false;
      this.roles = this.tokenService.getAuthorities();

    }
  }
  onLogin(): void {

    const nameUser = this.form.value.nameUser; 
    const password = this.form.value.password; 

    this.loginUser = new LoginUser(nameUser, password);
   //console.log(this.loginUser)
    this.authService.login(this.loginUser).subscribe(
      {
        next: data => {
          this.isLoged = true;
          this, this.isLguedFaild = false;
          this.tokenService.setToken(data.token);
          this.tokenService.setUserName(data.username);
          this.tokenService.setAuthorities(data.authorities);
          this.router.navigate(['dashboard']);
         // console.log(this.loginUser)
        },
        error: err => {
          this.isLoged = false;
          this.isLguedFaild = true;
          err.console.error();
        },
      });
  }




}


