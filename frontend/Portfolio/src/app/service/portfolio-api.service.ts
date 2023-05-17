import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PortfolioPageResponse } from '../responses/PageResponse';
import {map} from 'rxjs/operators'
import { AuthService } from './AuthService';
@Injectable({
  providedIn: 'root'
})
export class PortfolioApiService {
  
  private getRequestUrl = 'http://localhost:8080/portfolio/entries';
  private uploadFileUrl = 'http://localhost:8080/portfolio/entry/uploadFile';
  private deleteImageUrl = 'http://localhost:8080/portfolio/file/delete';
  private deleteEntryUrl = 'http://localhost:8080/portfolio/entries/delete';


  constructor(private http: HttpClient, private authService: AuthService) { }

  getEntries(pageNo: number, pageSize: number, sortDir: string, sortBy: string): Observable<PortfolioPageResponse> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    const params = {
      pageNo: pageNo.toString(),
      pageSize: pageSize.toString(),
      sortDir: sortDir,
      sortBy: sortBy
    };
    console.log(params)
    return this.http.post<PortfolioPageResponse>(this.getRequestUrl, params, {headers}).pipe(map(({pageNo, pageSize, totalElements, totalPages, results})=> new PortfolioPageResponse(pageNo, pageSize, totalElements, totalPages, results)));
  }


  modifyEntry(data: any) {
    const url = 'http://localhost:8080/portfolio/entry';
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.post(url, data, {headers});
  }
  uploadFileToPortfolio(entryId: number, formData:FormData) {
    const url = `${this.uploadFileUrl}?entryId=${entryId}`;
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.authService.getToken(),
    });
    return this.http.post(url, formData, { headers });
  }

  deleteImageById(imageId: number){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    return this.http.delete(`${this.deleteImageUrl}?imageId=${imageId}`,{headers});
  }

  deleteEntryById(entryId: number){
    const headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.authService.getToken());
    console.log("usuwam")
    return this.http.delete(`${this.deleteEntryUrl}?entryId=${entryId}`,{headers});
  }

  downloadFile(documentUrl: string, type:string) {
    this.http.get(`${documentUrl}`, { responseType: 'blob' })
    .subscribe(blob => {
      let contentType:string |undefined;
      if(type=='PDF'){
        contentType='application/pdf';

      }else if(type=="IMAGE"){
        contentType='image/jpg';
      }
      const file = new Blob([blob], { type: contentType });
      const fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });
  
  }
}
