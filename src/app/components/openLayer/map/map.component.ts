import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { defaults as defaultControls } from 'ol/control';

import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import XYZ from 'ol/source/XYZ';
import ZoomToExtent from 'ol/control/ZoomToExtent';
import layer from 'ol/layer';
import GeoJSON from 'ol/format/GeoJSON';
import VectorImage from 'ol/layer/Vector';
import Vector from 'ol/source/vector';
 import {Fill, Stroke, Circle, Style} from 'ol/style';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})


export class MapComponent implements AfterViewInit {

  map: Map;
  @Input()
  public latitude:number;
  visible: boolean = true;
  @Output() open: EventEmitter<any> = new EventEmitter();
  @Output() close: EventEmitter<any> = new EventEmitter();


  ngAfterViewInit() {
    console.log(this.latitude);
    this.map = new Map({
      target: 'map',
      view: new View({
        center: this.latitude,
        zoom: 7
      }),
      controls: defaultControls().extend([
        new ZoomToExtent({
          extent: [
            813079.7791264898, 5929220.284081122,
            848966.9639063801, 5936863.986909639
          ]
        })
      ])
    });

  const EUCountriesGeoJSON = new VectorImage({
    source: new Vector({
      url: 'data/map.topojson',
      format: new GeoJSON()
    }),
    visible: true,
    title: 'EUCountriesGeoJSON',
    style: new Style({
    fill: new Fill({
      color: 'blue'
    }),
    stroke: new Stroke({
      color: 'olive',
      width: 1
    })

  })

  })
   this.map.addLayer(EUCountriesGeoJSON);

}
    toggle() {
    this.visible = !this.visible;
    console.log(this.visible)
    if (this.visible) {
      this.open.emit(null);
    } else {
      this.close.emit(null);
      }
    }

    
}