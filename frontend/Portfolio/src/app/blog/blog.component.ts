import { Component, OnInit, HostListener } from '@angular/core';
import { BlogEntry } from '../responses/BlogEntry';
import { BlogApiService } from '../service/blog-api-service';
import * as $ from 'jquery';
import { BlogPageResponse } from '../responses/PageResponse';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {

  results: Array<BlogEntry> | undefined;


  constructor(private blogApiService: BlogApiService) {
    
   }

  ngOnInit(): void {
    this.blogApiService.getEntries(1, 3, 'ASC', 'id').subscribe((data) => {
      this.results = data.results
      console.log("total elements")
    });
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
