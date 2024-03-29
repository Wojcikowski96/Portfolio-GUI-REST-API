import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GridService } from '../service/TransferService';
import { PortfolioApiService } from '../service/portfolio-api.service';
import { Media } from '../responses/Media';
import { Router } from '@angular/router';
import { AuthService } from '../service/AuthService';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { animate, keyframes, state, style, transition, trigger } from '@angular/animations';
import * as moment from 'moment';
import { MapService } from '../service/MapService';
import { SearchResult } from '../utils/SearchResult';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss'],
  animations: [
    trigger("inOutAnimation", [
      state("in", style({ opacity: 1 })),

      transition(":leave", [
        animate(
          300,
          keyframes([
            style({ opacity: 1, offset: 0, width: '100%', height:'100%' }),
            style({ opacity: 0.75, offset: 0.25, width: '75%', height:'80%' }),
            style({ opacity: 0.5, offset: 0.5, width: '50%', height:'50%'}),
            style({ opacity: 0.25, offset: 0.75, width: '20%', height:'20%' }),
            style({ opacity: 0, offset: 1,  width: '0px', height:'0%'  }),
          ])
        )
      ])
    ])
  ]
})

export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
  editFormVisible = false;

  

  height: number = 0;

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
    history: '',
    createdAt:'',
    cityForMap: '',
    longitude: 0,
    latitude: 0

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

  imageName: string | undefined;

  documentName: string | undefined

  portfolioEntry:PortfolioEntry | undefined;

  createdAt!: string | ''

  selectedDate: moment.Moment | '' = ""

  cityForMap!: string | '';

  coordinatesFromMapComponent: SearchResult| undefined;

  isDataLoaded: boolean = false

  onDetailsClosed() {
    this.detailsVisible = false;
    this.gridService.toggleGrid();
    console.log("pokazuję grid")
    this.router.navigateByUrl('/portfolio');
  }
  changeCity(city: string){
    this.mapService.changeCity(city)
  }

  constructor(private gridService: GridService, private porftolioApi: PortfolioApiService, private router: Router, private authService: AuthService, private mapService:MapService) {
    this.gridService.detailsId$.subscribe(detailsId => {
      this.detailsId = detailsId;
      console.log("Przekazałem id na kliknięcie: "+detailsId)
      
    });
    const images = document.querySelectorAll('img');
    let loadedCount = 0;
    
    const imageLoaded = () => {
      loadedCount++;

      if (loadedCount === images.length) {
        console.log("załadowaałem")
        this.isDataLoaded = true;
      }
    };

    images.forEach((image: HTMLImageElement) => {
      if (image.complete) {
        imageLoaded();
      } else {
        image.addEventListener('load', imageLoaded);
      }
    });

    this.gridService.arrayDataToPass$.subscribe(portfolioEntry => {
      this.imagesUrlsPageLeftPane = portfolioEntry.imagesUrlsPageLeftPane

      this.imagesUrlsPageBody = portfolioEntry.imagesUrlsPageBody

      this.documents = portfolioEntry.documents

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
      if (portfolioEntry.createdAt!== undefined) {
        moment.locale('pl')
        this.createdAt = portfolioEntry.createdAt
        this.convertToMoment(this.createdAt)
        
      }
  
      if(portfolioEntry.longitude !==undefined && portfolioEntry.latitude !==undefined){
        this.coordinatesFromMapComponent = {lon: 0, lat: 0, display_name: ''}
        
        if(this.coordinatesFromMapComponent){
          this.coordinatesFromMapComponent.lon = portfolioEntry.longitude;
          this.coordinatesFromMapComponent.lat  = portfolioEntry.latitude;
          this.mapService.changeCoords(this.coordinatesFromMapComponent)
          console.log("coordsy po przekazaniu do details")
          console.log(this.coordinatesFromMapComponent)
        }
      }

    });
  }

  convertToLocalDatetimeString(date: string): string {
    console.log("Data do konwersji:");
    console.log(date);
  
    const convertedDate = moment(date); 
    console.log("to co zwracam")
    console.log(convertedDate.isValid() ? convertedDate.format('YYYY-MM-DD HH:mm:ss') : '')
    return convertedDate.isValid() ? convertedDate.format('YYYY-MM-DD HH:mm:ss') : '';
  }

  checkIsAdmin(){
    if(this.authService.getRoles() && this.authService.getRoles().includes('ROLE_ADMIN')){
      return true
    }else {
      return false
    }
  }
  setEditable(){
    this.height = 300;
    this.editFormVisible = !this.editFormVisible
  }

  ngOnInit(): void {
    this.detailsVisible = true;
    console.log("Lista obrazków")
    console.log(this.imagesUrlsPageBody)

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
    this.data.createdAt = this.convertToLocalDatetimeString(this.createdAt)
    this.convertToMoment(this.createdAt)
    this.data.cityForMap = this.cityForMap
    this.data.longitude = this.coordinatesFromMapComponent ? this.coordinatesFromMapComponent.lon: 0;
    this.data.latitude = this.coordinatesFromMapComponent ? this.coordinatesFromMapComponent.lat: 0;

    if(this.selectedDate !== undefined && moment.isMoment(this.selectedDate) && this.selectedDate.isValid()){
      console.log("dane do zapisu w details")
      console.log(this.data)
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
    }else{
      alert("Data uchwalenia nie może być pusta")
      this.editFormVisible = true
    }

  }

  onImageNameChange(text: string){
    this.imageName = text
  }
  onCoatsOfArmsDescriptionChange(text: string){
    this.coatOfArmsDescription = text
  }

  onLocationDetailsChange(text: string){
    this.locationDetails= text
  }
  onSymbolsDescriptionChange(text: string){
    this.symbolsDescription = text
  }
  onDocumentNameChange(text: string){
    this.documentName = text
  }
  onDesignedElementsChange(text: string){
    this.designedElements = text
  }
  onWojewodztwoChange(text: string){
    this.wojewodztwo = text
  }
  
  onPowiatChange(text: string){
    this.powiat = text
  }

  onImageDropped(files: FileList, fileName: string) {
    const file = files[0];
    const formData = new FormData();
    formData.append('fileByteString', file);
    console.log("wrzucam plik:")
    console.log(file)
    formData.append('name',fileName)
    formData.append('type','IMAGE_LEFT_PANE')
    this.porftolioApi.uploadFileToPortfolio(this.detailsId, formData).subscribe(() => {
      console.log('Plik został przesłany na serwer.');
      this.refresh();
    }, error => {
      if(error.status = 401){
        this.router.navigateByUrl('login')
      }
    });
  }
  
  setDate(date:string){
    this.createdAt = date
    console.log("created at wyemitowane")
    console.log(this.createdAt)

  }

  setCoordinatesFromMap(coords: SearchResult){
    this.coordinatesFromMapComponent = coords;
    console.log("przekazane coordsy z komponentu to")
    this.autoFillLocationDetails(this.coordinatesFromMapComponent)
  

  }
  autoFillLocationDetails(searchResult: SearchResult){
    const parts = searchResult.display_name.split(',');
    parts.forEach((part) => {
      if(part.includes("województwo")){
        this.wojewodztwo = part
      }
      if(part.includes("powiat")){
        this.powiat = part
      }
    });
    
  }

  onImageDroppedImageBody(files: FileList) {
    const file = files[0];
    const formData = new FormData();
    formData.append('fileByteString', file);
    console.log(file)

    if(this.imageName){
      formData.append('name',this.imageName)
      formData.append('type','IMAGE_BODY')
      this.porftolioApi.uploadFileToPortfolio(this.detailsId, formData).subscribe(() => {
        console.log('Plik został przesłany na serwer.');
        this.refresh();
      }, error => {
        if(error.status = 401){
          this.router.navigateByUrl('login')
        }
      });
    }else{
      alert("Aby wrzucić obrazek, musisz podać jego nazwę")
    }
  }
  convertToMoment(dateString: string) {
    const format = 'YYYY-MM-DD HH:mm:ss';
    this.selectedDate = moment(dateString, format);
    console.log(this.selectedDate)
  }

  onDocumentDropped(files: FileList) {
    const file = files[0];
    const formData = new FormData();
    formData.append('fileByteString', file);

    if (file.type.startsWith('image/')) {
      formData.append('extensionType', 'IMAGE')
      console.log("obraz")
    } else if (file.type === 'application/pdf') {
      formData.append('extensionType', 'PDF')
      console.log("pdf")
    } else {
      alert('Nieobsługiwany typ pliku')
    }

    if(this.documentName){
      formData.append('name',this.documentName)
      formData.append('type','DOCUMENT')

      console.log("form data")
      console.log(formData.get("extensionType"))
      this.porftolioApi.uploadFileToPortfolio(this.detailsId, formData).subscribe(() => {
        console.log('Plik został przesłany na serwer.');
        this.refresh();
      }, error => {
        if(error.status = 401){
          this.router.navigateByUrl('login')
        }
      });
    }else{
      alert("Aby wrzucić plik, musisz podać jego nazwę")
    }
  }

  refresh(){
    this.porftolioApi.getEntries(1, 6, 'ASC', 'id').subscribe((data) => {
      this.results = data.results
      let portfolio = this.getEntryById(this.detailsId);
      this.imagesUrlsPageBody = portfolio?.imagesUrlsPageBody
      this.imagesUrlsPageLeftPane = portfolio?.imagesUrlsPageLeftPane
      this.documents = portfolio?.documents
      console.log(this.results)
    });

  }
  removeFileById(id: number){
    alert('Nastąpi usunięcie obrazka, kliknik OK aby kontynuować')
    this.porftolioApi.deleteImageById(id).subscribe((response)=>{
      if(this.imagesUrlsPageBody && this.documents){
        this.imagesUrlsPageBody.forEach((element,index)=>{
          if(element.id==id) {
            if(this.imagesUrlsPageBody)
            this.imagesUrlsPageBody.splice(index, 1)
          };
       });
       this.documents.forEach((element,index)=>{
        if(element.id==id) {
          if(this.documents)
          this.documents.splice(index, 1)
        };
     });
      }
    })
  }

  getEntryById(id: number): PortfolioEntry | undefined {
    return this.results?.find(entry => entry.id === id);
    
  }
  downloadFile(documentUrl:string, type: string) {
  this.porftolioApi.downloadFile(documentUrl, type)
}


}