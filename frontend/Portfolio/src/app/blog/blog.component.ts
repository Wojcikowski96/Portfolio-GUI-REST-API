import { Component, OnInit, HostListener } from '@angular/core';
import { BlogEntry } from '../responses/BlogEntry';
import { BlogApiService } from '../service/blog-api-service';
import * as $ from 'jquery';
import { BlogPageResponse } from '../responses/PageResponse';
import { EmailApiService } from '../service/email-service';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {
  results: Array<BlogEntry> | undefined;
  pageResponse: BlogPageResponse | undefined
  page: number | undefined;

  name: string= ''
  email: string= ''
  tittle: string= ''
  content: string= ''



  constructor(private blogApiService: BlogApiService, private emailApiService:EmailApiService) {
    
   }

  ngOnInit(): void {
    this.blogApiService.getEntries(1, 3, 'DESC', 'creationDate').subscribe((data) => {
      this.results = data.results
      this.pageResponse = data
      console.log("results")
      console.log(this.results)
    });
  }
  onPageChanged(page: number): void{
    this.page=page
    this.blogApiService.getEntries(page, 3, 'ASC', 'creationDate').subscribe((data) => {
      this.pageResponse= data;
      this.results = data.results
      console.log("total elements")
      console.log(this.pageResponse.totalElements);
    });
  }
  sendMessage(){
    this.emailApiService.sendEmail(this.tittle, this.content, this.email, this.name).subscribe(response => {
      console.log(response);
    });
  }
  logMessage() {
    console.log('Wartość message:', this.content);
  }
  lastScrollTop = 0;
  isScrollingDown = false;

  @HostListener('window:scroll', ['$event'])
  onScroll(event: Event) {
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    if (scrollTop > this.lastScrollTop) {
      this.isScrollingDown = true;
    } else {
      this.isScrollingDown = false;
    }
    this.lastScrollTop = scrollTop;
    this.animateOnScroll();
  }

  animateOnScroll() {
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    if (scrollTop > 50 && this.isScrollingDown) {
      $('.about-us-wrapper').stop().animate({ height: '60px', opacity: '0' }, 200);
    } else if (scrollTop < 50 && !this.isScrollingDown) {
      $('.about-us-wrapper').stop().animate({ height: '600px', opacity: '1' }, 200);
    }
  }

}
