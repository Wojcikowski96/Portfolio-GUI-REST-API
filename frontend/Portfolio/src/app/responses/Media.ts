export class Media {
  id:number;  
  name: string;
  url: string;
  extensionType:string;
  
    constructor(name: string, url: string, id: number, extensionType: string) {
      this.name = name;
      this.url = url;
      this.id = id;
      this.extensionType = extensionType
    }
  }
  