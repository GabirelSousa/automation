/// <reference types = "Cypress"/>

import ExamplePage from "../../pages/ExamplePage"

describe('Files upload_download', () => {
  it('Upload', () => {
    const examplePage = new ExamplePage()
    examplePage.openExamplePage()
    cy.get('a').contains('File Upload').click()
    cy.getById('file-upload').selectFile('cypress/screenshots/Screenshot -- take full page screenshot.png')
    cy.wait(2000)
    cy.getById('upload-btn').click()
    cy.getByClass('wpcf7-response-output').should('be.visible')
    //Thank you for your message. It has been sent.
  })

  it('Download', () => {
    const examplePage = new ExamplePage()
    examplePage.openExamplePage()
  })
})