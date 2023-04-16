import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortfolioPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'
import { PortfolioEntryDetails } from '../responses/PortfolioEntryDetailsResponse';

@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService {
  private baseUrl = 'http://localhost:8080/portfolio/entries';
  private baseUrl2 = 'http://localhost:8080/portfolio/entry/details';

  constructor(private http: HttpClient) { }

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

  getEntryDetails(entryId:number): Observable<PortfolioEntryDetails> {

    return this.http.get<PortfolioEntryDetails>(`${this.baseUrl2}?entryId=${entryId}`).pipe(map(({id, locationDetails, coatOfArmsDescription, imagesUrlsPageBody, symbolsDescription, history, imagesUrlsPageLeftPane, documents})=> new PortfolioEntryDetails(id, locationDetails, coatOfArmsDescription, imagesUrlsPageBody, symbolsDescription, history, imagesUrlsPageLeftPane, documents)));
  }
}
