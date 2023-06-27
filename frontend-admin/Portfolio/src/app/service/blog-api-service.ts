import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BlogPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'
import { AuthService } from './AuthService';
import { BlogEntry } from '../responses/BlogEntry';

@Injectable({
  providedIn: 'root'
})
export class BlogApiService {
  private baseUrl = 'http://localhost:8080/blog/entries';
  private baseUrl2 = 'http://localhost:8080/blog/entry';
  private uploadFileUrl = 'http://localhost:8080/blog/entry/uploadImage';
  private deleteEntryUrl = 'http://localhost:8080/blog/entries/delete';
 

  constructor(private http: HttpClient, private authService: AuthService) { }

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
  modifyEntry(data: any) {
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.post(this.baseUrl2, data, {headers});
  }

  uploadFileToPortfolio(entryId: number, formData:FormData) {
    const url = `${this.uploadFileUrl}?entryId=${entryId}`;
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.getToken(),
    });
    return this.http.post(url, formData, { headers });
  }
  deleteEntryById(entryId: number){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    console.log("usuwam")
    return this.http.delete(`${this.deleteEntryUrl}?entryId=${entryId}`,{headers});
  }
  getEntry(id: number) {
    const url = 'http://localhost:8080/blog/entry';
    return this.http.get<BlogEntry>(`${this.baseUrl2}?entryId=${id}`).pipe(
      map((response: any) => {
        return response as BlogEntry;
      })
    );
  }


}
