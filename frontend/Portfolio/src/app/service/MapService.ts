import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { PortfolioEntry } from '../responses/PortfolioEntry';

@Injectable({
  providedIn: 'root'
})
export class MapService {

  private locationData = new BehaviorSubject<string>('')

  private portfolioEntryData = new BehaviorSubject<PortfolioEntry>(new PortfolioEntry());

  cityDataToPass$ = this.locationData.asObservable()

  changeCity(cityDataToPass: string) {
    this.locationData.next(cityDataToPass)
  }

}