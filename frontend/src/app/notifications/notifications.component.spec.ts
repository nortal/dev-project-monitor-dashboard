import { TestBed } from '@angular/core/testing';
import { NotificationsComponent } from './notifications.component';

describe('Notifications Component', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({declarations: [NotificationsComponent]});
    });

    it('should ...', () => {
        const fixture = TestBed.createComponent(NotificationsComponent);
        fixture.detectChanges();
        expect(fixture.nativeElement.children[0].textContent).toContain('Notifications');
    });

});
