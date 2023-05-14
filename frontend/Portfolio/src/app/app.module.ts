import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PortfolioComponent } from './portfolio-main/portfolio.component';
import { PaginationComponent } from './pagination/pagination.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { RouterModule, Routes } from '@angular/router';
import { BlogComponent } from './blog/blog.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { DragAndDropDirective } from './drag-and-drop/DragAndDrop';
import { DatepickerComponent } from './datepicker/datepicker.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MaterialExampleModule } from 'src/material-module';
import {MAT_DATE_LOCALE } from '@angular/material/core';

const routes: Routes = [
  { path: '', redirectTo: '/portfolio', pathMatch: 'full' },
  { path: 'portfolio', component: PortfolioComponent },
  {path: 'blog', component: BlogComponent},
  { path: 'portfolioDetails/:id', component: PortfolioDetailsComponent },
  { path: 'portfolioDetailsNew', component: PortfolioDetailsComponent },
  { path: 'login', component: LoginFormComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PortfolioComponent,
    PaginationComponent,
    PortfolioDetailsComponent,
    BlogComponent,
    LoginFormComponent,
    DragAndDropDirective,
    DatepickerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatIconModule,
    MaterialExampleModule,
    RouterModule.forRoot(
      routes
    )
  ],
  providers: [{ provide: MAT_DATE_LOCALE, useValue: 'pl' }],
  bootstrap: [AppComponent]

  
})
export class AppModule { }
