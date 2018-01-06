import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AgGridModule} from 'ag-grid-angular/main';
import {ServerGridComponentComponent} from './server-grid-component/server-grid-component.component';


@NgModule({
  declarations: [
    AppComponent,
    ServerGridComponentComponent
  ],
  imports: [
    BrowserModule,
    AgGridModule.withComponents(
      [ServerGridComponentComponent]
    ),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
