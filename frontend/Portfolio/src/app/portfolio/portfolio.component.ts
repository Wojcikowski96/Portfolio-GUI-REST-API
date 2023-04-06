import { Component, OnInit } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss']
})
export class PortfolioComponent implements OnInit {
  page: PageResponse | undefined;
  results: Array<PortfolioEntry> | undefined

  constructor(private portfolioApi: PortfolioApiService) { }

  ngOnInit(): void {
    this.portfolioApi.getEntries(1, 50, 'ASC', 'tittle').subscribe((data) => {
      this.page= data;
      this.results = data.results
      console.log(this.results);
    });
    
  }
}
