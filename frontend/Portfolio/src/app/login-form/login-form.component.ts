import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/AuthService';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  token:any;

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }
  authenticate(){
    console.log("klikłem")
    this.authService.login("wojcikowski1@gmail.com", "test").subscribe(response => {
      console.log(response)
      const token = localStorage.getItem('auth-token');
      if(token){
        const decodedToken = JSON.parse(atob(token.split('.')[1]));
        const roles = decodedToken.authorities.map((authority: any) => authority.authority);
        
        console.log(roles);
      }
    });

    
  }

}
