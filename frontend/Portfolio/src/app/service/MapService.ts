import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { SearchResult } from '../utils/SearchResult';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  private locationName = new BehaviorSubject<string>('')

  private locationCoordsFromRest = new BehaviorSubject<SearchResult>({ lon: 0, lat: 0, display_name: ''});

  private searchResults = new BehaviorSubject<Array<SearchResult>>([
    { lon: 0, lat: 0, display_name: '' }
  ]);

  cityDataToPass$ = this.locationName.asObservable()

  coordsDataToPass$ = this.locationCoordsFromRest.asObservable()

  searchResults$ = this.searchResults.asObservable()

  changeCity(cityDataToPass: string) {
    this.locationName.next(cityDataToPass)
  }

  changeCoords(coordsDataToPass: SearchResult){
    this.locationCoordsFromRest.next(coordsDataToPass)
  }
  changeSuggestedLocations(searchResults: Array<SearchResult>){
    this.searchResults.next(searchResults)
  }

}