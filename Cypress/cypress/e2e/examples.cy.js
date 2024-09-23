describe("Examples page", () => {
    beforeEach(() => {
        cy.visit('/examples')
    })
    it('multiple pages', () => {
        cy.getDataTest('nav-why-cypress').click()
        cy.location('pathname').should('equal', '/')

        cy.getDataTest('nav-overview').click()
        cy.location('pathname').should('equal', '/overview')

        cy.getDataTest('nav-fundamentals').click()
        cy.location('pathname').should('equal', '/fundamentals')

        cy.getDataTest('nav-forms').click()
        cy.location('pathname').should('equals', '/forms')

        cy.getDataTest('nav-examples').click()
        cy.location('pathname').should('equals', '/examples')

        cy.getDataTest('nav-component').click()
        cy.location('pathname').should('equals', '/component')

        cy.getDataTest('nav-best-practices').click()
        cy.location('pathname').should('equals', '/best-practices')

    })
    it('Intercept a html request', () => {
        cy.intercept("POST", 'http://localhost:3000/examples', {
            fixture: 'example.json'
        })
        cy.getDataTest('post-button').click()
    })
    it.only('Grudge list', () => {
        //Text field
        cy.getDataTest('text-field').find('input').as('text-field')
        //Add button
        cy.getDataTest('add-button').as('add-button')

        cy.inputText('text-field', 'sugar')
        cy.get('@add-button').click()
        cy.inputText('text-field', 'salt')
        cy.get('@add-button').click()
        cy.inputText('text-field', 'beans')
        cy.get('@add-button').click()
        cy.inputText('text-field', 'rice')
        cy.get('@add-button').click()
        cy.inputText('text-field', 'protein')
        cy.get('@add-button').click()

        cy.getDataTest('grudge-list').within(() => {
            cy.get('li').its(2).should('contain.text', 'beans').within(()=>{
                cy.getDataTest('delete-button').click()
            })
        })

        cy.getDataTest('clear-button').click()

    })
})
