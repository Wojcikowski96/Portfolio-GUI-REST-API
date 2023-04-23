import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/AuthService';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  token:any;
  isAdmin=false;

  email: string = '';
  password: string = '';

  isWrongData = false;
 

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
   
  }
  authenticate(){
    this.authService.login(this.email, this.password).subscribe(
      response => {
        console.log(response)
        this.authService.setRoles()
        this.isWrongData = false
      },
      error => {
        if (error.status === 403) {
          this.isWrongData = true
        }
      }
    );
    
  }

}
