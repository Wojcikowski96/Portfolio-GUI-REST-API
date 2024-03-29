import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PortfolioPageResponse } from '../responses/PageResponse';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { NavigationExtras, Router } from '@angular/router';
import { GridService } from '../service/TransferService';
import { AuthService } from '../service/AuthService';
import * as moment from 'moment';
import { trigger, state, style, transition, animate, keyframes, query, stagger, animateChild } from '@angular/animations';


@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss'],
  animations: [
    trigger("inOutAnimation", [
      state("in", style({ opacity: 1 })),
  
      transition(":enter", [
        query(".tile", [
          style({ opacity: 0, transform: "translateX(-50%)" }),
          animate(
            "500ms",
            keyframes([
              style({ opacity: 0, transform: "translateX(-50%)", offset: 0 }),
              style({ opacity: 1, transform: "none", offset: 1 })
            ])
          ),
          stagger(300, animateChild())
        ])
      ]),
  
      transition(":leave", [
        animate(
          300,
          keyframes([
            style({ opacity: 1, offset: 0, width: "100%", height: "100%" }),
            style({ opacity: 0.75, offset: 0.25, width: "75%", height: "80%" }),
            style({ opacity: 0.5, offset: 0.5, width: "50%", height: "50%" }),
            style({ opacity: 0.25, offset: 0.75, width: "20%", height: "20%" }),
            style({ opacity: 0, offset: 1, width: "0px", height: "0%" })
          ])
        )
      ])
    ])
  ]
  
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
    }else{
      this.portfolioItemToPass = new PortfolioEntry()
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

  formatDate(date: string | undefined): string {
    moment.locale('pl')
    return moment(date).format('D MMMM YYYY');
  }

  getEntryById(id: number): PortfolioEntry | undefined {
    return this.results?.find(entry => entry.id === id);
    
  }
  removeEntryById(id: any){
    this.portfolioApi.deleteEntryById(id).subscribe((result) =>{
      if(this.results)
      this.results.forEach((element,index)=>{
        if(element.id==id) {
          if(this.results)
          this.results.splice(index, 1)
        };
     });
    })
  }

}
