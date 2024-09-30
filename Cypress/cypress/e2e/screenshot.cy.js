/// <reference types = "Cypress"/>

describe('Screenshot', () => {
  it('take full page screenshot', () => {
    cy.visit('https://practice-automation.com')
    cy.screenshot({ overwrite: true })
  })

  it('take single element screenshot', () => {
    cy.visit('https://practice-automation.com')
    cy.get('h1').screenshot({overwrite:true
      
    })
  })
})