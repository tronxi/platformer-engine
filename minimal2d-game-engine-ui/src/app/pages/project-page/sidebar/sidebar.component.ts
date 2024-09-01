import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {MatTab, MatTabGroup} from "@angular/material/tabs";
import {ProjectResources} from "../../../models/projectResources";
import {NgForOf} from "@angular/common";
import {Level} from "../../../models/level";
import {ElementClass} from "../../../models/elementclass";

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [MatTabGroup, MatTab, NgForOf],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent implements OnChanges {
  @Input() projectResources!: ProjectResources;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
    this.projectResources = changes['projectResources'].currentValue;
  }

  onClickLevel(level: Level) {
    console.log(level);
  }

  onClickElementClass(elementClass: ElementClass) {
    console.log(elementClass);
  }

}
