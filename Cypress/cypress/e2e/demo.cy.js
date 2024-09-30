/// <reference types = "Cypress"/>

describe('Cypress E2E testing demo', () => {
  beforeEach(() => {
    cy.visit('https://practice-automation.com')
  })

  it('Assert URL', () => {
    cy.url().should('equal', 'https://practice-automation.com/')
  })

  it('Assert title', () => {
    cy.get('h1').should('be.visible')
  })

  it('Assert elements', () => {
    cy.log('Aqui comeca um log')
    cy.get('a').should('contain.text','JavaScript Delays')
    cy.get('a').should('contain.text','Form Fields')
    cy.get('a').should('contain.text','Popups')
    cy.log('Aqui termina um log')
  })

  
})