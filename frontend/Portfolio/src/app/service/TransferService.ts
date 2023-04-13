import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GridService {
  private _showGrid = true;
  showGrid$ = new BehaviorSubject<boolean>(this._showGrid);

  private data = new BehaviorSubject<number>(1);
  detailsId$ = this.data.asObservable();

  private data2 = new BehaviorSubject<string>("");
  locationName$ = this.data2.asObservable();

  changeData(detailsId: number) {
    this.data.next(detailsId)
  }

  changeData2(locationName: string) {
    this.data2.next(locationName)
  }
  

  toggleGrid(): void {
    this._showGrid = !this._showGrid;
    this.showGrid$.next(this._showGrid);
  }

  get showGrid(): boolean {
    return this._showGrid;
  }
}
