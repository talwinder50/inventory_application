import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServerGridComponentComponent } from './server-grid-component.component';

describe('ServerGridComponentComponent', () => {
  let component: ServerGridComponentComponent;
  let fixture: ComponentFixture<ServerGridComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServerGridComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServerGridComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
