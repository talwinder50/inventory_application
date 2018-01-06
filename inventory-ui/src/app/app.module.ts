import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AgGridModule} from 'ag-grid-angular/main';
import {ServerGridComponentComponent} from './server-grid-component/server-grid-component.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {ApplicationGridComponent} from './application-grid/application-grid.component';
import {RouterModule, Routes} from '@angular/router';
import { ServerStatusComponent } from './server-status/server-status.component';

const appRoutes: Routes = [
  { path: 'applications', component: ApplicationGridComponent },
  { path: 'servers',      component: ServerGridComponentComponent },
];
@NgModule({
  declarations: [
    AppComponent,
    ServerGridComponentComponent,
    DashboardComponent,
    ApplicationGridComponent,
    ServerStatusComponent
  ],
  imports: [
    BrowserModule,
    AgGridModule.withComponents(
      [ServerGridComponentComponent]
    ),
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
