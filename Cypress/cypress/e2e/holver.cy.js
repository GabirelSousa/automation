/// <reference types = "Cypress"/>

describe('template spec', () => {

  beforeEach(() => {
    cy.visit('https://practice-automation.com')
    cy.get('[class="wp-block-button__link wp-element-button"]').contains('Hover').click()
    cy.get('h1').should('contain.text', 'Hover')
  })

  it('Hover workaround', () => {
    cy.get('#mouse_over').trigger('mouseover')
    cy.get('#mouse_over').should('contain.text', 'You did it!')
  })
})