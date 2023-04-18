import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PortfolioComponent } from './portfolio-main/portfolio.component';
import { PaginationComponent } from './pagination/pagination.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { RouterModule, Routes } from '@angular/router';
import { BlogComponent } from './blog/blog.component';

const routes: Routes = [
  { path: '', redirectTo: '/portfolio', pathMatch: 'full' },
  { path: 'portfolio', component: PortfolioComponent },
  {path: 'blog', component: BlogComponent},
  { path: 'portfolioDetails/:id', component: PortfolioDetailsComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PortfolioComponent,
    PaginationComponent,
    PortfolioDetailsComponent,
    BlogComponent,
    
    

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      routes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]

  
})
export class AppModule { }
