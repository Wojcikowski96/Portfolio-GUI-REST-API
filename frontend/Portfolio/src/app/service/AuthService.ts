import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import jwtDecode from 'jwt-decode';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/authenticate';
  private tokenKey = 'auth-token';

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {

   
    return this.http.post(this.apiUrl, { email, password }, {
        responseType: 'text'
      }).pipe(
        map(response => {
          if (response) {
            localStorage.setItem(this.tokenKey, response);
          }
          return response;
        })
      );
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
  }

  getToken(): any {
    const token = localStorage.getItem(this.tokenKey);
    if (token) {
        return jwtDecode(token)
    }
    return null;
  }
}
