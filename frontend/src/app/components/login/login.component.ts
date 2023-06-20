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
  isLoged = false;
  isLguedFaild = false;
  loginUser!: LoginUser;
  nameUser!: string;
  password!: string;
  roles: string[] = [];
  errMsj!: string;
  constructor(private tokenService: TokenService, private authService: AuthService, private router: Router) {

  }
 ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLoged = true;
      this.isLguedFaild = false;
      this.roles = this.tokenService.getAuthorities();

    }
 }
   onLogin(): void {
      this.loginUser = new LoginUser(this.nameUser, this.password);
      this.authService.login(this.loginUser).subscribe(data => {
        this.isLoged = true;
        this, this.isLguedFaild = false;
        this.tokenService.setToken(data.token);
        this.tokenService.setUserName(data.nameUser);
        this.tokenService.setAuthorities(data.authorities);
        this.router.navigate(['dashboard']);
         
      }, err => {
        this.isLoged = false;
        this.isLguedFaild = true;
        err.console.error();

      });
    
  }
  
  
  

  }


