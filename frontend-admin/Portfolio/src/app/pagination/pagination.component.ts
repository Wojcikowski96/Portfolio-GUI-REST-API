import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss']
})
export class PaginationComponent implements OnInit {
  @Input()
  itemsNum:number | undefined;

  @Input()
  pageSize:number | undefined;

  
  emptyArray: any[] | undefined;

  @Output() 
  pageChanged = new EventEmitter<any>();

  onPageChanged(page: number) {
    this.pageChanged.emit(page);
  }

  constructor() {
    this.emptyArray = [];
   }

   ngOnChanges() {
    console.log("total elements")
    console.log(this. itemsNum);

    console.log("page size")
    console.log(this. pageSize);
    const pagesResult = Math.ceil((this.itemsNum ?? 0) / (this.pageSize ?? 1));
    this.emptyArray = Array(pagesResult).fill(null);
  }

  ngOnInit(): void {
    console.log("total elements w inicie childa")
    console.log(this. itemsNum);
    const pagesResult = Math.ceil((this.itemsNum ?? 0) / (this.pageSize ?? 1));
    this.emptyArray = Array(pagesResult).fill(null);
  }

}
