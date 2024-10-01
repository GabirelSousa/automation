class ExamplePage {
    openExamplePage(){
        cy.visit('https://practice-automation.com')
    }

    assertUrl(){
        cy.url().should('contain', 'https://practice-automation.com')
    }

}

export default ExamplePage