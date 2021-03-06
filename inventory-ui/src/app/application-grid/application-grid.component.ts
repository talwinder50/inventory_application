import {Component, OnInit} from '@angular/core';
import {GridOptions} from 'ag-grid';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-application-grid',
  templateUrl: './application-grid.component.html',
  styleUrls: ['./application-grid.component.css']
})
export class ApplicationGridComponent implements OnInit {

  private gridOptions: GridOptions;

  constructor(private http: HttpClient) {
    console.log('Waheguru: Application');
    this.gridOptions = <GridOptions>{
      enableSorting: true,
      enableFilter: true,
      rowSelection: 'multiple',
      animateRows: true,
      pagination: true,
      floatingFilter: true,
      enableColResize: true,
      paginationPageSize: 10,

    };

    this.gridOptions.columnDefs = [
    
      {
        headerName: 'Application Name',
        field: 'applicationName',
        width: 200
      },
      {
        headerName: 'Server Name',
        field: 'serverName',
        width: 200
      },
      {
        headerName: 'Port',
        field: 'port',
        width: 200
      },
      {
        headerName: 'Application Enviornment',
        field: 'applicationEnviornment',
        width: 200
      },
      {
        headerName: 'Status',
        field: 'status',
        width: 200,
        cellStyle: function(params) {
          if (params.value === true) {
            return {

              backgroundColor: 'YellowGreen'
            };


          } else {
            return {backgroundColor: 'OrangeRed'};
          }
        }
      }
    ];
    this.http.get('http://localhost:8080/applications').subscribe(data => {
      console.log('I CANT SEE DATA HERE:', data);
      this.gridOptions.api.setRowData(data['allApplication']);
    });
  }
  ngOnInit() {
  }

}
