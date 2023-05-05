export class Media {
  id:number;  
  name: string;
  url: string;
  
    constructor(name: string, url: string, id: number) {
      this.name = name;
      this.url = url;
      this.id = id;
    }
  }
  