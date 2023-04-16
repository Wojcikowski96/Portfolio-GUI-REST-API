import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BlogPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class BlogApiService {
  private baseUrl = 'http://localhost:8080/blog/entries';

  constructor(private http: HttpClient) { }

  getEntries(pageNo: number, pageSize: number, sortDir: string, sortBy: string): Observable<BlogPageResponse> {
    const params = {
      pageNo: pageNo.toString(),
      pageSize: pageSize.toString(),
      sortDir: sortDir,
      sortBy: sortBy
    };
    console.log(params)
    return this.http.post<BlogPageResponse>(this.baseUrl, params).pipe(map(({pageNo, pageSize, totalElements, totalPages, results})=> new BlogPageResponse(pageNo, pageSize, totalElements, totalPages, results)));
  }


}
