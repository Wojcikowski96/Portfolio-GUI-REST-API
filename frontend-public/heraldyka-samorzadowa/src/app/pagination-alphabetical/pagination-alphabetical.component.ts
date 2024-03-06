import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-pagination-alphabetical',
  templateUrl: './pagination-alphabetical.component.html',
  styleUrl: './pagination-alphabetical.component.css'
})
export class PaginationAlphabeticalComponent {

  emptyArray: any[] | undefined;

  @Output() 
  pageChanged = new EventEmitter<any>();

  onPageChanged(page: any) {
    this.pageChanged.emit(page);
  }

  ngOnInit(): void {
    this.emptyArray = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
  }
}
