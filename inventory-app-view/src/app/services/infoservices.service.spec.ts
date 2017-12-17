import { TestBed, inject } from '@angular/core/testing';

import { InfoservicesService } from './infoservices.service';

describe('InfoservicesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InfoservicesService]
    });
  });

  it('should be created', inject([InfoservicesService], (service: InfoservicesService) => {
    expect(service).toBeTruthy();
  }));
});
