import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GridService } from '../service/TransferService';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PortfolioEntryDetails } from '../responses/PortfolioEntryDetailsResponse';
import { Media } from '../responses/Media';
import { Router } from '@angular/router';
@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss']
})
export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
 
  @Input()
  detailsId:any | undefined;

  @Input()
  locationName: string | undefined;

  portfolioDetails: PortfolioEntryDetails | undefined;
  imagesUrlsPageLeftPane:Media[] | undefined
  imagesUrlsPageBody:Media[] | undefined
  documents:Media[] | undefined

  onDetailsClosed() {
    this.detailsVisible = false;
    this.gridService.toggleGrid();
    console.log("pokazuję grid")
    this.router.navigateByUrl('/portfolio');
  }

  constructor(private gridService: GridService, private porftolioApi: PortfolioApiService, private router: Router) {
    this.gridService.detailsId$.subscribe(detailsId => {
      this.detailsId = detailsId;
      console.log("Przekazałem id na kliknięcie: "+detailsId)
      this.porftolioApi.getEntryDetails(detailsId).subscribe((data) => {
        this.portfolioDetails = data;
        this.imagesUrlsPageLeftPane = data.imagesUrlsPageLeftPane
        this.imagesUrlsPageBody = data.imagesUrlsPageBody
        this.documents = data.documents
        console.log("klasa detailsowa")
        console.log(this.portfolioDetails)
      });
    });

    this.gridService.locationName$.subscribe(locationName => {
      this.locationName = locationName;
    });
  }

  ngOnInit(): void {
    this.detailsVisible = true;

  }

}
