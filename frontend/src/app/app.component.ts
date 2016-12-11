import { Component } from '@angular/core';

// external styles
import '../style/app.scss';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {

  private url:string = 'http://nortal.com';

  constructor() {

  }
}
