import { Component, OnInit, HostListener } from '@angular/core';
import * as $ from 'jquery';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
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
