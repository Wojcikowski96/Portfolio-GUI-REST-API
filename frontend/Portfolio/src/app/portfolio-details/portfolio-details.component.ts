import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { GridService } from '../service/GridService';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.scss']
})
export class PortfolioDetailsComponent implements OnInit {
  detailsVisible = true;
 

  onDetailsClosed() {
    this.detailsVisible = false;
    this.gridService.toggleGrid();
    console.log("pokazuję grid")
  }

  constructor(private gridService: GridService) {}

  ngOnInit(): void {
    this.detailsVisible = true;
  }

}
