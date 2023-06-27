import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalizationSuggesterComponent } from './localization-suggester.component';

describe('LocalizationSuggesterComponent', () => {
  let component: LocalizationSuggesterComponent;
  let fixture: ComponentFixture<LocalizationSuggesterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LocalizationSuggesterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LocalizationSuggesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
