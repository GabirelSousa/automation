/// <reference types = "Cypress"/>

describe('template spec', () => {
  it('Register', () => {
    cy.visit('https://parabank.parasoft.com/parabank/index.htm')
    cy.fixture('parabank.json').as('userData')
    cy.get('a').contains("Register").click()

    cy.get('h1').should("contain.text", "Signing up is easy!")

    cy.get('@userData').then((userData) => {
      cy.getById('customer.firstName').type(userData.first_name, { force: true })
      cy.getById('customer.lastName').type(userData.last_name, { force: true })
      cy.getById('customer.address.street').type(userData.address, { force: true })
      cy.getById('customer.address.city').type(userData.city, { force: true })
      cy.getById('customer.address.state').type(userData.state, { force: true })
      cy.getById('customer.address.zipCode').type(userData.zip_code, { force: true })
      cy.getById('customer.phoneNumber').type(userData.phone, { force: true })
      cy.getById('customer.ssn').type(userData.SSN, { force: true })
      cy.getById('customer.username').type(userData.user, { force: true })
      cy.getById('customer.password').type(userData.password, { force: true })
      cy.getById('repeatedPassword').type(userData.password, { force: true })
    })
    cy.getByClass('button').contains('Register').click()
    cy.get('h1').should('contain.text', 'Welcome')

  })

  it('Login', () => {
    cy.visit('https://parabank.parasoft.com/parabank/index.htm')
    cy.fixture('parabank.json').as('userData')
    cy.get('@userData').then((userData) => {
      cy.get('[name="username"]').type(userData.user, { force: true })
      cy.get('[name="password"]').type(userData.password, { force: true })
      cy.get('[value="Log In"]').click()
    })
    cy.get('h1').should('contain.text', 'Accounts Overview')
  })

  it('Log out', () => {
    cy.visit('https://parabank.parasoft.com/parabank/index.htm')
    cy.fixture('parabank.json').as('userData')
    cy.get('@userData').then((userData) => {
      cy.get('[name="username"]').type(userData.user, { force: true })
      cy.get('[name="password"]').type(userData.password, { force: true })
      cy.get('[value="Log In"]').click()
    })
    cy.get('h1').should('contain.text', 'Accounts Overview')
    cy.get('[href="logout.htm"]').click()
    cy.get('h2').should('contain.text','Customer Login')
  })

})