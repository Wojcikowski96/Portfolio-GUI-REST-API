import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PortfolioPageResponse } from './Responses/PortfolioPageResponse';
import { PortfolioEntry } from './Responses/PortfolioEntry';
import { PortfolioApiService } from './Services/PortfolioApiService';
import { PaginationAlphabeticalComponent } from './pagination-alphabetical/pagination-alphabetical.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { animate, animateChild, keyframes, query, stagger, state, style, transition, trigger } from '@angular/animations';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
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

    ])
  ]
})
export class AppComponent {
  title = 'heraldyka-samorzadowa';

  tittle:any | undefined

  portfolioPageResponse:PortfolioPageResponse | undefined;

  results: Array<PortfolioEntry> | undefined
  pageResponse: PortfolioPageResponse | undefined;

  constructor(private portfolioApi: PortfolioApiService) { 

}

ngOnInit(): void {
  this.portfolioApi.getEntries(1, 6, 'ASC', 'id').subscribe((data) => {
    this.pageResponse= data;
    this.results = data.results
    console.log("total elements")
    console.log(this.pageResponse.totalElements);
  });
  
}

  onPageChanged(tittle: any): void{
    this.tittle=tittle
    this.portfolioApi.getEntries(1, 6, 'ASC', 'id', tittle).subscribe((data) => {
      this.portfolioPageResponse= data;
      this.results = data.results
    });
  }
}
