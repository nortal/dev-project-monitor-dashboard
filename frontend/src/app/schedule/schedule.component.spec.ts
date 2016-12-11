import { TestBed } from '@angular/core/testing';
import { ScheduleComponent } from './schedule.component';

describe('Schedule Component', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({declarations: [ScheduleComponent]});
    });

    it('should ...', () => {
        const fixture = TestBed.createComponent(ScheduleComponent);
        fixture.detectChanges();
        expect(fixture.nativeElement.children[0].textContent).toContain('Schedule');
    });

});
