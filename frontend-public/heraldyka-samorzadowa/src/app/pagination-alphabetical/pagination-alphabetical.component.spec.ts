import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginationAlphabeticalComponent } from './pagination-alphabetical.component';

describe('PaginationAlphabeticalComponent', () => {
  let component: PaginationAlphabeticalComponent;
  let fixture: ComponentFixture<PaginationAlphabeticalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaginationAlphabeticalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaginationAlphabeticalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
