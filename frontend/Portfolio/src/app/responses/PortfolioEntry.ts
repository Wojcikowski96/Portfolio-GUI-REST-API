import { Media } from "./Media";
export class PortfolioEntry{
    id: number | undefined;
    tittle: string | undefined;
    modificationDate: string| undefined;;
    creationDate: string| undefined;;
    designedElements: string| undefined;;
    imageUrl: string| undefined;;
    wojewodztwo: string| undefined;;
    powiat: string| undefined;;
    locationDetails: string | undefined;
    coatOfArmsDescription: string | undefined;
    imagesUrlsPageBody: Media[] | undefined;
    symbolsDescription: string | undefined;
    history: string | undefined;
    createdAt: string | undefined;
    cityForMap: string | undefined;
    imagesUrlsPageLeftPane: Media[] | undefined;
    documents: Media[] | undefined;
}