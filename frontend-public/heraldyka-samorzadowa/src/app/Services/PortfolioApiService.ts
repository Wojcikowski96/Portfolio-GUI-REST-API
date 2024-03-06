import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators'
import { PortfolioPageResponse } from '../Responses/PortfolioPageResponse';
import { AppComponent } from '../app.component';
@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService{
    private getRequestUrl = 'http://localhost:8080/portfolio/entries';
    constructor(private http: HttpClient) { }

    getEntries(pageNo: number, pageSize: number, sortDir: string, sortBy: string, tittle?: string): Observable<PortfolioPageResponse> {
        let params:any = {
            pageNo: pageNo.toString(),
            pageSize: pageSize.toString(),
            sortDir: sortDir,
            sortBy: sortBy
        }
        if(tittle){
            params = {
                pageNo: pageNo.toString(),
                pageSize: pageSize.toString(),
                sortDir: sortDir,
                sortBy: sortBy,
                tittle: tittle
              };
        }
        
        return this.http.post<PortfolioPageResponse>(this.getRequestUrl, params);
      }

}