import { Component, OnInit } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { NavigationExtras } from '@angular/router';


@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss']
})
export class PortfolioComponent implements OnInit {
  pageResponse: PageResponse | undefined;
  results: Array<PortfolioEntry> | undefined;
  page: number | undefined;


  constructor(private portfolioApi: PortfolioApiService) { }

  ngOnInit(): void {
    this.portfolioApi.getEntries(1, 3, 'ASC', 'tittle').subscribe((data) => {
      this.pageResponse= data;
      this.results = data.results
      console.log("total elements")
      console.log(this.pageResponse.totalElements);
    });
    
  }
  onPageChanged(page: number): void{
    this.page=page
    this.portfolioApi.getEntries(page, 3, 'ASC', 'tittle').subscribe((data) => {
      this.pageResponse= data;
      this.results = data.results
      console.log("total elements")
      console.log(this.pageResponse.totalElements);
    });
  }
}
