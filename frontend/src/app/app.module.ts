import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {DashboardComponent} from './dashboard/dashboard.component';

import {MonitoringComponent} from './monitoring/monitoring.component';
import {MonitoringComponentService} from './monitoring/monitoring.component.service';

import {NotificationsComponent} from './notifications/notifications.component';
import {ScheduleComponent} from './schedule/schedule.component';
import {ApiService} from './shared';
import {routing} from './app.routing';


@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        routing
    ],
    declarations: [
        AppComponent,
        DashboardComponent,
        MonitoringComponent,
        NotificationsComponent,
        ScheduleComponent
    ],
    providers: [
        ApiService,
        MonitoringComponentService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor() {
    }
}
