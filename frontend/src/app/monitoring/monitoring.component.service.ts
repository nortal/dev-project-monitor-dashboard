import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { PingInfo } from './model/PingInfo';
import { Observable } from 'rxjs/Rx';

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class MonitoringComponentService {

  // private instance variable to hold base url
  private url = '/api/ping';

  // Resolve HTTP using the constructor
  constructor (private http: Http) {}


  getResultList(): Observable<PingInfo[]> {
      return this.http.get(this.url)
          // ...and calling .json() on the response to return data
          .map((res:Response) => res.json())
          //...errors if any
          .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}