import { PortfolioEntry } from "./PortfolioEntry";
export class PageResponse{
   constructor(public pageNo: number, public pageSize: number, public totalElements: number, public totalPages: number, public results: Array<PortfolioEntry>){};

}