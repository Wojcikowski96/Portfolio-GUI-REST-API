import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GridService } from '../service/TransferService';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { PortfolioEntryDetails } from '../responses/PortfolioEntryDetailsResponse';
import { Media } from '../responses/Media';
import { Router } from '@angular/router';
import { AuthService } from '../service/AuthService';
import { PortfolioEntry } from '../responses/PortfolioEntry';
@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss']
})
export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
  editFormVisible = false;

  data = {
    id:0,
    tittle: '',
    designedElements: '',
    wojewodztwo: '',
    powiat: '',
    locationDetails: '',
    coatOfArmsDescription: '',
    symbolsDescription: '',
    history: ''
  };
 
  
  detailsId:any | undefined;

  locationName: string | undefined;

  designedElements: string | undefined;

  powiat: string | undefined;

  wojewodztwo: string | undefined;

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

  constructor(private gridService: GridService, private porftolioApi: PortfolioApiService, private router: Router, private authService: AuthService) {
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

    this.gridService.arrayDataToPass$.subscribe(portfolioEntry => {
      this.locationName = portfolioEntry.tittle;
      console.log("location name:")
      console.log(this.locationName)

      console.log("entry tittle:")
      console.log(portfolioEntry.tittle)

      this.designedElements = portfolioEntry.designedElements
      this.wojewodztwo = portfolioEntry.wojewodztwo
      this.powiat = portfolioEntry.powiat
  
    });



  }

  checkIsAdmin(){
    if(this.authService.getRoles() && this.authService.getRoles().includes('ROLE_ADMIN')){
      return true
    }else {
      return false
    }
  }
  setEditable(){
    this.editFormVisible = !this.editFormVisible
  }

  ngOnInit(): void {
    this.detailsVisible = true;

  }

  modifyEntry() {
    this.data.id=this.detailsId;
    console.log("this.locationName")
    console.log(this.locationName)
    if(this.locationName){
      this.data.tittle = this.locationName
    }
    if(this.designedElements){
      this.data.designedElements = this.designedElements;
    }
    if (this.powiat) {
      this.data.powiat = this.powiat;
    }
    if (this.wojewodztwo) {
      this.data.wojewodztwo = this.wojewodztwo;
    }
    if(this.portfolioDetails){
      this.data.locationDetails = this.portfolioDetails.locationDetails
      this.data.coatOfArmsDescription = this.portfolioDetails.coatOfArmsDescription
      this.data.symbolsDescription = this.portfolioDetails.symbolsDescription
      this.data.history = this.portfolioDetails.history
    }
    console.log("data do zapisu")
    console.log(this.data)
    this.porftolioApi.modifyEntry(this.data).subscribe(response => {
      console.log(response);
    });
  }

}
