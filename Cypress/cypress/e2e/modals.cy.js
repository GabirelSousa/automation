/// <reference types = "Cypress"/>

describe('template spec', () => {

  beforeEach(() => {
    cy.visit('https://practice-automation.com')
    cy.get('[class="wp-block-button__link wp-element-button"]').contains('Modals').click()
    cy.get('h1').should('contain.text', 'Modals')
  })

  it('Test simple modal', () => {
    cy.get('[id="simpleModal"]').click()
    cy.get('#pum_popup_title_1318').contains('Simple Modal').should('be.visible')
    cy.get('p').should('contain.text', "Hi, I’m a simple modal.")
    cy.get('[class="pum-close popmake-close"]').click({ multiple: true, force: true })
    cy.get('#pum_popup_title_1318').contains('Simple Modal').should('not.be.visible')
  })

  it.only('Test form modal', () => {
    cy.get('#formModal').click()
    cy.get('#pum_popup_title_674').should('be.visible')
    cy.get('#g1051-name').type('Gabriel')
    cy.get('#g1051-email').type('gabriel@test.com')
    cy.get('#contact-form-comment-g1051-message').type('This is a message')
    cy.get('.pushbutton-wide').click()
    cy.get('#pum_popup_title_674').should('not.be.visible')

    cy.get('#formModal').click()
    cy.get('#pum_popup_title_674').should('be.visible')
    cy.get('#g1051-name').type('Gabriel')
    cy.get('#g1051-email').type('gabriel@test.com')
    cy.get('#contact-form-comment-g1051-message').type('This is a message')
    cy.get('[class="pum-close popmake-close"]').click({ multiple: true, force: true })
    cy.get('#pum_popup_title_674').should('not.be.visible')
  })
})