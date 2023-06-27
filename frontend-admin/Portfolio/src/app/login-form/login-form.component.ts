import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/AuthService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  buttonClicked!: boolean | false;
  isLoading!:boolean | false;
  token:any;
  isAdmin=false;

  email: string = '';
  password: string = '';

  isWrongData = false;
 

  constructor(private authService:AuthService, private router: Router) { }

  ngOnInit(): void {
   
  }
  authenticate(){
    this.buttonClicked = true
    this.isLoading = true;
    this.authService.login(this.email, this.password).subscribe(
      response => {
        console.log(response)
        this.authService.setRoles()
        this.isWrongData = false
        this.isLoading = false
        this.router.navigateByUrl('portfolio')

      },
      error => {
        if (error.status === 403) {
          this.isWrongData = true
          this.isLoading = false
        }
      }
    );
    
  }

}
