import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as L from 'leaflet';
import { LayerGroup } from 'leaflet';
import { MapService } from '../service/MapService';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {
  map: L.Map | undefined

  @Input()
  selectedDate: string |undefined;

  constructor(private http: HttpClient, private mapService: MapService) {}

  ngOnInit() {
    this.initMap();
    this.mapService.cityDataToPass$.subscribe(city=>{
      this.geocodeLocation(city);
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
        const result = response[0];
        const { lat, lon } = result;

        const coordinates = [lat, lon];

        if(this.map){
          this.map.setView([lat, lon], 5.2)
          L.marker([lat, lon]).addTo(this.map);
        }
      }
    });
  }
}
