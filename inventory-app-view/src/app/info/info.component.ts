import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
   title = 'Info';

  constructor(private http: HttpClient) { }

  ngOnInit(): void{
    this.http.get('http://localhost:8180/servers').subscribe(data => {
      console.log('I CANT SEE DATA HERE:', data);
    });
    
}
}
