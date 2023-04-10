import { Component, OnInit } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { NavigationExtras, Router } from '@angular/router';


@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss']
})
export class PortfolioComponent implements OnInit {
  pageResponse: PageResponse | undefined;
  results: Array<PortfolioEntry> | undefined;
  page: number | undefined;

  showGrid = true;


  constructor(private portfolioApi: PortfolioApiService, private router: Router) { }

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
  getDetails(item: any) {
    console.log("przekazane id")
    console.log(item)
    this.router.navigate(['/portfolioDetails', item]);
  }
  toggleGrid() {
    this.showGrid = !this.showGrid;
  }
}
