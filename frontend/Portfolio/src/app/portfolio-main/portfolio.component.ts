import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PortfolioPageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { NavigationExtras, Router } from '@angular/router';
import { GridService } from '../service/TransferService';
import { AuthService } from '../service/AuthService';


@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss']
})
export class PortfolioComponent implements OnInit {
  pageResponse: PortfolioPageResponse | undefined;
  results: Array<PortfolioEntry> | undefined;
  page: number | undefined;

  showGrid = true;
  isAdmin = false

 
  tileSelected: any | undefined

  tittleToPass: string | undefined

  designedElementsToPass: string | undefined

  portfolioItemToPass : PortfolioEntry | undefined

  onTileSelected(id: any) {
    this.tileSelected = id;
    this.gridService.changeID(id);
    // this.tittleToPass = this.getTitleById(id);
    if(id){
      this.portfolioItemToPass = this.getEntryById(id)
    }
    

    if(this.portfolioItemToPass !==undefined){
      this.gridService.changePortfolioData(this.portfolioItemToPass);
    }
  }


  constructor(private portfolioApi: PortfolioApiService, private router: Router, private gridService: GridService, private authService: AuthService) { 
    this.gridService.showGrid$.subscribe(showGrid => {
      this.showGrid = showGrid;
    });
}

  ngOnInit(): void {
    this.portfolioApi.getEntries(1, 6, 'ASC', 'id').subscribe((data) => {
      this.pageResponse= data;
      this.results = data.results
      console.log("total elements")
      console.log(this.pageResponse.totalElements);
    });
    
  }
  checkIsAdmin(){
    if(this.authService.getRoles() && this.authService.getRoles().includes('ROLE_ADMIN')){
      return true
    }else {
      return false
    }
  }
  onPageChanged(page: number): void{
    this.page=page
    this.portfolioApi.getEntries(page, 6, 'ASC', 'id').subscribe((data) => {
      this.pageResponse= data;
      this.results = data.results
      console.log("total elements")
      console.log(this.pageResponse.totalElements);
    });
  }
  navigateToDetailsComponent(item: any) {
    console.log("przekazane id")
    console.log(item)
    this.router.navigate(['/portfolioDetails', item]);
  }

  navigateToNewDetailsComponent() {

    this.router.navigateByUrl('/portfolioDetailsNew');
  }
  toggleGrid() {
    this.gridService.toggleGrid();
  }

  onDetailsClosed(){
    console.log("On details closed")
    this.toggleGrid();
  }
  getTitleById(id: number): string | undefined {
    const entry = this.results?.find(entry => entry.id === id);
    return entry?.tittle;
  }

  getDesignedElementsById(id: number): string | undefined {
    const entry = this.results?.find(entry => entry.id === id);
    return entry?.designedElements;
  }
  
  getEntryById(id: number): PortfolioEntry | undefined {
    return this.results?.find(entry => entry.id === id);
    
  }
  removeEntryById(id: any){

  }

}
