import {Component, OnInit} from '@angular/core';
import {GridOptions} from 'ag-grid';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-server-grid-component',
  templateUrl: './server-grid-component.component.html',
  styleUrls: ['./server-grid-component.component.css']
})
export class ServerGridComponentComponent implements OnInit {
  private gridOptions: GridOptions;

  constructor(private http: HttpClient) {
    console.log('Waheguru: constructor');
    this.gridOptions = <GridOptions>{
      enableSorting: true,
      enableFilter: true,
      rowSelection: 'multiple',
      animateRows: true,
      pagination: true,
      floatingFilter: true,
      enableColResize: true,
      paginationPageSize: 20,

    };

    this.gridOptions.columnDefs = [
      {
        headerName: 'Server Name',
        field: 'serverName',
        width: 200,
        suppressSizeToFit: true
      },
      {
        headerName: 'Manager Name',
        field: 'managerName',
        width: 200
      },
      {
        headerName: 'Team',
        field: 'team',
        width: 200
      },
      {
        headerName: 'Envornment',
        field: 'enviornment',
        width: 200
      },
      {
        headerName: 'Server Jboss Version',
        field: 'serverJbossVersion',
        width: 200
      },
      {
        headerName: 'Tier',
        field: 'tier',
        width: 200
      },
      {
        headerName: 'Type',
        field: 'type',
        width: 200
      },
      {
        headerName: 'Patching Cycle',
        field: 'patchingCycle',
        width: 200
      },

    ];


    this.http.get('http://localhost:8180/servers?size=100000').subscribe(data => {
      console.log('I CANT SEE DATA HERE:', data);
      this.gridOptions.api.setRowData(data['allServer']);


    });
  }

    ngOnInit() {
      console.log('Waheguru: ngOnInit');
    }

  }
