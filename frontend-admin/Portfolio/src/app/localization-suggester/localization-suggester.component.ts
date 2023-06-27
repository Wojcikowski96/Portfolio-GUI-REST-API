import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MapService } from '../service/MapService';
import { SearchResult } from '../utils/SearchResult';

@Component({
  selector: 'app-localization-suggester',
  templateUrl: './localization-suggester.component.html',
  styleUrls: ['./localization-suggester.component.scss']
})
export class LocalizationSuggesterComponent implements OnInit {

  searchResults: Array<SearchResult> | undefined

  selectedResult: SearchResult | undefined

  @Output() selectedOption = new EventEmitter<SearchResult>()

  constructor(private mapService: MapService) { }

  ngOnInit(): void {
    this.mapService.searchResults$.subscribe(results =>{
      this.searchResults = results;
    })
  }
  onSelect(item: SearchResult = {} as SearchResult){
    this.selectedOption.emit(item)
    this.mapService.changeCoords(item)
  }
  onBlur(){
    console.log("on blur działa")
    console.log(this.selectedResult)
    if(this.selectedResult)
    this.onSelect(this.selectedResult);
  }

}
