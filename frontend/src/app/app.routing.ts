import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { MonitoringComponent } from './monitoring/monitoring.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { ScheduleComponent } from './schedule/schedule.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'monitoring', component: MonitoringComponent},
  { path: 'notifications', component: NotificationsComponent},
  { path: 'schedule', component: ScheduleComponent}
];

export const routing = RouterModule.forRoot(routes);
