import { TestBed } from '@angular/core/testing';
import { DashboardComponent } from './dashboard.component';

describe('Dashboard Component', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({declarations: [DashboardComponent]});
  });

  it('should ...', () => {
    const fixture = TestBed.createComponent(DashboardComponent);
    fixture.detectChanges();
    expect(fixture.nativeElement.children[0].textContent).toContain('Dashboard');
  });

});