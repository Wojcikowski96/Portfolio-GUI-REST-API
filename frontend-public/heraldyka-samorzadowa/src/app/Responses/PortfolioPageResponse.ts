import { PortfolioEntry } from "./PortfolioEntry";

export interface PortfolioPageResponse {
    pageNo: number;
    pageSize: number;
    totalElements: number;
    totalPages: number;
    results: Array<PortfolioEntry>;
}
