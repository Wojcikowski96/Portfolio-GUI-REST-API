import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { NavigationExtras, Router } from '@angular/router';
import { GridService } from '../service/TransferService';


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

 
  tileSelected: any | undefined

  onTileSelected(id:any){
    this.tileSelected=id;
    this.gridService.changeData(id)
  }


  constructor(private portfolioApi: PortfolioApiService, private router: Router, private gridService: GridService) { 
    this.gridService.showGrid$.subscribe(showGrid => {
      this.showGrid = showGrid;
    });
}

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
    this.gridService.toggleGrid();
  }

  onDetailsClosed(){
    console.log("On details closed")
    this.toggleGrid();
  }

}
