import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { PortfolioEntry } from '../responses/PortfolioEntry';
import { Coordinates } from '../utils/Coordinates';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  private locationName = new BehaviorSubject<string>('')

  private locationCoordsFromRest = new BehaviorSubject<Coordinates>({ lon: 0, lat: 0 });

  cityDataToPass$ = this.locationName.asObservable()

  coordsDataToPass$ = this.locationCoordsFromRest.asObservable()

  changeCity(cityDataToPass: string) {
    this.locationName.next(cityDataToPass)
  }

  changeCoords(coordsDataToPass: Coordinates){
    this.locationCoordsFromRest.next(coordsDataToPass)
  }

}