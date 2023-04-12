import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GridService } from '../service/TransferService';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PortfolioEntryDetails } from '../responses/PortfolioEntryDetailsResponse';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss']
})
export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
 
  @Input()
  detailsId:any | undefined;

  portfolioDetails: PortfolioEntryDetails | undefined;

  onDetailsClosed() {
    this.detailsVisible = false;
    this.gridService.toggleGrid();
    console.log("pokazuję grid")
  }

  constructor(private gridService: GridService, private porftolioApi: PortfolioApiService) {
    this.gridService.detailsId$.subscribe(detailsId => {
      this.detailsId = detailsId;
      console.log("Przekazałem id na kliknięcie: "+detailsId)
      this.porftolioApi.getEntryDetails(detailsId).subscribe((data) => {
        this.portfolioDetails = data;
        console.log("klasa detailsowa")
        console.log(this.portfolioDetails)
      });
    });
  }

  ngOnInit(): void {
    this.detailsVisible = true;

  }

}
