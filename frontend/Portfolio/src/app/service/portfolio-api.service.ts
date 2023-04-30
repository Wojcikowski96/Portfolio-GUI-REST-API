import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortfolioPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'
import { AuthService } from './AuthService';
@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService {
  private baseUrl = 'http://localhost:8080/portfolio/entries';
  private baseUrl2 = 'http://localhost:8080/portfolio/entry/details';

  constructor(private http: HttpClient, private authService: AuthService) { }

  getEntries(pageNo: number, pageSize: number, sortDir: string, sortBy: string): Observable<PortfolioPageResponse> {
    const params = {
      pageNo: pageNo.toString(),
      pageSize: pageSize.toString(),
      sortDir: sortDir,
      sortBy: sortBy
    };
    console.log(params)
    return this.http.post<PortfolioPageResponse>(this.baseUrl, params).pipe(map(({pageNo, pageSize, totalElements, totalPages, results})=> new PortfolioPageResponse(pageNo, pageSize, totalElements, totalPages, results)));
  }


  modifyEntry(data: any) {
    const url = 'http://localhost:8080/portfolio/entry';
    console.log("wartość tokenu w post")
    console.log(this.authService.getToken())
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.post(url, data, {headers});
  }
}
