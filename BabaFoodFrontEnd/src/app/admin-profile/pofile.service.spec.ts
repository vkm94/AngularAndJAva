import { TestBed } from '@angular/core/testing';

import { PofileService } from './pofile.service';

describe('PofileService', () => {
  let service: PofileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PofileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
