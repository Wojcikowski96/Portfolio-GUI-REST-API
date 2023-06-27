import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-drag-and-drop-image',
  templateUrl: './drag-and-drop-image.component.html',
  styleUrls: ['./drag-and-drop-image.component.scss']
})
export class DragAndDropImageComponent implements OnInit {

  constructor() { }
  @Output() filesDropped: EventEmitter<any> = new EventEmitter<any>();

  ngOnInit(): void {
  }
  emitFile(event:any){{
    console.log("emituję")
    console.log(event)
    this.filesDropped.emit(event)
  }

  }

}
