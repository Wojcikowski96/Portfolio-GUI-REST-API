import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GridService } from '../service/TransferService';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { Media } from '../responses/Media';
import { Router } from '@angular/router';
import { AuthService } from '../service/AuthService';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss']
})

export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
  editFormVisible = false;
  imageName!: string | '';

  results: Array<PortfolioEntry> | undefined;

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
  
  divKeyValues = [
    { id: 'Herb', name: 'sidebarheader' },
    { id: 'Flaga', name: 'flag-wrapper' },
    { id: 'Pieczęć', name: 'pieczecie-row2' },
    { id: 'Banner', name: 'banner-wrapper' },
  
  ];
  
  detailsId:any | undefined;

  locationName!: string | '';

  designedElements!: string | '';

  powiat!: string | '';

  wojewodztwo!: string | '';

  locationDetails!: string | '';

  coatOfArmsDescription!:string| '';

  symbolsDescription!:string| '';

  history!:string| '';

  portfolioDetails: PortfolioEntry | undefined;

  imagesUrlsPageLeftPane:Media[] | undefined
  imagesUrlsPageBody:Media[] | undefined
  documents:Media[] | undefined

  portfolioEntry:PortfolioEntry | undefined;

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
      if(detailsId==undefined){

      }
      
    });

    this.gridService.arrayDataToPass$.subscribe(portfolioEntry => {
      this.imagesUrlsPageLeftPane = portfolioEntry.imagesUrlsPageLeftPane

      this.imagesUrlsPageBody = portfolioEntry.imagesUrlsPageBody

      if (portfolioEntry.tittle !== undefined) {
        this.locationName = portfolioEntry.tittle;
      }
      if (portfolioEntry.designedElements !== undefined) {
        this.designedElements = portfolioEntry.designedElements;
      }
      if (portfolioEntry.powiat !== undefined) {
        this.powiat = portfolioEntry.powiat;
      }
      if (portfolioEntry.wojewodztwo !== undefined) {
        this.wojewodztwo = portfolioEntry.wojewodztwo;
      }
      if (portfolioEntry.locationDetails !== undefined) {
        this.locationDetails = portfolioEntry.locationDetails;
      }
      if (portfolioEntry.locationDetails !== undefined) {
        this.locationDetails = portfolioEntry.locationDetails;
      }
      if (portfolioEntry.coatOfArmsDescription !== undefined) {
        this.coatOfArmsDescription = portfolioEntry.coatOfArmsDescription;
      }
      if (portfolioEntry.symbolsDescription !== undefined) {
        this.symbolsDescription = portfolioEntry.symbolsDescription;
      }
      if (portfolioEntry.history !== undefined) {
        this.history = portfolioEntry.history;
      }
  
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
    this.data.tittle = this.locationName
    this.data.designedElements = this.designedElements;
    this.data.powiat = this.powiat;
    this.data.wojewodztwo = this.wojewodztwo;
    this.data.locationDetails = this.locationDetails
    this.data.coatOfArmsDescription = this.coatOfArmsDescription
    this.data.symbolsDescription = this.symbolsDescription
    this.data.history = this.history

    this.porftolioApi.modifyEntry(this.data) .pipe(
      catchError((error) => {

        if (error.status === 401) {
          this.router.navigateByUrl('login')
        }
        return throwError(error);
      })
    )
    .subscribe(response => {
      console.log(response);
    });
  }

  onFilesDropped(files: FileList, fileName: string) {
    const file = files[0];
    const formData = new FormData();
    formData.append('fileByteString', file);
    console.log("wrzucam plik:")
    console.log(file)
    formData.append('name',fileName)
    formData.append('type','IMAGE_LEFT_PANE')
    this.porftolioApi.uploadImageToPortfolio(this.detailsId, formData).subscribe(() => {
      console.log('Plik został przesłany na serwer.');
      this.refreshImages();
    }, error => {
      if(error.status = 401){
        this.router.navigateByUrl('login')
      }
    });
  }

  refreshImages(){
    this.porftolioApi.getEntries(1, 6, 'ASC', 'id').subscribe((data) => {
      this.results = data.results
      let portfolio = this.getEntryById(this.detailsId);
      this.imagesUrlsPageBody = portfolio?.imagesUrlsPageBody
      this.imagesUrlsPageLeftPane = portfolio?.imagesUrlsPageLeftPane
      console.log(this.results)
    });

  }

  getEntryById(id: number): PortfolioEntry | undefined {
    return this.results?.find(entry => entry.id === id);
    
  }

}
