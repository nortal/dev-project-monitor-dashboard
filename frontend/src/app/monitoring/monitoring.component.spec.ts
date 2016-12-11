import { TestBed } from '@angular/core/testing';
import { MonitoringComponent } from './monitoring.component';

describe('Monitoring Component', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({declarations: [MonitoringComponent]});
  });

  it('should ...', () => {
    const fixture = TestBed.createComponent(MonitoringComponent);
    fixture.detectChanges();
    expect(fixture.nativeElement.children[0].textContent).toContain('Monitoring');
  });

});
