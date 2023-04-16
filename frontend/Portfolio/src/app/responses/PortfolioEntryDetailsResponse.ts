import { Media } from "./Media";
export class PortfolioEntryDetails {
  id: number;
  locationDetails: string;
  coatOfArmsDescription: string;
  imagesUrlsPageBody: Media[];
  symbolsDescription: string;
  history: string;
  imagesUrlsPageLeftPane: Media[];
  documents: Media[];

  constructor(
    id: number,
    locationDetails: string,
    coatOfArmsDescription: string,
    imagesUrlsPageBody: Media[],
    symbolsDescription: string,
    history: string,
    imagesUrlsPageLeftPane: Media[],
    documents: Media[],
  ) {
    this.id = id;
    this.locationDetails = locationDetails;
    this.coatOfArmsDescription = coatOfArmsDescription;
    this.imagesUrlsPageBody = imagesUrlsPageBody;
    this.symbolsDescription = symbolsDescription;
    this.history = history;
    this.imagesUrlsPageLeftPane = imagesUrlsPageLeftPane;
    this.documents = documents;
  }
}