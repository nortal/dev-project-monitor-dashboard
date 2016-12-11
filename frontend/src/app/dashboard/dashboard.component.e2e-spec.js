describe('Dashboard', function () {

    beforeEach(function () {
        browser.get('/dashboard');
    });

    it('should have <my-home>', function () {
        var home = element(by.css('my-app my-dashboard'));
        expect(home.isPresent()).toEqual(true);
        expect(home.getText()).toEqual(`Dashboard
This is where all the modules are combined.
Separate modules configurations can be accessed from the menu.
Learn more`);
    });

});
