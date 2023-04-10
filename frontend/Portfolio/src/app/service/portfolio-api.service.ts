import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'
import { PortfolioEntryDetails } from '../responses/PortfolioEntryDetails';

@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService {
  private baseUrl = 'http://localhost:8080/portfolio/entries';
  private baseUrl2 = 'http://localhost:8080/portfolio/entry/details';

  constructor(private http: HttpClient) { }

  getEntries(pageNo: number, pageSize: number, sortDir: string, sortBy: string): Observable<PageResponse> {
    const params = {
      pageNo: pageNo.toString(),
      pageSize: pageSize.toString(),
      sortDir: sortDir,
      sortBy: sortBy
    };
    console.log(params)
    return this.http.post<PageResponse>(this.baseUrl, params).pipe(map(({pageNo, pageSize, totalElements, totalPages, results})=> new PageResponse(pageNo, pageSize, totalElements, totalPages, results)));
  }

//   getEntryDetails(entryId:number): Observable<PortfolioEntryDetails> {
//     const params = {
//       entryId: entryId
//     };
    
//     return this.http.get<PortfolioEntryDetails>(this.baseUrl, params).pipe(map(({pageNo, pageSize, totalElements, totalPages, results})=> new PageResponse(pageNo, pageSize, totalElements, totalPages, results)));
//   }
// }
}
