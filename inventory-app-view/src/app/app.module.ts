import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { InfoComponent } from './info/info.component';
import { InfoservicesService } from './services/infoservices.service';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [InfoservicesService],
  // providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
