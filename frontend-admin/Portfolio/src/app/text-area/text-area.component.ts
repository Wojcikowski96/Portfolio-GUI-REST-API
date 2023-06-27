import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-text-area',
  templateUrl: './text-area.component.html',
  styleUrls: ['./text-area.component.scss']
})
export class TextAreaComponent implements OnInit {
  @Output() nameChange: EventEmitter<string> = new EventEmitter<string>();
  
  @Input()
  name: string | undefined;

  emitImageName() {
    console.log("emituje tekst")
    console.log(this.name)
    this.nameChange.emit(this.name);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
