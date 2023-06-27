import { AfterViewInit, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as L from 'leaflet';
import { MapService } from '../service/MapService';
import { SearchResult } from '../utils/SearchResult';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements AfterViewInit {
  map: L.Map | undefined

  searchResults: Array<SearchResult> | undefined

  constructor(private http: HttpClient, private mapService: MapService) {}

  ngAfterViewInit() {
    console.log("inituję mapę")
    this.initMap()
    this.mapService.cityDataToPass$.subscribe(city=>{
      console.log("przekazane city")
      console
      this.geocodeLocation(city);
    })

    this.mapService.coordsDataToPass$.subscribe(coords=>{
      console.log("coordsy w mp")
      console.log(coords)
      this.setPin(coords)
    })
  }

  initMap() {
    this.map = L.map('map').setView([51.505, -0.09], 13);
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
      attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
      maxZoom: 18,
      id: 'mapbox/streets-v11',
      tileSize: 512,
      zoomOffset: -1,
      accessToken: 'pk.eyJ1Ijoid29qY2lrb3dza2kxIiwiYSI6ImNrcnhocXJpeDA3eGIydm1zbXFubjduOHIifQ.pm2jjfLo11_yQVODavHTmA'
  }).addTo(this.map);

  }

  geocodeLocation(location: string) {
    const geocodingUrl = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(
      location
    )}`;

    this.http.get(geocodingUrl).subscribe((response: any) => {
      if (response.length > 0) {
        console.log(response)
        this.searchResults = response;
        if(this.searchResults)
        this.mapService.changeSuggestedLocations(this.searchResults)
        
      }
    });
  }
  setPin(coords: SearchResult){
    if(this.map){
      this.map.setView([coords.lat, coords.lon], 5.2)
      L.marker([coords.lat, coords.lon]).addTo(this.map);
    }
  }
}
