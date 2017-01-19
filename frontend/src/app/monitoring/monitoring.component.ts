import { Component, Input, OnInit } from '@angular/core';
import { MonitoringComponentService } from './monitoring.component.service';
import { PingInfo } from './model/PingInfo';
import { Observable } from 'rxjs/Rx';

@Component({
    selector: 'my-monitoring',
    templateUrl: './monitoring.component.html',
    styleUrls: ['./monitoring.component.scss']
})
export class MonitoringComponent implements OnInit {
    public resultList : PingInfo[];

    constructor(private service: MonitoringComponentService) {

    }
    ngOnInit() {
        this.loadResultList();
    }

    loadResultList() {
        this.service.getResultList().subscribe(
                resultList => this.resultList = resultList, //Bind to view
                err => {
                // Log errors if any
                console.log(err);
            });
    }

}
