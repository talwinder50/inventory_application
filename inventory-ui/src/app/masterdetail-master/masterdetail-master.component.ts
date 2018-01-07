import {DetailPanelComponent} from '../detail-panel/detail-panel.component';
import {Component, OnInit, AfterViewInit} from '@angular/core';
import {GridOptions} from 'ag-grid';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-masterdetail-master',
  templateUrl: './masterdetail-master.component.html',
  styleUrls: ['./masterdetail-master.component.css']
})
export class MasterdetailMasterComponent implements AfterViewInit {
  public gridOptions: GridOptions;
  // private http: HttpClient;

  constructor(private http: HttpClient) {
    this.gridOptions = <GridOptions>{};
    this.gridOptions.rowData = this.createHardCodeRowData();
    this.gridOptions.columnDefs = this.createColumnDefs();
  }


  // parent col defs 
  private createColumnDefs() {
    return [
      //      {
      //        headerName: 'Name', field: 'name',
      //        // left column is going to act as group column, with the expand / contract controls
      //        cellRenderer: 'group',
      //        // we don't want the child count - it would be one each time anyway as each parent
      //        // not has exactly one child node
      //        cellRendererParams: {suppressCount: true},
      //        width: 225
      //      },
      //      {headerName: 'Account', field: 'account', width: 225},
      //      {headerName: 'Calls', field: 'totalCalls', width: 225},
      //      {headerName: 'Minutes', field: 'totalMinutes', valueFormatter: this.minuteCellFormatter, width: 225}

      {
        headerName: 'Application ID',
        field: 'applicationID',
        cellRenderer: 'group',
        cellRendererParams: {suppressCount: true},
        width: 200,
      },
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
  }


  public isFullWidthCell(rowNode) {
    return rowNode.level === 1;
  }

  // Sometimes the gridReady event can fire before the angular component is ready to receive it, so in an angular
  // environment its safer to on you cannot safely rely on AfterViewInit instead before using the API
  ngAfterViewInit() {
    this.gridOptions.api.sizeColumnsToFit();
  }

  public getFullWidthCellRenderer() {
    return DetailPanelComponent;
  }

  public getRowHeight(params) {
    var rowIsDetailRow = params.node.level === 1;
    // return 100 when detail row, otherwise return 25
    return rowIsDetailRow ? 200 : 25;
  }

  public getNodeChildDetails(record) {
    if (record.callRecords) {
      return {
        group: true,
        // the key is used by the default group cellRenderer
        key: record.applicationID,
        // provide ag-Grid with the children of this group
        children: [record.callRecords],
        // for demo, expand the third row by default
        expanded: record.applicationID
      };
    } else {
      return null;
    }
  }

  private createHardCodeRowData() {
    const rowData =
      [
        {
          applicationID: '1',
          applicationName: 'CSP UAT',
          serverName: 'mrkcspbtvlut01',
          port: 8180,
          applicationEnviornment: 'UAT',
          status: true,
          callRecords:
          [
            {
              applicationID: '1',
              applicationName: 'CSP PT',
              serverName: 'mrkcspbtvlut01',
              port: 8180,
              applicationEnviornment: 'UAT',
              status: true,
            },
            {
              applicationID: '1',
              applicationName: 'CSP UAT',
              serverName: 'mrkcspbtvlut01',
              port: 8180,
              applicationEnviornment: 'UAT',
              status: true,
            }
          ]
        }
      ];
    return rowData;
  }

  // TODO:parent data - use data from original component - rest api call 
  private createRowData() {
    // Final array response
    let rowData: any[] = [];

    // parent
    let allApplications: any[] = [];
    this.http.get('http://localhost:8180/applications').subscribe(data => {
      allApplications = data['allApplication'];
      console.log('All Applications', allApplications);
      let totalApps = allApplications.length;
      console.log('Total parent apps', totalApps);

      for (let i = 0; i < totalApps; i++) {
        // all apps in single parent
        let callRecords = [];
        this.http.get('http://localhost:8180/applications').subscribe(dependencies => {
          callRecords = dependencies['allApplication'];
          console.log('All Dependencies', callRecords);
          console.log('All Dependencies length', callRecords.length);

          let record = {
            applicationID: allApplications[i].applicationID,
            serverName: allApplications[i].serverName,
            port: 23,
            callRecords: callRecords
          };
          rowData.push(record);
        });

      }
      console.log('Final rows in', rowData);
      console.log('total rows in', rowData.length);
    });

    console.log('Final rows', rowData);
    console.log('First row', rowData[0]);
    console.log('total app', allApplications.length);
    return rowData;
    /* for (let i = 0; i < 20; i++) {
       let firstName = this.firstnames[Math.floor(Math.random() * this.firstnames.length)];
       let lastName = this.lastnames[Math.floor(Math.random() * this.lastnames.length)];

       let image = this.images[i % this.images.length];
 
       let totalDuration = 0;
 
       let callRecords = [];
       // call count is random number between 20 and 120
       let callCount = Math.floor(Math.random() * 100) + 20;
       for (let j = 0; j < callCount; j++) {
         // duration is random number between 20 and 120
         let callDuration = Math.floor(Math.random() * 100) + 20;
         //TODO - api call for backend to pull child data
         let callRecord = {
           serverName: this.callIdSequence++,
           applicationName: callDuration,
           switchCode: 'SW' + Math.floor(Math.random() * 10),
           // 50% chance of in vs out
           direction: (Math.random() > .5) ? 'In' : 'Out',
           // made up number
           number: '(0' + Math.floor(Math.random() * 10) + ') ' + Math.floor(Math.random() * 100000000)
         };
         callRecords.push(callRecord);
         totalDuration += callDuration;
       }
 
       let record = {
         name: firstName + ' ' + lastName,
         account: i + 177000,
         totalCalls: callCount,
         image: image,
         // convert from seconds to minutes
         totalMinutes: totalDuration / 60,
         callRecords: callRecords
       };
       rowData.push(record);
     }*/

  }

  private minuteCellFormatter(params) {
    return params.value.toLocaleString() + 'm';
  };


  // a list of names we pick from when generating data
  private firstnames: string[] = ['Sophia', 'Emma', 'Olivia', 'Isabella', 'Mia', 'Ava', 'Lily', 'Zoe', 'Emily', 'Chloe', 'Layla', 'Madison', 'Madelyn', 'Abigail', 'Aubrey', 'Charlotte', 'Amelia', 'Ella', 'Kaylee', 'Avery', 'Aaliyah', 'Hailey', 'Hannah', 'Addison', 'Riley', 'Harper', 'Aria', 'Arianna', 'Mackenzie', 'Lila', 'Evelyn', 'Adalyn', 'Grace', 'Brooklyn', 'Ellie', 'Anna', 'Kaitlyn', 'Isabelle', 'Sophie', 'Scarlett', 'Natalie', 'Leah', 'Sarah', 'Nora', 'Mila', 'Elizabeth', 'Lillian', 'Kylie', 'Audrey', 'Lucy', 'Maya'];
  private lastnames: string[] = ['Smith', 'Jones', 'Williams', 'Taylor', 'Brown', 'Davies', 'Evans', 'Wilson', 'Thomas', 'Johnson'];

  private images: string[] = ['niall', 'sean', 'alberto', 'statue', 'horse'];

  // each call gets a unique id, nothing to do with the grid, just help make the sample
  // data more realistic
  private callIdSequence: number = 555;


}