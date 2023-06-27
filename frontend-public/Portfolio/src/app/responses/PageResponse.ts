import { PortfolioEntry } from "./PortfolioEntry";
import { BlogEntry } from "./BlogEntry";
export class PortfolioPageResponse{
   constructor(public pageNo: number, public pageSize: number, public totalElements: number, public totalPages: number, public results: Array<PortfolioEntry>){};

}

export class BlogPageResponse{
   constructor(public pageNo: number, public pageSize: number, public totalElements: number, public totalPages: number, public results: Array<BlogEntry>){};

}