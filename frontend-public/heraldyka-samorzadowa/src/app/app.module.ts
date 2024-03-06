import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { HttpClientModule } from "@angular/common/http";
import { PortfolioApiService } from "./Services/PortfolioApiService";
import { PaginationAlphabeticalComponent } from "./pagination-alphabetical/pagination-alphabetical.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
    declarations: [
      AppComponent,
      PaginationAlphabeticalComponent
      // inne deklaracje komponentów
    ],
    imports: [
      BrowserModule,
      HttpClientModule,
      BrowserAnimationsModule
      // inne importy modułów
    ],
    providers: [PortfolioApiService],
    bootstrap: [AppComponent]
  })
  export class AppModule { }