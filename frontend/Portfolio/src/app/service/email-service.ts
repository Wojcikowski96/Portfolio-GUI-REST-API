import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BlogPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class EmailApiService {
    private baseUrl = 'http://localhost:8080/email/send';
  
    constructor(private http: HttpClient) { }
  
    sendEmail(tittle: string, content: string, email: string, nick: string): Observable<any> {
  
      const params = {tittle, content, email, nick};
 
      return this.http.post(this.baseUrl, params);
    }
  }
  
