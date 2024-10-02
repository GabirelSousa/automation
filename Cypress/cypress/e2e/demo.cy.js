/// <reference types = "Cypress"/>

import ExamplePage from "../../pages/ExamplePage"

describe('Cypress E2E testing demo', () => {
  beforeEach(() => {
    const examplePage = new ExamplePage()
    examplePage.openExamplePage()
  })

  it('Assert URL', () => {
    const examplePage = new ExamplePage()
    examplePage.assertUrl()
    
  })

  it('Assert title', () => {
    cy.get('h1').should('be.visible')
  })

  it('Assert elements', () => {
    cy.log('Aqui comeca um log')
    cy.get('a').should('contain.text','JavaScript Delays')
    cy.get('a').should('contain.text','Form Fields')
    cy.get('a').should('contain.text','Popups')
    cy.get('footer').scrollIntoView().should('contain.text','About')
    cy.log('Aqui termina um log')
  })

  
})