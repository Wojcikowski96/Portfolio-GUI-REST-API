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

  changeData(detailsId: number) {
    this.data.next(detailsId)
  }
  

  toggleGrid(): void {
    this._showGrid = !this._showGrid;
    this.showGrid$.next(this._showGrid);
  }

  get showGrid(): boolean {
    return this._showGrid;
  }
}
