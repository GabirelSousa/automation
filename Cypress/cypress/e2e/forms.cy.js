/// <reference types = "Cypress"/>

describe('Forms Page', () => {

  beforeEach(() => {
    cy.visit('https://practice-automation.com')
    //class="wp-block-button__link wp-element-button"

  })

  it('Check page', () => {
    cy.get('[class="wp-block-button__link wp-element-button"]').contains('Form Fields').click()
    cy.get('h1').should('contains.text', 'Form Fields')
    cy.get('[id="feedbackForm"]').should('be.visible')

  })

  it.only('Submit and assert form', () => {
    cy.get('[class="wp-block-button__link wp-element-button"]').contains('Form Fields').click()
    //Fill the form
    cy.get('#name-input').type("Gabriel")
    cy.get('[type="Password"]').type("123123")
    cy.contains('Water').click()
    cy.get('[for="color1"]').contains('Red').click()
    cy.get('select').select(2)
    cy.wait(3000)
    cy.get('#email').type('gabriel@gmail.com')
    cy.get('#message').type('This is a message from Gabriel')
    cy.get('#submit-btn').click()
    cy.get('#to-top').click()


  })
})