import { Component, OnInit, HostListener } from '@angular/core';
import { BlogEntry } from '../responses/BlogEntry';
import { BlogApiService } from '../service/blog-api-service';
import * as $ from 'jquery';
import { BlogPageResponse } from '../responses/PageResponse';
import { EmailApiService } from '../service/email-service';
import { AuthService } from '../service/AuthService';
import { BlogRequestBody } from '../utils/BlogRequestBody';
import { Location } from '@angular/common';


@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {
  results: Array<BlogEntry> | undefined;
  pageResponse: BlogPageResponse | undefined
  page: number | undefined;

  foundEntry: BlogRequestBody|undefined;

  name: string= ''
  email: string= ''
  tittle: string= ''
  message: string= ''

  tittleTextarea: string | undefined;
  contentTextarea: string | undefined;
  blogUrls: Array<string> | undefined;

  urlName: string | undefined;

  isEditClicked: boolean| undefined;

  constructor(private blogApiService: BlogApiService, private emailApiService:EmailApiService, private authService:AuthService) {
    
   }

  ngOnInit(): void {
    this.blogApiService.getEntries(1, 3, 'ASC', 'creationDate').subscribe((data) => {
      this.results = data.results
      this.pageResponse = data
      console.log("results")
      console.log(this.results)
      this.results.forEach((item) => {
        item.editable= false;
    });
    });
  }
  checkIsAdmin(){
    if(this.authService.getRoles() && this.authService.getRoles().includes('ROLE_ADMIN')){
      return true
    }else {
      return false
    }
  }
  addUrl(url: any){
    console.log("dodaję url")
    console.log(url)
    if(this.blogUrls)
    this.blogUrls.push(url)
    console.log(this.blogUrls)
  }
  onTittleChange(text: string){
    this.tittleTextarea = text
  }

  onContentChange(text: string){
    this.contentTextarea = text
  }

  onUrlChange(text: string){
    this.urlName = text
  }
  modifyEntry(item: any){
    if(this.foundEntry){
      this.foundEntry.tittle = this.tittleTextarea ?? ''
      this.foundEntry.content = this.contentTextarea ?? ''
      this.foundEntry.newsPortalsUrls = this.blogUrls ?? []
    }
    this.blogApiService.modifyEntry(this.foundEntry).subscribe(response=>{
      if(this.foundEntry)
      this.refreshEntryById(this.foundEntry.id)
      item.editable = false;
    })
   
  }

  addEmptyEntry(){
    const emptyEntryRequestBody = {
      content:'',
      tittle: '',
      newsPortalsUrls: []
    }
    console.log("CWEL")
    console.log(emptyEntryRequestBody)
    this.blogApiService.modifyEntry(emptyEntryRequestBody).subscribe(response=>{
     this.refreshPage()
    })
   
  }

  refreshPage(): void {
    location.reload();
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
  onImageDropped(files: FileList,  blogEntryId: any) {
    const file = files[0];
    const formData = new FormData();
    formData.append('fileByteString', file);
    console.log("wrzucam plik:")
    console.log(file)
    formData.append('type','IMAGE_BODY')
    this.blogApiService.uploadFileToPortfolio(blogEntryId, formData).subscribe(() => {
      console.log('Plik został przesłany na serwer.');
      this.refreshEntryById(blogEntryId)
    }, error => {
      if(error.status = 401){
        
      }
    });
  }
  setEditMode(item: any) {
    this.isEditClicked = !this.isEditClicked
    item.editable = !item.editable;
    const foundEntry: BlogEntry=this.getEntryById(item.id);
    const foundBlogRequestBody: BlogRequestBody = {
      id: foundEntry.id ?? 1,
      tittle: foundEntry.tittle ?? '',
      content: foundEntry.content ?? '',
      newsPortalsUrls: foundEntry.newsPortalsUrls ?? []
      
    };
    this.foundEntry = foundBlogRequestBody;
    this.tittleTextarea = this.foundEntry.tittle
    this.contentTextarea = this.foundEntry.content
    this.blogUrls = this.foundEntry.newsPortalsUrls
}
removeContainerByName(urlName: string){
  if(this.blogUrls)
  this.blogUrls = this.blogUrls.filter(item => item !== urlName);
}
  sendMessage(){
    console.log("wysyłam")
    this.emailApiService.sendEmail(this.tittle, this.message, this.email, this.name).subscribe(response => {
      console.log(response);
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
  getEntryById(id: number): BlogEntry {
    const foundEntry = this.results?.find(entry => entry.id === id);
    return foundEntry as BlogEntry;
  }

  refreshEntryById(id: number) {
    console.log("id")
    console.log(id)
    this.blogApiService.getEntry(id).subscribe(data => {
     if(this.results){
      const foundEntryIndex: number = this.results.findIndex(entry => entry.id === id);
      if (foundEntryIndex !== -1) {
        const foundEntryToRefresh: BlogEntry = this.results[foundEntryIndex];
        foundEntryToRefresh.tittle = data.tittle;
        foundEntryToRefresh.content = data.content;
        foundEntryToRefresh.newsPortalsUrls = data.newsPortalsUrls;
        foundEntryToRefresh.imageUrl = data.imageUrl;
      }
     }
     console.log("lista po refreshu")
     console.log(this.results)
    });
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
