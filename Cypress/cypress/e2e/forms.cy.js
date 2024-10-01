/// <reference types = "Cypress"/>

describe('Forms Page', () => {

  beforeEach(() => {
    cy.visit('https://practice-automation.com')
    //class="wp-block-button__link wp-element-button"

  })

  it('Check page', () => {
    cy.get('[class="wp-block-button__link wp-element-button"]').contains('Form Fields').click()
    cy.get('h1').should('contains.text', 'Form Fields')
    cy.getById('feedbackForm').should('be.visible')

  })

  it.only('Submit and assert form', () => {
    cy.fixture('data.json').as('userData')
    cy.getByClass("wp-block-button__link wp-element-button").contains('Form Fields').click()
    //Fill the form
    cy.get('@userData').then((user) => {
      cy.getById('name-input').type(user.name)
      cy.get('[type="Password"]').type(user.password)
      cy.contains(user.drink).click()
      cy.get('[for="color3"]').contains(user.color).click()
      cy.get('select').select(user.automation)
      cy.wait(2000)
      cy.getById('email').type(user.email)
      cy.getById('message').type(user.message)

    })
    cy.getById('submit-btn').click()
    cy.getById('to-top').click()
  })
})