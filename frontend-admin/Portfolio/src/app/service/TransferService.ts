import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { PortfolioEntry } from '../responses/PortfolioEntry';

@Injectable({
  providedIn: 'root'
})
export class GridService {
  private _showGrid = true;
  showGrid$ = new BehaviorSubject<boolean>(this._showGrid);

  private idData = new BehaviorSubject<number>(1);
  detailsId$ = this.idData.asObservable();

  private portfolioEntryData = new BehaviorSubject<PortfolioEntry>(new PortfolioEntry());

  arrayDataToPass$ = this.portfolioEntryData.asObservable()

  changeID(detailsId: number) {
    this.idData.next(detailsId)
  }


  changePortfolioData(portfolioEntry: PortfolioEntry) {
    this.portfolioEntryData.next(portfolioEntry)
  }
  

  toggleGrid(): void {
    this._showGrid = !this._showGrid;
    this.showGrid$.next(this._showGrid);
  }

  get showGrid(): boolean {
    return this._showGrid;
  }
}
