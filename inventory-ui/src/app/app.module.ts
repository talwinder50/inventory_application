import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AgGridModule} from 'ag-grid-angular/main';
import {ServerGridComponentComponent} from './server-grid-component/server-grid-component.component';
import {ApplicationGridComponent} from './application-grid/application-grid.component';
import {RouterModule, Routes} from '@angular/router';
import { MasterdetailMasterComponent } from './masterdetail-master/masterdetail-master.component';
import { DetailPanelComponent } from './detail-panel/detail-panel.component';

const appRoutes: Routes = [
  { path: 'applications', component: ApplicationGridComponent },
  { path: 'servers',      component: ServerGridComponentComponent },
  { path: 'applicationMaster', component: MasterdetailMasterComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    ServerGridComponentComponent,
    ApplicationGridComponent,
    MasterdetailMasterComponent,
    DetailPanelComponent,
  ],
  imports: [
    BrowserModule,
    AgGridModule.withComponents(
      [ServerGridComponentComponent,
        DetailPanelComponent
      ]
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
